class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
          for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
          for (int[] inv : invocations) {
             graph.get(inv[0]).add(inv[1]); 
        }

        boolean[] suspicious = new boolean[n];
         Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(k);
        suspicious[k] = true;

        while (!queue.isEmpty()) {
            int currentMethod = queue.poll();
            
            for (int nextMethod : graph.get(currentMethod)) {
                if (!suspicious[nextMethod]) {
                    suspicious[nextMethod] = true;
                    queue.offer(nextMethod);
                }
            }
        }

    boolean canRemove = true;
        for (int[] inv : invocations) {
            int caller = inv[0];
            int callee = inv[1];
            
            if (!suspicious[caller] && suspicious[callee]) {
                canRemove = false;
                break;
            }
        }

 List<Integer> result = new ArrayList<>();
        if (canRemove) {
            for (int i = 0; i < n; i++) {
                if (!suspicious[i]) {
                    result.add(i);
                 }
            }
        } else {
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
         }

        return result;

    }
}