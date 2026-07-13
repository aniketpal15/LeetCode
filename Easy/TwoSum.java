/*
1. Two Sum
Easy
Topics
premium lock icon
Companies
Hint
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


*/
import java.util.*;
public class TwoSum {
    //Bruteforce......(o(n^2))..........
      public int[] twoSumbrut(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0]=-1;
        ans[1] = -1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]+nums[j]==target && i!=j){
                    ans[0]=i;
                    ans[1] = j;
                    return ans;
                }
            }
        }

        return new int[]{-1,-1};
    }
    
    //Better ...(o(nlogn)).......
    public int[] twoSumsort(int[] nums, int target) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int ans[] = new int[2];
        int i=0;
        int j=sorted.length-1;
        
        while(i!=j){
            if(sorted[i]+sorted[j]<target){
                i++;
            }else if(sorted[i]+sorted[j]>target){
                j--;
            }else{
                ans[0]=i;
                ans[1] = j;
                break;
            }
        }

        return ans;


    }

    // optimised method using hashmap .........(o(n))..........
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
         int ans[] = new int[2];
        for(int i=0;i<nums.length;i++){
           int remain = target - nums[i];
           if(hm.containsKey(remain)){
            ans[0]= hm.get(remain);
            ans[1] = i;
            return ans;
           }else{
            hm.put(nums[i],i);
           }
        }
        return new int[]{-1,-1};
    }
    public static void main(String args[]){
        int[] nums = {2,7,11,15};
        int target = 9;
        
        
        TwoSum ts = new TwoSum();
        int[] ans1 = ts.twoSumbrut(nums, target);
        System.err.println("["+ans1[0]+","+ans1[1]+"]");

        int[] ans2 = ts.twoSumsort(nums, target);
        System.err.println("["+ans2[0]+","+ans2[1]+"]");
        int[] ans3 = ts.twoSum(nums, target);
        System.err.println("["+ans3[0]+","+ans3[1]+"]");
    }
}
