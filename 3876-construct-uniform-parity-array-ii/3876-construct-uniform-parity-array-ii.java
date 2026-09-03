class Solution {
    public boolean uniformArray(int[] nums1) {
         int n = nums1.length;
        int smallest_odd = Integer.MAX_VALUE;
        int oddcnt = 0;
        int evencnt = 0;
        for(int i=0;i<n;i++){
            if(nums1[i]%2 == 1){
                smallest_odd = Math.min(smallest_odd, nums1[i]);
                oddcnt++;
            }else{
                evencnt++;
            }
        }
        if(oddcnt==0 || evencnt==0){
            return true;
        }
         for(int i=0;i<n;i++){
            if(nums1[i]%2 ==0){
               if(nums1[i]<=smallest_odd){
                  return false;
               }
            }
         }


         return true;
    }
    
}