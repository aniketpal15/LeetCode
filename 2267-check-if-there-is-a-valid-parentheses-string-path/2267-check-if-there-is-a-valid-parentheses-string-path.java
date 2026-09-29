class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // A valid path must have an even length to perfectly balance '(' and ')'.
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        
        // A valid string must start with an open bracket and end with a closed bracket.
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }
        
        // maxOpen is the maximum possible unbalanced '(' brackets we can have.
        // It cannot exceed half the total path length.
        int maxOpen = (m + n) / 2;
        
        // visited[r][c][open] keeps track of whether we've visited cell (r, c) 
        // with a specific number of currently unclosed '(' brackets.
        boolean[][][] visited = new boolean[m][n][maxOpen + 1];
        
        return dfs(grid, 0, 0, 0, visited);
    }
    
    private boolean dfs(char[][] grid, int r, int c, int open, boolean[][][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Adjust the open bracket count based on the current cell
        open += grid[r][c] == '(' ? 1 : -1;
        
        // Invalid states pruning:
        // 1. open < 0 means we have more ')' than '(' at this point, which makes it invalid.
        // 2. open > remaining path length means we have too many unclosed '(' and not enough remaining cells to close them.
        if (open < 0 || open > (m - 1 - r) + (n - 1 - c)) {
            return false;
        }
        
        // Reached the destination, verify all brackets are closed
        if (r == m - 1 && c == n - 1) {
            return open == 0;
        }
        
        // If we have already visited this cell with the same 'open' balance and it returned false.
        if (visited[r][c][open]) {
            return false;
        }
        visited[r][c][open] = true; // Mark as visited to memoize
        
        // Explore down and right
        if (r + 1 < m && dfs(grid, r + 1, c, open, visited)) return true;
        if (c + 1 < n && dfs(grid, r, c + 1, open, visited)) return true;
        
        return false;
    }
}