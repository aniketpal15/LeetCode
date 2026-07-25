class Solution {
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
        return 0;
    }
    return r;
        
    }
    public static void main(String args[]){
        Solution ri = new Solution();
        int num = -2147483648;
        System.out.println(ri.reverse(num));
    }
}