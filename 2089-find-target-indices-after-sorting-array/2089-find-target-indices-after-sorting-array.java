import java.util.*;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                ans.add(i);
                if(i+1<nums.length && nums[i+1]==target){
                    continue;
                }else{
                    break;
                }
            }
        }

    return ans;
        
    }
}   