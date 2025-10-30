public class Code14 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j <= coins.length; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i <= coins.length; i++)
        {
            dp[0][i] = 1;
        }
        return f(amount,coins,0,dp);
    }
    public int f(int amount,int[] coins,int index,int[][] dp )
    {
        if(amount<0)
        {
            return 0;
        }
        if(dp[amount][index] != -1)
        {
            return dp[amount][index];
        }
        if(index==coins.length)
        {
            return 0;
        }


        int a = 0;

        int c = 0;

        a = f(amount,coins,index+1,dp);

        c = f(amount-coins[index],coins,index,dp);
        dp[amount][index]=(a+c);

        return dp[amount][index];
    }
}
