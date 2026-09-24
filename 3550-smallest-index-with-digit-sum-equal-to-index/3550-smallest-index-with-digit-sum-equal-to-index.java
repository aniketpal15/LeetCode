class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
          if(digsum(nums[i])==i){
            return i;
          }
        }

        return -1;
    }

    public int digsum(int n){
        int sum=0;
        while(n!=0){
          sum+=n%10;
          n=n/10;
        }
        return sum;
    }
}