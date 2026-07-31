class Solution {
    public int minimumPushes(String word) {
        int[] count = new int[26];
       for(int i =0;i<word.length();i++){
        count[word.charAt(i)-'a']++;
       }
       Arrays.sort(count);
       int ans=0;
       int multi =1;
       int itr =1;

       for(int j=25;j>=0;j--){
        if(count[j]==0){
            break;
        }
        if(itr>8){
            itr=1;
            multi++;
        }
        ans = ans +(count[j]*multi);
        itr++;
       }

    return ans;
    }
}