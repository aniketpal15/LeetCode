/*
7. Reverse Integer
Topics
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the
value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0
Assume the environment does not allow you to store 64-bit integers (signed or
unsigned).
Medium & Companies
Example 1:
Input: x = 123
Output: 321
Example 2:
Input: x = -123
Output: -321
Example 3:
Input: x = 120
Output: 21
*/

public class Reverseint {
    public int reverse(int x) {
        int r=0,b;
        if(x>Integer.MIN_VALUE && x<Integer.MAX_VALUE){
        while(x!=0){
            b=x%10;
            if (r > Integer.MAX_VALUE / 10 || (r == Integer.MAX_VALUE / 10 && b > 7)) {
                return 0;
            }
            if (r < Integer.MIN_VALUE / 10 || (r == Integer.MIN_VALUE / 10 && b < -8)) {
                return 0;
            }
            x=x/10;
            r=r*10 +b;
        }
    }
    else{
        System.out.println("please enter betten 32 bits");
        return -1;
    }
    return r;
        
    }
    public static void main(String args[]){
        Reverseint ri = new Reverseint();
        int num = 1534236469;
        System.out.println(ri.reverse(num));
    }
}
