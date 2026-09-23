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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;

        while(temp!=null) {
            st.push(temp);
            temp = temp.next;
        }

        ListNode ans = st.pop();
        int max = ans.val;

        while(!st.isEmpty()) {
            ListNode node = st.pop();
            if(node.val < max) {
                continue;
            } else {
                node.next = ans;
                ans = node;
                max = node.val;
            }
        }
        return ans;

    }
}