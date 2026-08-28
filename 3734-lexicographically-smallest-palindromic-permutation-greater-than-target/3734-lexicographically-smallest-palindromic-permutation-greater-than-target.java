class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int[] cnt = new int[26];
        int n = s.length();
        int m = n / 2;
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        
        int odd = 0;
        char middle = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 != 0) {
                odd++;
                middle = (char) ('a' + i);
            }
        }
        if (odd > 1) {
            return "";
        }

        int[] lcnt = new int[26];
        for (int i = 0; i < 26; i++) {
            lcnt[i] = cnt[i] / 2;
        }
        int k = 0;
        int[] tempCnt = lcnt.clone();
        while (k < m && tempCnt[target.charAt(k) - 'a'] > 0) {
            tempCnt[target.charAt(k) - 'a']--;
            k++;
        }

        for (int i = k; i >= 0; i--) {
            if (i == m) {
                String left = target.substring(0, m); 
                String right = new StringBuilder(left).reverse().toString();
                String ans = left + (n % 2 == 1 ? middle : "") + right;
                
                if (ans.compareTo(target) > 0) {
                    return ans;
                }
            } 
            else {
                int[] avail = lcnt.clone();
                
                for (int j = 0; j < i; j++) {
                    avail[target.charAt(j) - 'a']--;
                }
                
                for (int c = target.charAt(i) - 'a' + 1; c < 26; c++) {
                    if (avail[c] > 0) {
                        avail[c]--;
                        StringBuilder left = new StringBuilder(target.substring(0, i));
                        left.append((char) ('a' + c));
                        
                        // Fill the remaining left half with smallest available characters
                        for (int j = 0; j < 26; j++) {
                            while (avail[j] > 0) {
                                left.append((char) ('a' + j));
                                avail[j]--;
                            }
                        }
                        String leftStr = left.toString();
                        String rightStr = new StringBuilder(leftStr).reverse().toString();
                        return leftStr + (n % 2 == 1 ? middle : "") + rightStr;
                    }
                }
            }
        }

        return "";
    }
}