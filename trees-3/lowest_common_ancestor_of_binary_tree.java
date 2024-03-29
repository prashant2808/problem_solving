/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return root;
        return path(root,p,q);
    }
    TreeNode path(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root==null)return null;
        if(root==p||root==q)return root;
        TreeNode left=path(root.left,p,q);
        TreeNode right=path(root.right,p,q);
        if(left!=null&&right!=null)return root;
        return left!=null?left:right;
    }
        
   }
