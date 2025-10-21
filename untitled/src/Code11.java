import java.util.Arrays;

public class Code11 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return  f(nums,target,dp);
    }
    public int f(int[] nums, int target,int[] dp) {
        if(target < 0)
        {
            return 0;
        }
        if(target == 0)
        {
            dp[0] = 1;
            return dp[0];
        }
        if(dp[target] != -1)
        {
            return dp[target];
        }
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            res += f(nums,target-nums[i],dp);

        }
        dp[target]= res;
        return res;
    }
}
