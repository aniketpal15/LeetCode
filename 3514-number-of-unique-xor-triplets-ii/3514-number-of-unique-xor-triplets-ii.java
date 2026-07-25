class Solution {
    public int uniqueXorTriplets(int[] nums) {
        HashSet<Integer> dbl = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
         
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                dbl.add(nums[i]^nums[j]);
            }
        }
       for(int k :dbl){
         for(int i=0;i<nums.length;i++){
            ans.add(k^nums[i]);
        }
       }


       return ans.size();
         
    }
}