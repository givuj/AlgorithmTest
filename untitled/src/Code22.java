import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Code22 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // 关键优化1：先对数组排序，方便后续剪枝和去重
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        backtrack(nums, target, ans, list, 0, 0);
        return ans;
    }
    public void backtrack(int[] nums, int target,List<List<Integer>> ans,List<Integer> list,int index,int count) {
        if(count==4)
        {

            if (target == 0) {
                ans.add(new ArrayList<>(list)); // 修正2：添加副本
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if(nums.length-i<4-count)
            {
                break;
            }
            if(i>index&&nums[i]==nums[i-1])
            {
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, target-nums[i], ans, list, i+1, count+1);
            list.remove(list.size()-1);
        }

    }

}
