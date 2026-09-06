class Solution {
     int[][] ans;
    public int numDistinct(String s, String t) {
        ans = new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<t.length();j++){
                ans[i][j] =-1;
            }
        }

        return solve(s, t, 0, 0);
    }
    public int solve(String s, String t,int i,int j) {
        int n = s.length();
        int m = t.length();

        

        if(j>=t.length()){
            return 1;
        }

        if(i>= s.length()){
            return 0;
        }
        if(ans[i][j]!=-1){
            return ans[i][j];
        }


        if(s.charAt(i)!= t.charAt(j)){
            return ans[i][j]= solve(s, t, i+1, j);
        }else{
           return ans[i][j]=solve(s, t, i+1, j++) + solve(s, t, i+1, j);
        } 
    }
}