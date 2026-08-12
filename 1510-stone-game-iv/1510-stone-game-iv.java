class Solution {
     Boolean dp[] = new Boolean[100000+1];
    
    public boolean winnerSquareGame(int n) {
        if(dp[n]!= null){
          return dp[n];
        }
       boolean ans = false;
        for(int move =1;n>=move*move;move++ ){
            if (!winnerSquareGame(n - move * move)) {
                return dp[n] = true;
            }
        }

        return dp[n]=false;
    }
}