/*
1291. Sequential Digits
Medium
Topics
premium lock icon
Companies
Hint
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
 

Constraints:

10 <= low <= high <= 10^9

*/

import java.util.*;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        String s ="123456789";
        int min = String.valueOf(low).length();
        int max = String.valueOf(high).length();

        List<Integer> ans = new ArrayList<>();
        
        for(int i=min;i<=max;i++){
            for(int start=0;start+i<=9;start++){
                    String substr = s.substring(start,start+i);
                    int num = Integer.parseInt(substr);
                    if(num>= low && num<= high){
                        ans.add(num);
                    }
            }
        }

        return ans;

    }


    public static void main(String args[]){
       int   low = 1000; 
       int high = 13000;
       SequentialDigits s = new SequentialDigits();
       List<Integer> ans = s.sequentialDigits(low, high);
       System.err.println(ans);
    }
}
