/*
9. Palindrome Number
Easy
Topics
premium lock icon
Companies
Hint
Given an integer x, return true if x is a palindrome, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-2^31 <= x <= 2^31 - 1
 
*/

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
       if (x < 0 || (x % 10 == 0 && x != 0)) {
        return false;
    }

    int revertedHalf = 0;
    while (x > revertedHalf) {
        revertedHalf = (revertedHalf * 10) + (x % 10);
        x /= 10;
    }
    return x == revertedHalf || x == revertedHalf / 10;
    }   

    public boolean isPalindromestr(int x) {
        if(x<0){
            return false;
        }

        String num = x+"";
        int s=0;
        int e = num.length()-1;

        while(s<e){
            if(num.charAt(s)!=num.charAt(e)){
                return false;
            }
            s++;
            e--;
        }

        return true;
    } 


    public static void main(String args[]){
        int x= 2147447412;
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindrome(x));
    }
}
