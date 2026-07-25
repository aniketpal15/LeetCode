class Solution {
    public int climbStairs(int n) {
        if(n==1||n==2||n==3){
            return n;
        }
        int prev1 = 3;
        int prev2 = 2;
        int cur = 0;

        for (int i = 3; i < n; i++) {
            cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }

        return cur; 
    }
    public static void main(String args[]){
        Solution cs = new Solution();
        int n=5;
        System.out.println(cs.climbStairs(n));
    }
}