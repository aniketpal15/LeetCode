class Solution {
        public boolean canJump(int[] nums){
        int bat = 0;
        for(int i=0;i<nums.length;i++){
            if(i>bat){
                return false;
            }
            bat = Math.max(bat, nums[i]+i);
            if(bat>nums.length-1){
                return true;
            } 
        }
        return true;    
    }
   
    public static void main(String args[]){
        Solution j = new Solution();
        int arr[]= {3,2,1,0,4};
        System.out.println(j.canJump(arr));
    }
}