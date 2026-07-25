class Solution {
    public int maxProduct(int n) {
       int temp = Math.abs(n) ;
        int l=0;
        while(temp>0){
             temp =temp/10;
             l++;
        }

        int[] arr = new int[l];
        for(int i=0;i<l;i++){
            arr[i] = n%10;
            n=n/10;
            

        }
         Arrays.sort(arr);
        return arr[l-1]*arr[l-2]; 
    }
}