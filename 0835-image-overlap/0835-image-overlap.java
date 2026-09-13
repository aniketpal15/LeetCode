import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        
        // Lists to store coordinates of all 1s in img1 and img2
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) {
                    list1.add(new int[]{r, c});
                }
                if (img2[r][c] == 1) {
                    list2.add(new int[]{r, c});
                }
            }
        }
        
        // Map to store the frequency of each translation vector (encoded as a string or combined key)
        Map<String, Integer> shiftCounts = new HashMap<>();
        int maxOverlap = 0;
        
        for (int[] p1 : list1) {
            for (int[] p2 : list2) {
                // Calculate the offset (row diff, col diff)
                int rowDiff = p2[0] - p1[0];
                int colDiff = p2[1] - p1[1];
                
                // Use a formatted string as a key for the offset pair
                String shiftKey = rowDiff + "," + colDiff;
                
                int count = shiftCounts.getOrDefault(shiftKey, 0) + 1;
                shiftCounts.put(shiftKey, count);
                
                maxOverlap = Math.max(maxOverlap, count);
            }
        }
        
        return maxOverlap;
    }
}