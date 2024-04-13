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
 class NodeValue{
    int min;
    int max;
    int maxsum;
    public NodeValue(int min,int max,int maxsum){
        this.min=min;
        this.max=max;
        this.maxsum=maxsum;
        
    }
}
class Solution {
    int maxbstsum;
    public int maxSumBST(TreeNode root) {
        maxbstsum=Integer.MIN_VALUE;
        traverse(root);
        return maxbstsum<0?0:maxbstsum;    
    }
    private NodeValue traverse(TreeNode root){
        if(root==null){
            return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        NodeValue left= traverse(root.left);
        NodeValue right=traverse(root.right);
        int min=Math.min(root.val,left.min);
        int max=Math.max(root.val,right.max);
        int sum=left.maxsum+right.maxsum+root.val;   
        if(root.val>left.max&&root.val<right.min){
             maxbstsum=Math.max(maxbstsum,sum);
            return new NodeValue(min,max,sum);
        }
         maxbstsum=Math.max(maxbstsum,Math.max(left.maxsum,right.maxsum));
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxsum,right.maxsum));
    }
}

 
