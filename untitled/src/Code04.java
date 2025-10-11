import java.util.Stack;

public class Code04 {
    public static int reverse(int x) {
        if(x==0)
        {
            return 0;
        }
        int ans = 0;
        int carry = 0;
        //看符号
        if(x<0)
        {
            x = -x;
            carry = -1;
        }
        else
        {
            carry = 1;
        }
        //把数字放入栈中
        Stack<Integer> stack = new Stack<>();
        //拆分x
        while(x!=0)
        {
            int digit = x%10;
            x=x/10;
            stack.push(digit);
        }
        //拿出stack给ans
        int digit = stack.pop();
        ans = digit;
        int n = 1;
        while(!stack.isEmpty())
        {
            digit = stack.pop();
            double number = Math.pow(10,n);
            n++;
            ans = (int) (digit*number + ans);
        }
        if(carry == -1)
        {
            ans = ans*-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 1534236469;
        System.out.println(reverse(n));
    }
}
