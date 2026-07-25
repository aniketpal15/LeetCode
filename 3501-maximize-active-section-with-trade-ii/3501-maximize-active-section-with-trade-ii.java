import java.util.*;

class Solution {

    // Fast, non-recursive (iterative) Segment Tree
    static class SegmentTree {
        int n;
        int[] tree;

        public SegmentTree(int[] arr) {
            this.n = arr.length;
            if (n > 0) {
                tree = new int[2 * n];
                for (int i = 0; i < n; i++) {
                    tree[n + i] = arr[i];
                }
                for (int i = n - 1; i > 0; i--) {
                    tree[i] = Math.max(tree[2 * i], tree[2 * i + 1]);
                }
            }
        }

        public int query(int l, int r) {
            if (l > r || n == 0) return 0;
            int maxVal = 0;
            l += n;
            r += n + 1; // Convert inclusive right bound to exclusive
            while (l < r) {
                if ((l & 1) == 1) {
                    maxVal = Math.max(maxVal, tree[l]);
                    l++;
                }
                if ((r & 1) == 1) {
                    r--;
                    maxVal = Math.max(maxVal, tree[r]);
                }
                l >>= 1;
                r >>= 1;
            }
            return maxVal;
        }
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int totalOnes = 0;

        // Use primitive 1D arrays instead of ArrayList<int[]> to eliminate GC overhead
        int[] blockStart = new int[n];
        int[] blockEnd = new int[n];
        int[] blockLen = new int[n];
        int m = 0; // Number of '0' blocks found

        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '1') {
                totalOnes++;
                i++;
            } else {
                int start = i;
                while (i < n && s.charAt(i) == '0') {
                    i++;
                }
                int end = i - 1;
                blockStart[m] = start;
                blockEnd[m] = end;
                blockLen[m] = end - start + 1;
                m++;
            }
        }

        // Pre-calculate adjacent pair sums
        int[] adjSum = new int[Math.max(0, m - 1)];
        for (int k = 0; k < m - 1; k++) {
            adjSum[k] = blockLen[k] + blockLen[k + 1];
        }

        SegmentTree st = new SegmentTree(adjSum);
        List<Integer> ans = new ArrayList<>(queries.length);

        for (int[] q : queries) {
            int L = q[0];
            int R = q[1];

            // Binary search: first block ending >= L
            int leftIdx = -1;
            int low = 0, high = m - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (blockEnd[mid] >= L) {
                    leftIdx = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Binary search: last block starting <= R
            int rightIdx = -1;
            low = 0; 
            high = m - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (blockStart[mid] <= R) {
                    rightIdx = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            int maxGain = 0;

            if (leftIdx != -1 && rightIdx != -1 && leftIdx <= rightIdx) {
                if (leftIdx + 1 == rightIdx) {
                    int overlapLeft = Math.min(R, blockEnd[leftIdx]) - Math.max(L, blockStart[leftIdx]) + 1;
                    int overlapRight = Math.min(R, blockEnd[rightIdx]) - Math.max(L, blockStart[rightIdx]) + 1;
                    maxGain = overlapLeft + overlapRight;
                } else if (leftIdx < rightIdx) {
                    int overlapLeft = Math.min(R, blockEnd[leftIdx]) - Math.max(L, blockStart[leftIdx]) + 1;
                    int overlapRight = Math.min(R, blockEnd[rightIdx]) - Math.max(L, blockStart[rightIdx]) + 1;

                    int leftPairGain = overlapLeft + blockLen[leftIdx + 1];
                    int rightPairGain = blockLen[rightIdx - 1] + overlapRight;

                    int middleMaxGain = st.query(leftIdx + 1, rightIdx - 2);

                    maxGain = Math.max(leftPairGain, Math.max(rightPairGain, middleMaxGain));
                }
            }

            ans.add(totalOnes + maxGain);
        }

        return ans;
    }
}