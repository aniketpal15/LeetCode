class Solution {
    public boolean predictTheWinner(int[] nums) {
          int player1 = solve(nums, 0, nums.length-1);
        return (player1>=0);

    }
    public int solve(int[] nums,int l,int r){
        if(l==r) return nums[l];

        int cl = nums[l] - solve(nums, l+1, r);
        int rl =  nums[r] - solve(nums, l, r-1);

        return Math.max(cl,rl);
    }
}