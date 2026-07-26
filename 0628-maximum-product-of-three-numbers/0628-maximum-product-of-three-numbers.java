class Solution {
    public int maximumProduct(int[] nums) {
       Arrays.sort(nums);
        int l = nums.length;
        int option1 = nums[l-1] * nums[l-2] * nums[l-3];
        int option2 = nums[0] * nums[1] * nums[l-1];
        return Math.max(option1, option2);
    }

}