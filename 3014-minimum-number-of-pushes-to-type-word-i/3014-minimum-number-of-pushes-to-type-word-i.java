class Solution {
    public int minimumPushes(String word) {
       int l = word.length();
        int ans=0;
        int i;
        for( i=1;i<=l/8;i++){
            ans =ans+(i*8);
        }
         ans = ans +(i*(l%8));
        return ans;
    }
}