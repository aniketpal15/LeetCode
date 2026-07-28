class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> temp = new HashSet<>();
        int maxlen =0;
        int r =0,l=0;
        while(r<s.length()){
            char c = s.charAt(r);
            if(!temp.contains(c)){
               temp.add(c);
               maxlen = Math.max(maxlen, temp.size());
               r++;
            }else{
              
                char p = s.charAt(l);
                temp.remove(p);
                l++;
            }
        }

        return maxlen;
    }
}