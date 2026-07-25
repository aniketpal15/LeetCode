class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int[] ans = new int[nums1.length + nums2.length];
        int m= nums1.length;
        int n= nums2.length;
        int l=0,i=0,j=0;
        while(i<m && j<n){
              if(nums1[i]<nums2[j]){
                       ans[l] = nums1[i];
                       i++;
                       l++;
                    }else{
                        ans[l] = nums2[j];
                        j++;
                        l++;
                    }
    }

    while (i < m) {
            ans[l++] = nums1[i++];
        }
        
        while (j < n) {
            ans[l++] = nums2[j++];
        }
     int totalLength = m + n;
        if (totalLength % 2 == 1) {
            return (double) ans[totalLength / 2];
        } else {
            int mid1 = ans[totalLength / 2 - 1];
            int mid2 = ans[totalLength / 2];
            return (double) (mid1 + mid2) / 2.0;
        }
    }
}