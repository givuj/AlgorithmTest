public class Code10 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        return  f(word1,word2,word1.length(),word2.length(),dp);
    }
    public  int f(String word1, String word2,int i,int j,int[][] dp)
    {
        if(dp[i][j] != 0)
        {
            return dp[i][j];
        }
        if(i==0)
        {
            dp[i][j] = j;
            return j;
        }
        if (j==0)
        {
            dp[i][j] = i;
            return i;
        }
        if(word1.charAt(i-1)==word2.charAt(j-1))
        {
            dp[i][j] = f(word1, word2, i - 1, j - 1, dp);

        }
        else
        {
            int replace = f(word1,word2,i-1,j-1,dp);
            int delete = f(word1,word2,i-1,j,dp);
            int add = f(word1,word2,i,j-1,dp);
            dp[i][j] =  Math.min(Math.min(replace, delete), add) + 1;
        }
        return dp[i][j];
    }

}
