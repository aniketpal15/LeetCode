class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int prevrun =-1;
        int max = 0;
        int ones=0;

        int i=0;
        while(i<n){
            if(s.charAt(i) =='1'){
                ones++;
                i++;
            }else{
                int curr =0;
                while(i<n && s.charAt(i) =='0'){
                   curr++;
                   i++;
                }
                if(prevrun>0){
                        max =Math.max(max, prevrun+curr);
                }
                prevrun =curr;
            }
        }

        return max+ones;
    }
}