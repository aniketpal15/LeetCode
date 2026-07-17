/*
3312. Sorted GCD Pair Queries
Hard
Topics
premium lock icon
Companies
Hint
You are given an integer array nums of length n and an integer array queries.

Let gcdPairs denote an array obtained by calculating the GCD of all possible pairs (nums[i], nums[j]), where 0 <= i < j < n, and then sorting these values in ascending order.

For each query queries[i], you need to find the element at index queries[i] in gcdPairs.

Return an integer array answer, where answer[i] is the value at gcdPairs[queries[i]] for each query.

The term gcd(a, b) denotes the greatest common divisor of a and b.

 

Example 1:

Input: nums = [2,3,4], queries = [0,2,2]

Output: [1,2,2]

Explanation:

gcdPairs = [gcd(nums[0], nums[1]), gcd(nums[0], nums[2]), gcd(nums[1], nums[2])] = [1, 2, 1].

After sorting in ascending order, gcdPairs = [1, 1, 2].

So, the answer is [gcdPairs[queries[0]], gcdPairs[queries[1]], gcdPairs[queries[2]]] = [1, 2, 2].

Example 2:

Input: nums = [4,4,2,1], queries = [5,3,1,0]

Output: [4,2,1,1]

Explanation:

gcdPairs sorted in ascending order is [1, 1, 1, 2, 2, 4].

Example 3:

Input: nums = [2,2], queries = [0,0]

Output: [2,2]

Explanation:

gcdPairs = [2].

 

Constraints:

2 <= n == nums.length <= 105
1 <= nums[i] <= 5 * 104
1 <= queries.length <= 105
0 <= queries[i] < n * (n - 1) / 2
*/


public class SortedGCDPairQueries {
    public int[] gcdValues(int[] nums, long[] queries) {
        int m = 0;
        for(int num : nums)
            m = Math.max(m, num);

        // Frequency of each value
        long count[] = new long[m+1];
        for(int num : nums) {
            count[num]++;
        }

        // gcdPairs[i] = number of pairs whose gcd is a multiple of i
        long gcdPairs[] = new long[m+1];
        for(int i=1; i<=m; i++) {
            // Total elements divisible by i (harmonic sum -> O(m log m) overall)
            for(int j=i; j<=m; j+=i) {
                gcdPairs[i] += count[j];
            }
            // Any 2 of them form a pair whose gcd is divisible by i: C(c, 2)
            gcdPairs[i] = (gcdPairs[i]*(gcdPairs[i]-1))/2;
        }

        // Sweep downward so gcdPairs[j] is already exact; subtracting multiples
        // leaves only the pairs whose gcd is exactly i
        for(int i=m; i>=1; i--) {
            for(int j=2*i; j<=m; j+=i) {
                gcdPairs[i] -= gcdPairs[j];
            }
        }

        // presum[i] = number of pairs with gcd <= i, i.e. the sorted gcd list's cumulative counts
        long presum[] = new long[m+1];
        for(int i=1; i<=m; i++) {
            presum[i] = presum[i-1] + gcdPairs[i];
        }

        int ans[] = new int[queries.length];

        for(int i=0; i<queries.length; i++) {
            long k = queries[i] + 1; // 0-indexed query -> 1-indexed rank
            // Binary search for the smallest gcd value whose cumulative count reaches k
            int left = 1, right = m;
            while(left < right) {
                int mid = left  + (right-left)/2;
                if(presum[mid]>=k)
                    right = mid;
                else left = mid+1;
            }
            ans[i] = left;
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] nums ={4,4,2,1};
        long[] queries = {5,3,1,0};
        SortedGCDPairQueries sq = new SortedGCDPairQueries();
        int[] ans = sq.gcdValues(nums, queries);
        for(int i=0;i<ans.length;i++){
          System.out.print(ans[i]+" ");
        }
        
    }
}
