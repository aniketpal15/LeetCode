class Solution {
    public String smallestPalindrome(String s) {
         int l = s.length();
        int[] count = new int[26];
        for (int j = 0; j < l / 2; j++) {
            count[s.charAt(j) - 'a']++;
        }
        char[] res = new char[l];
        if (l % 2 != 0) {
            res[l / 2] = s.charAt(l / 2);
        }
        int left = 0;
        int right = l - 1;

        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                char c = (char) ('a' + i);
                res[left] = c;
                res[right] = c;
                left++;
                right--;
                
                count[i]--;
            }
        }
        return new String(res);
    }
}