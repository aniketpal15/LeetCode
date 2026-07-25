class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        int last[] = new int[26];

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            last[c-'a']=i;
        }

        HashSet<Character> hset = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
           if(hset.contains(c)){
            continue;
           }

           while(!st.isEmpty()){
                char prev = s.charAt(st.peek());
                if(prev>c && last[prev-'a']>i){
                     st.pop();
                     hset.remove(prev);
                }else{
                    break;
                }
           }

           st.push(i);
           hset.add(c);
        }

        StringBuilder sb = new StringBuilder();

        while(!st.empty()){
            sb.append(s.charAt(st.pop()));
        } 
        sb.reverse();
        return sb.toString();

    }
    }
