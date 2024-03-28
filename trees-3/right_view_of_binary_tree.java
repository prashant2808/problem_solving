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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        if(root==null)return res;
         Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode x=q.poll();
                if(i==s-1){
                     res.add(x.val);
                }
                if(x.left!=null)q.offer(x.left);
                if(x.right!=null)q.offer(x.right);
            }
        }
        return res;
        
    }
}
