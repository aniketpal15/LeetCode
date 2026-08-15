class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        Boolean zero = true;
        int temp=0;
        for(int a:nums){
            if(a!=0){
                zero= false;
            }

            temp = temp^a;
        }

        if(zero){
            return 0;
        }


        return (temp==0)? n-1:n;
    }
}