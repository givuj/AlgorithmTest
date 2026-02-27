import java.util.HashSet;

public class Code20 {
    public int longestBalanced(int[] nums) {
        int max = 0;
        for (int i : nums) {
            HashSet<Integer> evenSet = new HashSet<>();
            HashSet<Integer> oddSet = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                if(nums[j] % 2 == 0) {
                    evenSet.add(j);
                }
                else
                {
                    oddSet.add(j);
                }
                if(evenSet.size() == oddSet.size())
                {
                    int currentLength = j-i+1;
                    max = Math.max(max, currentLength);
                }
            }
        }
        return max;
    }
}
