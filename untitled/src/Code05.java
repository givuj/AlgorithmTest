import java.util.Arrays;

public class Code05 {
    public static int  threeSumClosest(int[] nums, int target) {
        //排序
        Arrays.sort(nums);
        //最近数字
        int MinToTarget = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length - 2; i++)
        {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while (left < right)
            {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target) {
                    return target;
                }
                if(Math.abs(sum - target) < Math.abs(MinToTarget - target) ) {
                    MinToTarget = sum;
                }
                if(sum > target)
                {
                    right--;
                    while(left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                }
                else
                {
                    left++;
                    while(left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                }

            }
        }
        return MinToTarget;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 0, 1, 2, -1, -4}, 3));
    }
}


