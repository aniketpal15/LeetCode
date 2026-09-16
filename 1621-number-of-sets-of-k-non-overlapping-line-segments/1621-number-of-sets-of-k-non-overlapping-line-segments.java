class Solution {
    public int numberOfSets(int n, int k) {
        long MOD = 1_000_000_007;
        int N = n + k - 1;
        int R = 2 * k;

        // Calculate C(N, R) % MOD
        long numerator = 1;
        long denominator = 1;

        for (int i = 1; i <= R; i++) {
            numerator = (numerator * (N - i + 1)) % MOD;
            denominator = (denominator * i) % MOD;
        }

        // Divide numerator by denominator using Fermat's Little Theorem
        return (int) ((numerator * modInverse(denominator, MOD)) % MOD);
    }

    private long modInverse(long a, long m) {
        return power(a, m - 2, m);
    }

    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}