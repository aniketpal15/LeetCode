class Solution {
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
        Solution solver = new Solution();
        String s="PAYPALISHIRING";
        int numrows = 3;
        System.out.println(solver.convert(s,numrows));
    }
}