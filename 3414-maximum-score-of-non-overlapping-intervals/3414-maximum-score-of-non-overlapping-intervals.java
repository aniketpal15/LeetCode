import java.util.*;

class Solution {
    static class Interval {
        long l, r, weight;
        int id;

        Interval(long l, long r, long weight, int id) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.id = id;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] A = new Interval[n];
        for (int i = 0; i < n; i++) {
            List<Integer> curr = intervals.get(i);
            A[i] = new Interval(curr.get(0), curr.get(1), curr.get(2), i);
        }

        // Sort intervals by start time ascending
        Arrays.sort(A, (a, b) -> Long.compare(a.l, b.l));

        long[] starts = new long[n];
        for (int i = 0; i < n; i++) {
            starts[i] = A[i].l;
        }

        // dp[i][k]: max weight using at most k non-overlapping intervals from A[i...n-1]
        long[][] dp = new long[n + 1][5];

        for (int i = n - 1; i >= 0; i--) {
            int nextIdx = upperBound(starts, i + 1, n, A[i].r);
            for (int k = 1; k <= 4; k++) {
                long skip = dp[i + 1][k];
                long take = A[i].weight + dp[nextIdx][k - 1];
                dp[i][k] = Math.max(skip, take);
            }
        }

        List<Integer> bestIndices = reconstruct(0, 4, A, starts, dp, n, new HashMap<>());
        
        int[] result = new int[bestIndices.size()];
        for (int i = 0; i < bestIndices.size(); i++) {
            result[i] = bestIndices.get(i);
        }
        return result;
    }

    private int upperBound(long[] arr, int low, int high, long target) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private List<Integer> reconstruct(int i, int k, Interval[] A, long[] starts, long[][] dp, int n, Map<String, List<Integer>> memo) {
        if (i >= n || k == 0 || dp[i][k] == 0) {
            return new ArrayList<>();
        }

        String key = i + "," + k;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int nextIdx = upperBound(starts, i + 1, n, A[i].r);
        long skipVal = dp[i + 1][k];
        long takeVal = A[i].weight + dp[nextIdx][k - 1];

        List<Integer> resTake = null;
        List<Integer> resSkip = null;

        if (takeVal == dp[i][k]) {
            resTake = new ArrayList<>();
            resTake.add(A[i].id);
            resTake.addAll(reconstruct(nextIdx, k - 1, A, starts, dp, n, memo));
            Collections.sort(resTake);
        }

        if (skipVal == dp[i][k]) {
            resSkip = reconstruct(i + 1, k, A, starts, dp, n, memo);
        }

        List<Integer> result;
        if (resTake != null && resSkip != null) {
            result = compareLists(resTake, resSkip) <= 0 ? resTake : resSkip;
        } else {
            result = (resTake != null) ? resTake : resSkip;
        }

        memo.put(key, result);
        return result;
    }

    private int compareLists(List<Integer> a, List<Integer> b) {
        int size = Math.min(a.size(), b.size());
        for (int i = 0; i < size; i++) {
            int cmp = Integer.compare(a.get(i), b.get(i));
            if (cmp != 0) return cmp;
        }
        return Integer.compare(a.size(), b.size());
    }
}