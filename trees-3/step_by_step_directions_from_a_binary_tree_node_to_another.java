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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca=lca(root,startValue,destValue);
     return leftdirection(lca,startValue,new StringBuilder())+rightdirection(lca,destValue,new StringBuilder());
    }
    TreeNode lca(TreeNode root,int p,int q)
    {
        if(root==null)return null;
        if(root.val==p||root.val==q)return root;
        TreeNode left=lca(root.left,p,q);
        TreeNode right=lca(root.right,p,q);
        if(left!=null&&right!=null)return root;
        return left!=null?left:right;
    }
    String leftdirection(TreeNode root,int target,StringBuilder sb){
        if(root==null)return "";
        if(root.val==target){
            return sb.toString();
        }
        sb.append('U');
        String left=leftdirection(root.left,target,sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append('U');
        String right=leftdirection(root.right,target,sb);
        sb.deleteCharAt(sb.length()-1);
        return left.length()==0?right:left;
    }
    String rightdirection(TreeNode root,int target,StringBuilder sb){
        if(root==null)return "";
        if(root.val==target){
            return sb.toString();
        }
        sb.append('L');
        String left=rightdirection(root.left,target,sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append('R');
        String right=rightdirection(root.right,target,sb);
        sb.deleteCharAt(sb.length()-1);
        return left.length()==0?right:left;
    }   
}
