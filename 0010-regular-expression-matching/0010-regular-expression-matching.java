class Solution {
    public boolean isMatch(String s, String p) {
         if(p.length()==0){
            return s.length()==0;
        }

        Boolean first = false;
        if( (s.length()>0 )&& ((p.charAt(0)==s.charAt(0))|| p.charAt(0)=='.')){
             first = true;
        }

        if(p.length() >= 2 && p.charAt(1) == '*'){
            Boolean take = first && isMatch(s.substring(1), p);
            Boolean dont_take = isMatch(s, p.substring(2));

            return take|| dont_take;
        }

        return first && isMatch(s.substring(1), p.substring(1));
    }
}