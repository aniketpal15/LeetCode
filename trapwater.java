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
