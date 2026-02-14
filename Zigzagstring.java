/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display 
this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
*/

public class Zigzagstring {

   public String convert(String s, int numRows) {
    if(numRows <= 1 || s.length() <= numRows){
        return s;
    }
    StringBuilder temp=new StringBuilder();
    int n=(numRows-1)*2;
        
        for(int i=0;i<numRows;i++){
           for(int j=i;j<s.length();j=j+n){
              temp.append(s.charAt(j));

              int mid = (j+n)-(i*2);
              if(i!=0 && i!= numRows-1 && mid<s.length()){
                 temp.append(s.charAt(mid));
              }

           }
        }
        return temp.toString();
    }
    public static void main(String args[]){
        Zigzagstring solver = new Zigzagstring();
        String s="abcdefghijklmnopqrstuvwxyz";
        int numrows = 6;
        System.out.println(solver.convert(s,numrows));
    }
}
