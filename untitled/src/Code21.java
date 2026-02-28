public class Code21 {
    public int longestBalanced(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLength = 0;
        char[] chars = s.toCharArray();
        int n = chars.length;

        // 修正1：外层循环遍历所有起点 i（从0到n-1）
        for (int i = 0; i < n; i++) {
            int[] count = new int[26];
            // 修正2：删除冗余的 tempSum 和 tempMaxLength
            for (int j = i; j < n; j++) {
                count[chars[j] - 'a']++;
                if (isBalanced(count)) {
                    // 修正3：直接用 j - i + 1 计算当前子串长度
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    // isBalanced 函数逻辑正确，无需修改
    boolean isBalanced(int[] count) {
        int pre = -1;
        for (int num : count) {
            if (num == 0) {
                continue;
            }
            if (pre == -1) {
                pre = num;
            } else if (num != pre) {
                return false;
            }
        }
        return true;
    }
}
