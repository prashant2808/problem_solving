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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res= new ArrayList<>();
        if(root==null)return res;
        List<Integer> curr= new  ArrayList<>();
        check(root,targetSum,curr,res);
        return res;
        
    }
    void check(TreeNode root,int targetSum,List<Integer> curr,List<List<Integer>> res){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            if(targetSum-root.val==0){
                 // curr.add(root.val);
                curr.add(root.val);
                res.add(new ArrayList<>(curr));  
                curr.remove(curr.size()-1);
            }
            return ;  
        }
        curr.add(root.val);
         check(root.left,targetSum-root.val,curr,res);
         check(root.right,targetSum-root.val,curr,res);
         curr.remove(curr.size()-1);
        
    }
}
