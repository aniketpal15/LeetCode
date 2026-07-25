class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();

        if(nums.length<3 || nums == null){
            return new ArrayList<>();
        }

        for(int i=0;i<nums.length -2;i++){
             int l=i+1;
             int r=nums.length-1;
             while(l<r){
                int sum = nums[i]+nums[l]+nums[r];

                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                }else if (sum<0) {
                    l++;
                }else{
                    r-- ;
                }
             }
        }

        return new ArrayList<>(ans);  
    }
}