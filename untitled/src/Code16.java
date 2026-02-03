public class Code16 {
    public boolean isTrionic(int[] nums) {
        if (nums == null || nums.length < 4 || nums[0]>nums[1]) {
            return false;
        }
        boolean isIncreasing = true;
        int changTimes = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
            return false;
            }
            if(isIncreasing) {
                if(nums[i] > nums[i+1]) {
                    changTimes++;
                    isIncreasing = false;
                }
            }
            else {
                if(nums[i] < nums[i+1]) {
                    changTimes++;
                    isIncreasing = true;
                    if(changTimes > 2) {
                        return false;
                    }
                }
            }
        }
        return isIncreasing&&changTimes==2;
    }
}
