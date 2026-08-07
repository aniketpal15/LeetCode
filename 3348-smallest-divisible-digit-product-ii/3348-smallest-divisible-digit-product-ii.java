class Solution {
    private String freeSlotsFiller(long required, int length) {
        StringBuilder str = new StringBuilder();
        for (int digit = 9; digit >= 2; digit--) {
            while (required % digit == 0) {
                str.append((char) (digit + '0'));
                required /= digit;
            }
        }

        while (str.length() < length) {   
            str.append('1');
        }

        str.reverse();
        return str.toString();
    }
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public String smallestNumber(String num, long t) {
        int n = num.length();
        long temp = t;
        for (int primeFact : new int[]{2, 3, 5, 7}) {
            while (temp % primeFact == 0) {
                temp /= primeFact;
            }
        }

        if (temp != 1) {   
            return "-1";
        }
        long[] remainingFactor = new long[n + 1];
        remainingFactor[0] = t;
        
        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';

            if (digit == 0) {
                break;
            }

            remainingFactor[i + 1] = remainingFactor[i] / gcd(remainingFactor[i], digit);
        }

        if (remainingFactor[n] == 1) {  
            return num;
        }
        int zeroPos = num.indexOf('0');
        int zeroIdx = n - 1;
        if (zeroPos != -1) {
            zeroIdx = zeroPos;
        }
        for (int i = zeroIdx; i >= 0; i--) {
            long required = remainingFactor[i];
            int freeSlots = n - 1 - i;  

            // Try to increment the current digit
            for (int digit = (num.charAt(i) - '0') + 1; digit <= 9; digit++) {
                long furtherRequired = required / gcd(required, digit);
                String requiredNumber = freeSlotsFiller(furtherRequired, freeSlots);

                // If we can satisfy the product within the available free slots
                if (requiredNumber.length() == freeSlots) {
                    return num.substring(0, i) + (char) (digit + '0') + requiredNumber;
                }
            }
        }

        // Step 4: If no valid combination exists with length 'n', we must increase the length by 1.
        return freeSlotsFiller(t, n + 1);   
    }
}