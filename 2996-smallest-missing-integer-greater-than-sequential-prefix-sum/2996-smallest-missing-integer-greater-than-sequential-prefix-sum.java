class Solution {
    public int missingInteger(int[] nums) {
        int sum=nums[0];
        int i=0;
        while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
             i++;
             sum = sum + nums[i];
        }

        boolean[] present = new boolean[2500]; 
        for (int num : nums) {
            present[num] = true;
        }
        while (sum < present.length && present[sum]) {
            sum++;
        }

        return sum;
    }
}