class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int comp[] = new int[n];

        for(int i=1;i<n;i++){
            int diff = Math.abs(nums[i]-nums[i-1]);
            if(diff <=maxDiff){
               comp[i] = comp[i-1];
            }else{
                comp[i] = i;
            }
        }

        boolean ans[] = new boolean[queries.length];

        for(int j=0;j<queries.length;j++){
            int node1 = queries[j][0];
            int node2 = queries[j][1];
            
            if(comp[node1] == comp[node2]){
                ans[j] = true;
            }
        }

        return ans;
    }
}