class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int i = 0, j = 0;
        int result = 0;

        while(j < n){
            if(freq.containsKey(nums[j])){
                freq.replace(nums[j], freq.get(nums[j]) + 1);
            } else {
                freq.put(nums[j], 1);
            }


            while(i < j && freq.get(nums[j]) > k){
                    freq.replace(nums[i], freq.get(nums[i]) - 1);
                    i++;
            }

            result = Math.max(result, j - i + 1);
            j++;
        }

        return result;
    }
}
