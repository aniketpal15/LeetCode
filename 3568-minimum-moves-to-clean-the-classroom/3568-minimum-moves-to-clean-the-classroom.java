import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startR = -1, startC = -1;
        List<int[]> litters = new ArrayList<>();
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'S') {
                    startR = r;
                    startC = c;
                } else if (ch == 'L') {
                    litters.add(new int[]{r, c});
                }
            }
        }
        
        int totalLitter = litters.size();
        if (totalLitter == 0) return 0;
        
        int[][] litterIndex = new int[m][n];
        for (int[] row : litterIndex) Arrays.fill(row, -1);
        for (int i = 0; i < totalLitter; i++) {
            litterIndex[litters.get(i)[0]][litters.get(i)[1]] = i;
        }
        
        int targetMask = (1 << totalLitter) - 1;
        
        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << totalLitter];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{startR, startC, energy, 0, 0});
        visited[startR][startC][energy][0] = true;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int e = curr[2];
            int mask = curr[3];
            int moves = curr[4];
            
            if (mask == targetMask) {
                return moves;
            }
            
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || classroom[nr].charAt(nc) == 'X') {
                    continue;
                }
                
                int nextEnergy = e - 1;
                if (nextEnergy < 0) continue;
                
                char cellType = classroom[nr].charAt(nc);
                int nextMask = mask;
                
                if (cellType == 'R') {
                    nextEnergy = energy;
                } else if (cellType == 'L') {
                    int bitIdx = litterIndex[nr][nc];
                    if (bitIdx != -1) {
                        nextMask |= (1 << bitIdx);
                    }
                }
                
                if (!visited[nr][nc][nextEnergy][nextMask]) {
                    visited[nr][nc][nextEnergy][nextMask] = true;
                    queue.offer(new int[]{nr, nc, nextEnergy, nextMask, moves + 1});
                }
            }
        }
        
        return -1;
    }
}