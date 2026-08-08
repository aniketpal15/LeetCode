class Solution {
    public int[] validSequence(String word1, String word2) {
        int n=word1.length();
        int m = word2.length();

        int[] rightdata = new int[n];

        for(int i=0;i<n;i++){
            rightdata[i] = 0;
        }

        int rm =0;
        int i=n-1;
        int j=m-1;

        while(i>=0){
            if((j>=0) && (word1.charAt(i)== word2.charAt(j))){
                 rm++;
                 j--;
            }

            rightdata[i]= rm;
            i--;
        }

        int[] ans = new int[m];

        boolean change = true;

        i=0;
        j=0;
       int k=0;
        while(i<n && j<m){
            if(word1.charAt(i)== word2.charAt(j)){
                ans[k] =i;
                k++;
                j++;
            }else if(change == true && i+1<n && rightdata[i+1]>= m-j-1){
                ans[k] =i;
                k++;
                j++;
                change= false;
            }
            i++;
        }
        return j==m?ans:new int[0];
    }
}