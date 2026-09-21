import java.util.HashMap;
import java.util.Map;

class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        // Use Long for frequencies since the number of subarrays can exceed 2^31 - 1
        Map<Integer, Long> curr = new HashMap<>();
        
        for (int x : nums) {
            Map<Integer, Long> nxt = new HashMap<>();
            
            // Extend existing subarrays ending at the previous index
            for (Map.Entry<Integer, Long> entry : curr.entrySet()) {
                int val = entry.getKey();
                long count = entry.getValue();
                
                // Use long to prevent integer overflow during multiplication
                int nv = (int) (((long) val * x) % k); 
                nxt.put(nv, nxt.getOrDefault(nv, 0L) + count);
            }
            
            // A new subarray starting and ending at the current element
            int nv = x % k;
            nxt.put(nv, nxt.getOrDefault(nv, 0L) + 1L);
            
            // Add the frequencies of subarrays ending at the current index to the final result
            for (Map.Entry<Integer, Long> entry : nxt.entrySet()) {
                int val = entry.getKey();
                long count = entry.getValue();
                result[val] += count;
            }
            
            // Move on to the next element
            curr = nxt;
        }
        
        return result;
    }
}