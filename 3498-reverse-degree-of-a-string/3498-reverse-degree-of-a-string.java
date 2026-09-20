class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            ans = ans + (('z'-s.charAt(i)+1)*(i+1));
        }


        return ans;
    }
}