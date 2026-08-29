class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> Integer.compare(nums[a], nums[b]));

        int[] result = new int[n];
        int i = 0;

        while (i < n) {
            int j = i + 1;
            
            while (j < n && nums[indices[j]] - nums[indices[j - 1]] <= limit) {
                j++;
            }

            int[] groupIndices = new int[j - i];
            for (int k = i; k < j; k++) {
                groupIndices[k - i] = indices[k];
            }
            
            Arrays.sort(groupIndices);

            for (int k = i; k < j; k++) {
                result[groupIndices[k - i]] = nums[indices[k]];
            }

            i = j;
        }

        return result;
    }
}