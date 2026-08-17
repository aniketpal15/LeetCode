class Solution {
    private int[][] dp;
    private int[] prefix;
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        prefix = new int[n];
        prefix[0] =stoneValue[0];
        for(int i=1;i<n;i++ ){
            prefix[i] = prefix[i-1]+ stoneValue[i];
        }

        dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] =-1;
            }
        }
        return solve(0, n-1, stoneValue);
        
    }

    public int solve(int l,int r,int[] stonevalue){
       if(l== r) return 0;

       if(dp[l][r]!=-1){
        return dp[l][r];
       }

       int score=0;
       for(int i=l;i<r;i++){
        int lsum = prefix[i] -prefix[l] + stonevalue[l];
        int rsum =  prefix[r] -prefix[i];


        if(lsum < rsum) score = Math.max(score,lsum + solve(l, i, stonevalue) );
        else if(rsum<lsum) score = Math.max(score,rsum + solve(i+1, r, stonevalue) );
        else score = Math.max(score, Math.max(lsum + solve(l, i, stonevalue), rsum + solve(i+1, r, stonevalue)));
       }

       return dp[l][r]=score;
    }
}