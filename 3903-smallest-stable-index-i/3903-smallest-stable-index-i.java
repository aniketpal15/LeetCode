class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int min[] = new int[n];
        int max[] = new int[n];
        int tempmax=Integer.MIN_VALUE;
        int tempmin  =  Integer.MAX_VALUE;
        for(int i=0,j=n-1;i<n || j>=0;i++,j--){
               tempmax =  Math.max(tempmax, nums[i]);
               max[i]=tempmax;

               tempmin = Math.min(tempmin, nums[j]);
               min[j] = tempmin;
        }
        

       for(int i=0;i<n;i++){
          if(max[i]-min[i]<=k){
             return i;
          }
       }
       return -1;
    }
}