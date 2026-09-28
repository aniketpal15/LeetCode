class Solution {
    public int maxDepth(String s) {
        int n=s.length();
        int curr=0;
        int max=0;

        for(int i=0;i<n;i++){
        char c= s.charAt(i);
        if(c=='('){
            curr++;
            max=Math.max(max, curr);
        }else if(c==')'){
            curr--;
        }else{
            continue;
        }
        }

        return max;
    }
}