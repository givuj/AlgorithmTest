import java.util.Deque;
import java.util.LinkedList;

public class Code02 {
    public static int countSubarrays(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int n = arr.length;
        Deque<Integer> qmin = new LinkedList<>(); // 维护最小值的下标，单调递增队列
        Deque<Integer> qmax = new LinkedList<>(); // 维护最大值的下标，单调递减队列
        int res = 0;
        int R = 0;

        for (int L = 0; L < n; L++) {
            // 扩展右端点 R
            while (R < n) {
                // 更新 qmin：移除队尾所有 >= arr[R] 的元素，保证队列递增
                while (!qmin.isEmpty() && qmin.peekLast()>= arr[R]) {
                    qmin.pollLast();
                }
                qmin.offerLast(arr[R]);

                // 更新 qmax：移除队尾所有 <= arr[R] 的元素，保证队列递减
                while (!qmax.isEmpty() && qmax.peekLast() <= arr[R]) {
                    qmax.pollLast();
                }
                qmax.offerLast(arr[R]);

                // 检查当前窗口的最大值与最小值的差
                int currentMax = qmax.peekFirst();
                int currentMin = qmin.peekFirst();
                if (currentMax - currentMin > num) {
                    break; // 窗口不合法，停止扩展 R
                }
                R++;
            }

            // 统计以 L 为左端点的合法子数组数量
            res += R - L;

            // 窗口左端点右移，移除可能过期的元素
            if (qmin.peekFirst() == arr[L]) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == arr[L]) {
                qmax.pollFirst();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        int num = 5;
        System.out.println("满足条件的子数组数量: " + countSubarrays(arr, num)); // 输出应为 15
    }
}
