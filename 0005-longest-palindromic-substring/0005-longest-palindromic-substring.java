class Solution {
     public String longestPalindrome(String s) {
      if (s == null || s.length() < 1) return "";
      int len = s.length();
      Boolean dp[][]  = new Boolean[len][len];
      StringBuilder ans = new StringBuilder();

      int maxlen=0;
      int startidx=0;

      for(int i=0;i<len;i++){
        for(int j=i;j<len;j++){
            if(pal(s, i, j, dp)){
                if(j-i+1>maxlen){
                    maxlen = j-i+1;
                    startidx=i;
                }
            }
        }
      }


      return s.substring(startidx,maxlen+startidx);


    }

    public static boolean pal(String s , int start, int end, Boolean dp[][]){
        if(start>=end){
            return true;
        }

        if(dp[start][end]!=null){
           return dp[start][end];
        }
          if(s.charAt(end)==s.charAt(start)){
            return dp[start][end]=pal(s, start+1, end-1,dp);
          }else{
            return dp[start][end]= false;
          }
    }
}