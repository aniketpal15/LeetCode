class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; // Minimum possible open '('
        int maxOpen = 0; // Maximum possible open '('
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--; // Treat '*' as ')'
                maxOpen++; // Treat '*' as '('
            }
            
            // If maxOpen drops below 0, we have too many ')' that cannot be matched
            if (maxOpen < 0) {
                return false;
            }
            
            // minOpen cannot be negative. If it drops below 0, it just means 
            // we tried to treat a '*' as a ')' but shouldn't have. 
            // We can just treat it as an empty string instead to reset minOpen to 0.
            if (minOpen < 0) {
                minOpen = 0;
            }
        }
        
        // If minOpen is 0, we successfully matched all open parentheses
        return minOpen == 0;
    }
}
