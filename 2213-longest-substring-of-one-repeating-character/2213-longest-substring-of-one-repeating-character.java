class Solution {
     private int[] maxLen;
    private int[] preLen;
    private int[] sufLen;
    private char[] preChar;
    private char[] sufChar;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryIndices.length;
        
        maxLen = new int[4 * n];
        preLen = new int[4 * n];
        sufLen = new int[4 * n];
        preChar = new char[4 * n];
        sufChar = new char[4 * n];
        
        build(1, 0, n - 1, s);
        
        int[] result = new int[k];
        
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);
            
            update(1, 0, n - 1, idx, ch);
            
            result[i] = maxLen[1];
        }
        
        return result;
    }

    private void build(int node, int l, int r, String s) {
        if (l == r) {
            char ch = s.charAt(l);
            maxLen[node] = preLen[node] = sufLen[node] = 1;
            preChar[node] = sufChar[node] = ch;
            return;
        }
        
        int mid = l + (r - l) / 2;
        int leftNode = node * 2;
        int rightNode = node * 2 + 1;
        
        build(leftNode, l, mid, s);
        build(rightNode, mid + 1, r, s);
        
        merge(node, l, r);
    }

    private void update(int node, int l, int r, int idx, char ch) {
        if (l == r) {
            preChar[node] = sufChar[node] = ch;
            return;
        }
        
        int mid = l + (r - l) / 2;
        int leftNode = node * 2;
        int rightNode = node * 2 + 1;
        
        if (idx <= mid) {
            update(leftNode, l, mid, idx, ch);
        } else {
            update(rightNode, mid + 1, r, idx, ch);
        }
        
        merge(node, l, r);
    }

    private void merge(int node, int l, int r) {
        int mid = l + (r - l) / 2;
        int leftNode = node * 2;
        int rightNode = node * 2 + 1;
        
        int leftSize = mid - l + 1;
        int rightSize = r - mid;

        preChar[node] = preChar[leftNode];
        sufChar[node] = sufChar[rightNode];

        preLen[node] = preLen[leftNode];
        if (preLen[leftNode] == leftSize && sufChar[leftNode] == preChar[rightNode]) {
            preLen[node] += preLen[rightNode];
        }

        sufLen[node] = sufLen[rightNode];
        if (sufLen[rightNode] == rightSize && sufChar[leftNode] == preChar[rightNode]) {
            sufLen[node] += sufLen[leftNode];
        }

        maxLen[node] = Math.max(maxLen[leftNode], maxLen[rightNode]);
        if (sufChar[leftNode] == preChar[rightNode]) {
            maxLen[node] = Math.max(maxLen[node], sufLen[leftNode] + preLen[rightNode]);
        }
    }

}