class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }

        int total = 0;

        for (int i = 100; i < 1000; i += 2) {
            int d1 = i / 100;      
            int d2 = (i / 10) % 10; 
            int d3 = i % 10;        

            int[] currentCount = new int[10];
            currentCount[d1]++;
            currentCount[d2]++;
            currentCount[d3]++;
            boolean isValid = true;
            for (int d = 0; d < 10; d++) {
                if (currentCount[d] > count[d]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                total++;
            }
        }

        return total;
    }
}