import java.util.Arrays;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int qlength = queries.length;
        int[][] sortedQueries = new int[qlength][2];
        for (int i = 0; i < qlength; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i; 
        }
        
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] ans = new int[qlength];
        
        int[] serverCounts = new int[n + 1]; 
        int uniqueActiveServers = 0;
        
        int left = 0;  
        int right = 0; 
        
        for (int i = 0; i < qlength; i++) {
            int time = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];
            
            while (right < logs.length && logs[right][1] <= time) {
                int serverId = logs[right][0];
                if (serverCounts[serverId] == 0) {
                    uniqueActiveServers++; 
                }
                serverCounts[serverId]++;
                right++;
            }
            
            while (left < logs.length && logs[left][1] < time - x) {
                int serverId = logs[left][0];
                serverCounts[serverId]--;
                if (serverCounts[serverId] == 0) {
                    uniqueActiveServers--; 
                }
                left++;
            }
            
            ans[originalIndex] = n - uniqueActiveServers;
        }
        
        return ans;
    }
}