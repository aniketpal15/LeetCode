class Solution {
    public int uniquePaths(int m, int n) {
       int r = Math.min(m - 1, n - 1);
        int N = m + n - 2;
        long res = 1;
        for (int i = 1; i <= r; i++) {
           res = res * (N - r + i) / i;
        }
        return (int) res;
    }
    public static void main(String args[]){
       Solution up = new Solution();
       int m=3,n=7;
       System.out.println(up.uniquePaths(m,n));

    }
}