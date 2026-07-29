class Solution {
    public String smallestPalindrome(String s, int k) {
        int[] fre = new int[26];


        
        for (char c : s.toCharArray()) {
            fre[c - 'a']++;
        }
        
           int[] counts = new int[26];
        char midChar = 0;
        int n = 0;
        
        for (int i = 0; i < 26; i++) {
            if (fre[i] % 2 == 1) {
              
                midChar = (char) (i + 'a');
            }


            counts[i] = fre[i] / 2;
            n += counts[i];
        }
        
       
        if (countPerms(counts, n) < k) {
            return "";
        }
        
        
    StringBuilder firstHalf = new StringBuilder();
        for (int step = 0; step < n; step++) {
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    counts[i]--; 
                    long p = countPerms(counts, n - 1 - step);
                    
                    if (k <= p) {
                        firstHalf.append((char) (i + 'a'));
                        break; 
                    } else {
                        k -= p;
                        counts[i]++;
                    }
                }
            }
        }
        
        String res = firstHalf.toString();
        String rev = firstHalf.reverse().toString();
        if (midChar != 0) {
            return res + midChar + rev;
        } else {
            return res + rev;
        }
    }
    
    

    private long nCk(int n, int k) {
        
if (k > n / 2) k = n - k; 
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
            if (res > 1000000) {
                return 1000001; 
            }
        }
        return res;
    }






    private long countPerms(int[] counts, int total) {
        long perms = 1;
        int remaining = total;
        for (int c : counts) {
            if (c > 0) {
                perms *= nCk(remaining, c);
                if (perms > 1000000) {
                    return 1000001;
                }
                remaining -= c;
            }
        }
        return perms;
    }
}