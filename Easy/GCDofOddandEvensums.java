/*
3658. GCD of Odd and Even Sums
Easy
Topics
premium lock icon
Companies
Hint
You are given an integer n. Your task is to compute the GCD (greatest common divisor) of two values:

sumOdd: the sum of the smallest n positive odd numbers.

sumEven: the sum of the smallest n positive even numbers.

Return the GCD of sumOdd and sumEven.

 

Example 1:

Input: n = 4

Output: 4

Explanation:

Sum of the first 4 odd numbers sumOdd = 1 + 3 + 5 + 7 = 16
Sum of the first 4 even numbers sumEven = 2 + 4 + 6 + 8 = 20
Hence, GCD(sumOdd, sumEven) = GCD(16, 20) = 4.

Example 2:

Input: n = 5

Output: 5

Explanation:

Sum of the first 5 odd numbers sumOdd = 1 + 3 + 5 + 7 + 9 = 25
Sum of the first 5 even numbers sumEven = 2 + 4 + 6 + 8 + 10 =  
Hence, GCD(sumOdd, sumEven) = GCD(25, 30) = 5.

 

Constraints:

1 <= n <= 10​​​​​​​00

*/

public class GCDofOddandEvensums {
    //Brutforce.........
    public int gcdOfOddEvenSumsbrut(int n) {
        int sumOdd=0;
        int sumEven = 0;
        for(int i=1;i<=(2*n-1);i+=2){
            sumOdd +=i;
        }
        for(int i=2;i<=n*2;i+=2){
            sumEven +=i;
        }
        

        return GCD(sumOdd,sumEven);
    }


    //optimised.............O(1)...
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = n*n;
        int sumEven = n*(n+1);
        return GCD(sumOdd, sumEven);
    }


    int GCD(int a,int b){
        if(b==0){
            return a;
        }
        return GCD(b,a%b);
    }


    public static void main(String args[]){
        int n=5;
        GCDofOddandEvensums g = new GCDofOddandEvensums();
        System.out.println(g.gcdOfOddEvenSums(n));
    }
}
