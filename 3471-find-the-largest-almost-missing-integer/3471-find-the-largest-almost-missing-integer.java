class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] count= new int[51]; 
        int n = nums.length;
        for (int i = 0; i <= n - k; i++) {
            boolean[] see =new boolean[51];
            for (int j = i; j < i + k; j++) {
                see[nums[j]] = true;
            }
            for (int x= 0; x <=50; x++) {
                if (see[x]) {
                count[x]++;
                }
            }
        }
        for (int x = 50; x >= 0; x--) {
            if (count[x] == 1) {
                return x;
            }
        }
        return -1;
    }
}