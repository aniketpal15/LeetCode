/*
16. 3Sum Closest
Medium
Topics
premium lock icon
Companies
Given an integer array nums of length n and an integer target, find three integers at distinct indices in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

Constraints:

3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104

*/

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minsum= Integer.MAX_VALUE;
        int resultsum = nums[0]+nums[1]+nums[2];
        
        for(int i=0;i<nums.length -2;i++){
             int l=i+1;
             int r=nums.length-1;
             while(l<r){
                int sum = nums[i]+nums[l]+nums[r];

                if(sum == target){
                    return target;
                }else if (sum<target) {
                    l++;
                }else{
                    r-- ;
                }
                int diff = Math.abs(sum-target);
                if(minsum>diff){
                    resultsum =sum;
                    minsum =diff;
                }
             }
        }

        return resultsum;
    }
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target =1;
        ThreeSumClosest ts =new ThreeSumClosest();
        System.err.println(ts.threeSumClosest(nums, target));
    }
}
