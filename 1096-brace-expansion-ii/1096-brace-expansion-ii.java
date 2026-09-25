import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private int i = 0; // Global pointer to track our position in the string

    public List<String> braceExpansionII(String expression) {
        // Parse the full expression starting at index 0
        Set<String> result = parseExpr(expression);
        
        // Convert the set to a sorted list as required
        List<String> sortedRes = new ArrayList<>(result);
        Collections.sort(sortedRes);
        return sortedRes;
    }

    // Expr -> Term (',' Term)*
    // Handles the Union operation (comma-separated lists)
    private Set<String> parseExpr(String s) {
        Set<String> res = new HashSet<>();
        res.addAll(parseTerm(s));
        
        while (i < s.length() && s.charAt(i) == ',') {
            i++; // skip the ','
            res.addAll(parseTerm(s));
        }
        
        return res;
    }

    // Term -> Factor Factor Factor ...
    // Handles the Concatenation operation (adjacent groups/letters)
    private Set<String> parseTerm(String s) {
        Set<String> res = new HashSet<>();
        res.add(""); // Base string for concatenation
        
        // Keep concatenating as long as we don't hit a comma or a closing brace
        while (i < s.length() && s.charAt(i) != ',' && s.charAt(i) != '}') {
            Set<String> factor = parseFactor(s);
            Set<String> nextRes = new HashSet<>();
            
            // Cartesian product of current results and the new factor
            for (String prefix : res) {
                for (String suffix : factor) {
                    nextRes.add(prefix + suffix);
                }
            }
            res = nextRes;
        }
        
        return res;
    }

    // Factor -> '{' Expr '}' | lowercase_letters
    // Handles the base units (either a nested expression or raw characters)
    private Set<String> parseFactor(String s) {
        Set<String> res = new HashSet<>();
        
        if (s.charAt(i) == '{') {
            i++; // consume '{'
            res = parseExpr(s);
            i++; // consume '}'
        } else {
            // Greedily consume all consecutive lowercase letters as a single string
            StringBuilder sb = new StringBuilder();
            while (i < s.length() && Character.isLowerCase(s.charAt(i))) {
                sb.append(s.charAt(i));
                i++;
            }
            res.add(sb.toString());
        }
        
        return res;
    }
}