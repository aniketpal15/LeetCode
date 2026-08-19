class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Sort by row number
        Arrays.sort(reservedSeats, Comparator.comparingInt(row -> row[0]));
        
        int ans = 0;
        int i = 0;
        int lastProcessedRow = 0; 

        while (i < reservedSeats.length) {
            int currentRow = reservedSeats[i][0];

            // 1. Add 2 families for all the completely empty rows we skipped between lastProcessedRow and currentRow
            ans += (currentRow - lastProcessedRow - 1) * 2;

            boolean left = true;   // Covers seats 2, 3, 4, 5
            boolean middle = true; // Covers seats 4, 5, 6, 7
            boolean right = true;  // Covers seats 6, 7, 8, 9

            // 2. Process ALL reserved seats for the current row (with Out of Bounds protection)
            while (i < reservedSeats.length && reservedSeats[i][0] == currentRow) {
                int seat = reservedSeats[i][1];
                if (seat >= 2 && seat <= 5) left = false;
                if (seat >= 4 && seat <= 7) middle = false;
                if (seat >= 6 && seat <= 9) right = false;
                i++; // Move to the next seat
            }

            // 3. Evaluate the blocks for the current row exactly ONCE
            if (left && right) {
                ans += 2;
            } else if (left || middle || right) {
                ans += 1;
            }

            // 4. Update the tracker for the next iteration
            lastProcessedRow = currentRow;
        }

        // 5. Calculate remaining empty rows after the last reservation
        ans += (n - lastProcessedRow) * 2;

        return ans;
    }
}