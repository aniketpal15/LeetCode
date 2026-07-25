class Solution {
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
        Solution mw = new Solution();
        int height[]={1,8,6,2,5,4,8,3,7};
        int res = mw.maxArea(height);
        System.out.println("The total max water can preserved is = "+res);

    }
}