class Solution {
    class Node {
        int[] remain;
        int prod;

        Node(int k) {
            remain = new int[k];
            prod = 1;
        }
    }

    class SegmentTree {
        private int n, k;
        private Node[] tree;

        public SegmentTree(int[] nums, int k) {
            this.n = nums.length;
            this.k = k;
            this.tree = new Node[4 * n];
            for (int i = 0; i < 4 * n; i++) {
                tree[i] = new Node(k);
            }
            build(nums, 0, 0, n - 1);
        }

        private Node merge(Node left, Node right) {
            Node node = new Node(k);
            node.prod = (left.prod * right.prod) % k;
            for (int i = 0; i < k; ++i) {
                node.remain[i] = left.remain[i];
            }
            for (int i = 0; i < k; ++i) {
                node.remain[(i * left.prod) % k] += right.remain[i];
            }
            return node;
        }

        private void build(int[] nums, int cur, int left, int right) {
            if (left == right) {
                tree[cur].remain[nums[left] % k] = 1;
                tree[cur].prod = nums[left] % k;
                return;
            }
            int mid = (left + right) / 2;
            build(nums, 2 * cur + 1, left, mid);
            build(nums, 2 * cur + 2, mid + 1, right);
            tree[cur] = merge(tree[2 * cur + 1], tree[2 * cur + 2]);
        }

        public void update(int index, int val) {
            update(0, 0, n - 1, index, val % k);
        }

        private void update(int treeIndex, int lo, int hi, int i, int val) {
            if (lo == hi) {
                java.util.Arrays.fill(tree[treeIndex].remain, 0);
                tree[treeIndex].remain[val] = 1;
                tree[treeIndex].prod = val;
                return;
            }
            int mid = (lo + hi) / 2;
            if (i <= mid) {
                update(2 * treeIndex + 1, lo, mid, i, val);
            } else {
                update(2 * treeIndex + 2, mid + 1, hi, i, val);
            }
            tree[treeIndex] = merge(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
        }

        public Node query(int i, int j) {
            return query(0, 0, n - 1, i, j);
        }

        private Node query(int treeIndex, int lo, int hi, int i, int j) {
            if (i <= lo && hi <= j) {
                return tree[treeIndex];
            }
            if (j < lo || hi < i) {
                Node empty = new Node(k);
                empty.prod = 1;
                return empty;
            }
            int mid = (lo + hi) / 2;
            return merge(query(2 * treeIndex + 1, lo, mid, i, j), 
                         query(2 * treeIndex + 2, mid + 1, hi, i, j));
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        SegmentTree tree = new SegmentTree(nums, k);
        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            tree.update(index, value);
            Node resNode = tree.query(start, n - 1);
            ans[q] = resNode.remain[x];
        }

        return ans;
    }
}