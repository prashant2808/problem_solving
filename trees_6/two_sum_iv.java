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
    public boolean search(TreeNode n,int key)
    {
        while(n!=null && n.val!=key)
        {
            n=(key<n.val)?n.left:n.right;
        }
        return n==null?false:true;
    }
    public boolean inorder(TreeNode node,TreeNode root,int k)
    {
        if(node!=null)
        {
            if(inorder(node.left,root,k)==true)
                return true;
            if(node.val!=k/2 && search(root,k-node.val)==true)
                return true;
            return inorder(node.right,root,k);
        }
        return false;
    }
    public boolean findTarget(TreeNode root, int k) {
        return inorder(root,root,k);
    }
}

