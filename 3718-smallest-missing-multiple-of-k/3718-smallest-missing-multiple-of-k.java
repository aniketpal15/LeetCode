class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
         for (int num : nums) {
            set.add(num);
         }

         int tar = k;
         while(set.contains(tar)){
            tar+=k;
         }

         return tar;
    }
}