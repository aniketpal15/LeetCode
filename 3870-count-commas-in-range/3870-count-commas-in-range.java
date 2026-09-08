class Solution {
    public int countCommas(int n) {
        long totalCommas = 0;
        long low = 1000;
        long commaCount = 1;

        while (low <= n) {
            long high = low * 1000 - 1;
            long end = Math.min(n, high);
            long count = end - low + 1;
            totalCommas += count * commaCount;
            low *= 1000;
            commaCount++;
        }

        return (int)totalCommas;
    }
}