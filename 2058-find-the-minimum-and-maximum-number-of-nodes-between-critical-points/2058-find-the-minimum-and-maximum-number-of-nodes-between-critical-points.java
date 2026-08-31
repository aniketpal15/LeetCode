/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
          if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode temp = head.next;
        ListNode nextone = temp.next;

        int firstCritical = -1;
        int lastCritical = -1;
        int minDistance = Integer.MAX_VALUE;
        int i = 1;

        while (nextone != null) {
            int a = prev.val;
            int b = temp.val;
            int c = nextone.val;

            if ((a > b && b < c) || (a < b && b > c)) {
                if (firstCritical == -1) {
                    firstCritical = i;
                } else {
                    minDistance = Math.min(minDistance, i - lastCritical);
                }
                lastCritical = i;
            }

            i++;
            prev = temp;
            temp = nextone;
            nextone = nextone.next;
        }
        if (firstCritical == -1 || firstCritical == lastCritical) {
            return new int[]{-1, -1};
        }

        int maxDistance = lastCritical - firstCritical;
        return new int[]{minDistance, maxDistance};
    }
}