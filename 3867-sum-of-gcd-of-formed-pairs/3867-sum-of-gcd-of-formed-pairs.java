class Solution {
     public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int max =-1;

        for(int i=0;i<n;i++){
             max = Math.max(nums[i], max);
             prefixGcd[i] = gcd(nums[i],max);
        }
       long ans =0;
       Arrays.sort(prefixGcd);
       for(int i=0,j=n-1;i<j;i++,j--){
        ans += gcd(prefixGcd[i],prefixGcd[j]);
       }
       return ans;

    }

    int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }


}