class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int mainans= Integer.MAX_VALUE;
        int maxi =0 ;
        int mini =0;
        for(int i=0;i<n;i++){
            if(nums[maxi]<nums[i]){
                maxi= i;
            }
            if(nums[mini]>nums[i]){
                mini=i;
            }
        }
        

        if(mini<maxi){
          mainans = Math.min(mainans, find(mini, maxi,n));
        }else{
          mainans = Math.min(mainans, find(maxi, mini,n));
        }

        return mainans;
    }


    public int find(int mini,int maxi, int n){
        int ans= Integer.MAX_VALUE;
          ans = Math.min((n-maxi)+(mini+1),ans);
          ans = Math.min(n-mini, ans);
          ans = Math.min(maxi+1,ans);
          return ans;
    }
}