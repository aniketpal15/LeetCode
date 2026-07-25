class Solution {
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
}