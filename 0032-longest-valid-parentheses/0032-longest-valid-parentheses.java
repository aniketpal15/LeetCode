class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0;
        int maxLength = 0;
        
        // Pass 1: Left to Right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            } else if (right > left) {
                // Invalid state, reset counters
                left = 0;
                right = 0;
            }
        }
        
        left = 0; 
        right = 0;
        
        // Pass 2: Right to Left
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            } else if (left > right) {
                // Invalid state, reset counters
                left = 0;
                right = 0;
            }
        }
        
        return maxLength;
    }
}