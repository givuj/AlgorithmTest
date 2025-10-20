import java.util.List;

public class Code09 {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int ans = 0;
        int pre = 0;
        int cur = 0;
        for (int i = 0; i < nums.size(); i++) {
            cur++;
            if(i==nums.size()-1 || nums.get(i) >= nums.get(i + 1)){
                ans = Math.max(ans, Math.max(cur/2,Math.min(pre,cur)));
                pre = cur;
                cur = 0;
            }

        }
        return ans;
    }
}
