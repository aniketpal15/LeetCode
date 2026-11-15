class Solution {
    public int numOfSubarrays(int[] arr) {
        long oddCount = 0, evenCount = 1; // evenCount = 1 to account for base prefix sum 0
        long currentSum = 0;
        long ans = 0;
        int MOD = 1_000_000_007;

        for (int num : arr) {
            currentSum += num;
            
            if (currentSum % 2 == 0) {
                ans = (ans + oddCount) % MOD;
                evenCount++;
            } else {
                ans = (ans + evenCount) % MOD;
                oddCount++;
            }
        }
        
        return (int) ans;
    }
}