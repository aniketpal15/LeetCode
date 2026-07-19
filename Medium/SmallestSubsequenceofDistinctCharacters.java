/*
1081. Smallest Subsequence of Distinct Characters
Medium
Topics
premium lock icon
Companies
Hint
Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
*/

import java.util.*;

public class SmallestSubsequenceofDistinctCharacters {
    public String smallestSubsequence(String s) {
        int n = s.length();
        int last[] = new int[26];

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            last[c-'a']=i;
        }

        HashSet<Character> hset = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
           if(hset.contains(c)){
            continue;
           }

           while(!st.isEmpty()){
                char prev = s.charAt(st.peek());
                if(prev>c && last[prev-'a']>i){
                     st.pop();
                     hset.remove(prev);
                }else{
                    break;
                }
           }

           st.push(i);
           hset.add(c);
        }

        StringBuilder sb = new StringBuilder();

        while(!st.empty()){
            sb.append(s.charAt(st.pop()));
        } 
        sb.reverse();
        return sb.toString();


    }
    public static void main(String[] args) {
        String s ="cbacdcbc";
        SmallestSubsequenceofDistinctCharacters ss =new SmallestSubsequenceofDistinctCharacters();
        System.out.println(ss.smallestSubsequence(s));

    }
}
