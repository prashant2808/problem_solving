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
    TreeNode res=null;
    int x;
    public int kthSmallest(TreeNode root, int k) {
        x=k;
        inorder(root,k);
        return res.val;
    }
    void inorder(TreeNode root,int k){
        if(root==null)return ;
       inorder(root.left,k);
       x--;
       if(x==0){
        res=root;
        return;
       }
       inorder(root.right,k);
    }
}
