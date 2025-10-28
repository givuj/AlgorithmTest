public class Code12 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        return  f(n,dp);
    }
    public int f(int n, int[] dp) {
        if(dp[n] != 0) return dp[n];
        if(n==1)
        {
            return 0;
        }
        if (n==2)
        {
            dp[n] = 1;
            return dp[n];
        }
        for (int i=1;i<n;i++)
        {
            int temp = Math.max(i*(n-i),f(n-i,dp)*i);
            if(temp>dp[n])
            {
                dp[n] = temp;
            }
        }
        return dp[n];
    }
}
