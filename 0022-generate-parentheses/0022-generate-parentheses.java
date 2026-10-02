import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder currentString, int openCount, int closeCount, int max) {
        // Base case: if the string length is 2*max, it is fully formed
        if (currentString.length() == max * 2) {
            result.add(currentString.toString());
            return;
        }
        
        // Rule 1: We can add an open parenthesis if we haven't used all 'max'
        if (openCount < max) {
            currentString.append("(");
            backtrack(result, currentString, openCount + 1, closeCount, max);
            currentString.deleteCharAt(currentString.length() - 1); // Backtrack
        }
        
        // Rule 2: We can add a close parenthesis if it won't exceed open parentheses
        if (closeCount < openCount) {
            currentString.append(")");
            backtrack(result, currentString, openCount, closeCount + 1, max);
            currentString.deleteCharAt(currentString.length() - 1); // Backtrack
        }
    }
}