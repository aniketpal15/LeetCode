import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Pass 1: Map the indices of matching parentheses
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int direction = 1;
        
        // Pass 2: Traverse the string
        while (i < n) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                // Teleport to the matching parenthesis and reverse direction
                i = pair[i];
                direction = -direction;
            } else {
                sb.append(s.charAt(i));
            }
            i += direction;
        }
        
        return sb.toString();
    }
}