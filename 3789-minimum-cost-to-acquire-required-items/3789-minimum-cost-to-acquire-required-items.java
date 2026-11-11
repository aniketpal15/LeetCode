class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1;
        long c2 = cost2;
        long cBoth = costBoth;
        long n1 = need1;
        long n2 = need2;
        long option1 = n1 * c1 + n2 * c2;

        long minN = Math.min(n1, n2);
        long option2 = minN * cBoth + (n1 - minN) * c1 + (n2 - minN) * c2;

        long mN = Math.max(n1, n2);
        long option3 = mN * cBoth;
        return Math.min(option1, Math.min(option2, option3));
    }
}