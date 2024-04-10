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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public TreeNode sortedListToBST(ListNode head) {
       if(head==null)return null;
        ListNode mid=mid(head);
        if(mid==null)return null;
        TreeNode root= new TreeNode(mid.val);
        if(head==mid)return root;
      
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(mid.next);
        mid.next=null;
        return root;
             
    }
    ListNode mid(ListNode head){
        if(head==null)return head;
        ListNode fast=head;
        ListNode slow= head;
        ListNode prev=null;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        if(prev!=null)
        prev.next=null;
        return slow;
    }
}
