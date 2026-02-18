package Hard;
/*
42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
it can trap after raining.

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array
[0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being
trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:

. n = height. length

1 n 2 * 104

· 0 < height [i] <= 105
 */
public class trapwater {
     public int trap(int[] height){
        int trapwat =0;
        int width =1;
        int leftmax[] = new int[height.length];
        int rightmax[] = new int[height.length];
        leftmax[0]=height[0];
        rightmax[height.length-1]=height[height.length-1];
        for(int i =1;i<height.length;i++){
            leftmax[i]=leftmax[i-1]>height[i]?leftmax[i-1]:height[i];
            rightmax[height.length-i-1]=rightmax[height.length-i]>height[height.length-i-1]?rightmax[height.length-i]:height[height.length-i-1];
        }
        for(int j =0;j<height.length;j++){
            trapwat += (Math.min(leftmax[j],rightmax[j])-height[j])*width;
        }
        return trapwat;
    }

    public static void main(String args[]){
        trapwater tp = new trapwater();
        int height[]={4,2,0,3,2,5};
        System.out.println(tp.trap(height));
       
    }
}
