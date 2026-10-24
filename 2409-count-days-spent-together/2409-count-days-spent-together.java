class Solution {
    int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aAD = toDOY(arriveAlice);
        int aLD = toDOY(leaveAlice);
        int bAD = toDOY(arriveBob);
        int bLD = toDOY(leaveBob);

        int oS = Math.max(aAD, bAD);
        int oE = Math.min(aLD, bLD);

        return Math.max(0, oE - oS + 1);
    }

    private int toDOY(String d) {
        int m = Integer.parseInt(d.substring(0, 2));
        int day = Integer.parseInt(d.substring(3, 5));
        
        int tD = 0;
        
        for (int i = 0; i < m - 1; i++) {
            tD += days[i];
        }
        
        tD += day;
        
        return tD;
    }
}