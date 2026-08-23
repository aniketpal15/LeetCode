class Solution {
    public boolean sumGame(String num) {
          int n = num.length();
        int q =0;
        int leftq=0;
        int rightq =0;
        int leftsum =0;
        int rightsum = 0;
        for(int i=0;i<n;i++){
           if(num.charAt(i)=='?'){
            q++;
            if(i<n/2){
                leftq++;
            }else{
                rightq++;
            }
           }else{
            if(i<n/2){
                leftsum+= num.charAt(i)-'0';
            }else{
                rightsum+=  num.charAt(i)-'0';
            }
           }
        }






        if(q%2==1){
            return true;
        }



        int left = 2*leftsum + 9*leftq;
        int right = 2*rightsum + 9*rightq;

        if(left == right ){
            return false;
        }else{
            return true;
        }
    }
}