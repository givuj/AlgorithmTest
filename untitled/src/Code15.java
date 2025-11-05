import java.util.Arrays;

public class Code15 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 初始目标值超出范围，直接返回0
        if (target < -sum || target > sum) {
            return 0;
        }
        int offset = sum;
        int[][] dp = new int[nums.length + 1][2 * sum + 1];
        // 初始化所有行为-1
        for (int i = 0; i <= nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(nums, target, 0, dp, offset, sum);
    }

    public int f(int[] nums, int target, int index, int[][] dp, int offset, int sum) {
        // 计算当前target对应的数组列索引
        int curr = target + offset;
        // 若列索引超出范围，直接返回0
        if (curr < 0 || curr >= 2 * sum + 1) {
            return 0;
        }
        // 若已缓存结果，直接返回
        if (dp[index][curr] != -1) {
            return dp[index][curr];
        }
        // 递归终止条件
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }
        // 计算“加当前数”的分支（新target需合法）
        int newTargetA = target - nums[index];
        int a = (newTargetA >= -sum && newTargetA <= sum)
                ? f(nums, newTargetA, index + 1, dp, offset, sum)
                : 0;
        // 计算“减当前数”的分支（新target需合法）
        int newTargetB = target + nums[index];
        int b = (newTargetB >= -sum && newTargetB <= sum)
                ? f(nums, newTargetB, index + 1, dp, offset, sum)
                : 0;
        // 缓存当前状态结果
        dp[index][curr] = a + b;
        return dp[index][curr];
    }
}
