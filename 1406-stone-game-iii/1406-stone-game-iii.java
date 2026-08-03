class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int dp[] = new int[stoneValue.length+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int diff = solve(stoneValue,dp,0);

        if(diff>0){
            return "Alice"; 
        }else if(diff<0){
            return "Bob";
        }else{
            return "Tie";
        }
    }
    public static int solve(int[] nums,int[] dp ,int i){
        int n= nums.length;
        if(i>=n) return 0;
        if (dp[i] != Integer.MIN_VALUE) return dp[i];

        int result= nums[i]-solve(nums, dp, i+1);
        if(i+1<n) result = Math.max(result, (nums[i]+nums[i+1])-solve(nums, dp, i+2));
        if(i+2<n) result = Math.max(result, (nums[i]+nums[i+1]+nums[i+2])-solve(nums, dp, i+3));

        return dp[i]=result;
    }
}