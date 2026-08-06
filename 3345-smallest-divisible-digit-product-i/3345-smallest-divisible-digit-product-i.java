class Solution {
    public int smallestNumber(int n, int t) {
       while((multi(n))%t!=0){
            n++;
        }

        return n;
    }



    public int multi(int n){
       int ans=1;
        while(n!=0){
            ans = ans *(n%10);
            n= n/10;
        }

        return ans; 
    }
}