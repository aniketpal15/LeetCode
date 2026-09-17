import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        
        // minLenUpTo[i] will store the minimum length of a valid sub-array 
        // (sum == target) ending at or before index i.
        int[] minLenUpTo = new int[n];
        
        // Use an arbitrarily large value to represent "infinity" / not found.
        // We use Integer.MAX_VALUE / 2 to prevent integer overflow when adding lengths later.
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(minLenUpTo, INF);
        
        int left = 0;
        int sum = 0;
        int minSoFar = INF;
        int ans = INF;
        
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            
            // Shrink the window from the left if the sum exceeds the target
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            
            // When we find a valid sub-array
            if (sum == target) {
                int currentLen = right - left + 1;
                
                // If there's a valid non-overlapping sub-array before the current 'left' index
                if (left > 0 && minLenUpTo[left - 1] != INF) {
                    ans = Math.min(ans, currentLen + minLenUpTo[left - 1]);
                }
                
                // Update the minimum length of a valid sub-array seen so far
                minSoFar = Math.min(minSoFar, currentLen);
            }
            
            // Carry forward the smallest length seen up to the current 'right' index
            minLenUpTo[right] = minSoFar;
        }
        
        // If ans is still INF, it means we couldn't find two valid sub-arrays
        return ans == INF ? -1 : ans;
    }
}