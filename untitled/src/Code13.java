import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Long, Integer> memo = new HashMap<>();

    public int integerReplacement(int n) {
        return f((long) n); // 转为long避免溢出
    }

    private int f(long num) {
        if (num == 1) {
            return 0;
        }
        if (memo.containsKey(num)) {
            return memo.get(num);
        }
        int res;
        if (num % 2 == 0) {
            res = f(num / 2) + 1;
        } else {
            // 奇数时计算n+1和n-1，因num是long，不会溢出
            res = Math.min(f(num + 1), f(num - 1)) + 1;
        }
        memo.put(num, res);
        return res;
    }
}