import java.util.*;

class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minSum = Integer.MAX_VALUE;
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            int currsum = 0;
            for (int j = i; j < n; j++) {
                currsum += nums.get(j);
                
                int len = j - i + 1;
                
                if (len >= l && len <= r) {
                    if (currsum > 0) {
                        minSum = Math.min(minSum, currsum);
                    }
                }
                if (len > r) {
                    break;
                }
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}