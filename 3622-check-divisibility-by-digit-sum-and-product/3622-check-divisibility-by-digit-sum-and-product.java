class Solution {
    public boolean checkDivisibility(int n) {
        int t = n;
        int sum =0;
        int product =1;
        while(t!=0){
            int b = t%10;
            sum = sum + b;
            product = product * b;
            t = t/10;

        }

        return n%(sum + product)==0;
    }
}