import java.util.Arrays;
import java.util.HashMap;

public class Code24 {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int right = 0;
        int n = nums.length;
        int maxLen = 1;
        for (int left = 0; left < n; left++) {
            while(right < n && nums[right]<=(long)nums[left]*k) {
                    right++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return n-maxLen;
    }
}
