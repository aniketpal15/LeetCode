package Medium;
//11. Container With Most Water
/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints
of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
 

Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
*/


public class mostwater {
      public int maxArea(int[] height) {
         int maxwater = 0;
        int lp = 0;
        int rp = height.length-1;
        while(lp<rp){
            int currwater = (rp-lp)*Math.min(height[lp],height[rp]);
            maxwater = Math.max(maxwater,currwater); 
            if(height[lp]<height[rp]){
                lp++;
            }else{
                rp--;
            }
        }
        return maxwater;
    }
    public static void main(String args[]){
        mostwater mw = new mostwater();
        int height[]={1,8,6,2,5,4,8,3,7};
        int res = mw.maxArea(height);
         System.out.println("The total max water can preserved is = "+res);

    }
}