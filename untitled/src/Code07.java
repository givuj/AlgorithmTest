import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.sort;

public class Code07 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            {
                if(i>0&&nums[i]==nums[i-1]) continue;
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    List<Integer> temp = new ArrayList<>();
                    if(nums[i]+nums[left]+nums[right]==0) {
                        temp.add(nums[i]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        ans.add(temp);
                        while (nums[right] == nums[right-1]&&left<right)
                        {
                            right--;
                        }
                        while (nums[left] == nums[left+1]&&left<right)
                        {
                            left++;
                        }
                        right--;
                        left++;
                    }
                    else if(nums[i]+nums[left]+nums[right]>0) {
                        right--;
                    }
                    else {
                        left++;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        threeSum(nums);
    }
}
