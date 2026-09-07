class Solution {
    public int distinctSubseqII(String s) {
         int MOD = 1_000_000_007;
        long total = 0;
        long[] lastAdded = new long[26];
        
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long newAdded = (total + 1) % MOD;
            total = (total + newAdded - lastAdded[idx] + MOD) % MOD;
            lastAdded[idx] = newAdded;
        }
        
        return (int) total;
    }
}