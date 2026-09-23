class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // We are looking for a subarray that sums to this target
        int target = totalSum - x;
        
        // If the target is negative, all elements combined are less than x.
        if (target < 0) {
            return -1;
        }
        // If the target is exactly 0, we need to remove all elements.
        if (target == 0) {
            return nums.length;
        }
        
        int left = 0;
        int currentSum = 0;
        int maxLength = -1;
        
        // Sliding window
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            
            // Shrink the window from the left if the sum exceeds the target
            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }
            
            // If we found a valid subarray, update the max length
            if (currentSum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        
        // If maxLength is still -1, no valid subarray was found
        return maxLength == -1 ? -1 : nums.length - maxLength;
    }
}