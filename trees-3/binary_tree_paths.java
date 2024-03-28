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
    public List<String> binaryTreePaths(TreeNode root) {
       List<String> res= new ArrayList<>();
       traverse(root,res,""); 
       return res; 
    }
    void traverse(TreeNode root,List<String> res,String curr){
        if(root==null)return;
        if(root.left==null&&root.right==null){
            curr+=root.val;
            res.add(curr);
            return;   
        }
        traverse(root.left,res,curr+root.val+"->");
        traverse(root.right,res,curr+root.val+"->");
    }
}
