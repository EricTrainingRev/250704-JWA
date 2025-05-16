import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean hasCycle(ListNode head) {
        Map<Integer, Integer> nodeMap = new HashMap<>();

        ListNode cursor = head;
        Integer index = 0;
        while(true){
            if(nodeMap.containsKey(cursor.val)) return true;
            if(cursor.next == null) return false;
            nodeMap.put(cursor.val, index);
            index++;
            cursor = cursor.next;
        }

        /* //Two pointer solution
        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while(true) {
            if (slow == fast) return true;
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        */
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}