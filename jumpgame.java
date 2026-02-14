/*
55. JUMP GAME..........
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 
Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 105

*/


public class jumpgame {
//Brute Force approch created by me..................o(2^n)
    public static  boolean jum(int[] nums,int i){
        if(i==nums.length-1){
            return true;
        }
        int batt=nums[i];
        for(int j=1;j<=batt;j++){
            if(jum(nums,i+j)){
                return true;
            }
        }
        return false;
    }


//Greedy method optimised solution................o(n)
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
        jumpgame j = new jumpgame();
        int arr[]= {3,2,1,0,4};
        System.out.println(j.canJump(arr));
    }    
}
