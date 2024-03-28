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
    int ans;
    int anslev;
    public int findBottomLeftValue(TreeNode root) {
        ans=-1;
        anslev=-1;
        traverse(root,0);
        return ans;
    }
    void traverse(TreeNode root,int level){
        if(root==null)return;
        if(root.left==null&&root.right==null){
            if(level>anslev){
                ans=root.val;
                anslev=level;
            }
            return;
        }
         
        traverse(root.left,level+1);
        traverse(root.right,level+1);
    }
}
