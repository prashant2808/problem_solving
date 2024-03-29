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
    
    public int diameterOfBinaryTree(TreeNode root) {
        int  arr[]=new int [1];
         findmax(root,arr);
         return arr[0];
        
    }
     
    private int findmax(TreeNode root,int []arr)
    {
        if(root==null)
        return 0;
        
        int lh=findmax(root.left,arr);
        int rh=findmax(root.right,arr);
        arr[0]=Math.max(arr[0],lh+rh);
          return 1+Math.max(lh,rh);

         

    }
}
