import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // Step 1: Store knowledge pairs in a HashMap for O(1) lookup
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean inBracket = false;

        // Step 2: Traverse string s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                inBracket = true;
            } else if (c == ')') {
                inBracket = false;
                String keyStr = key.toString();
                // Replace key with value if present, else "?"
                result.append(map.getOrDefault(keyStr, "?"));
                key.setLength(0); // Clear key buffer
            } else {
                if (inBracket) {
                    key.append(c);
                } else {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}