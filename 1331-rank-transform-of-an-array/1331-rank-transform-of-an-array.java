class Solution {
    public int[] arrayRankTransform(int[] arr) {
       int[] sorted = arr.clone();
        Arrays.sort(sorted);

        HashMap<Integer,Integer> hp = new HashMap<>();
        int rank =1;

        for( int num:sorted){
            if(!hp.containsKey(num)){
                hp.put(num, rank++);
            }
        }

        int[] res = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[i] = hp.get(arr[i]);
        }

        return res; 
    }
}