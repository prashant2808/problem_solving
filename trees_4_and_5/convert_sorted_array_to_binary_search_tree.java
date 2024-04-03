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
    public TreeNode sortedArrayToBST(int[] nums) {
        return create(nums,0,nums.length-1);
        
    }
    TreeNode create(int [] nums,int st,int end){
        if(st>end)return null;
        int mid=(st+end)/2;
        TreeNode root= new TreeNode(nums[mid]);
        root.left=create(nums,st,mid-1);
        root.right=create(nums,mid+1,end);
        return root;
    }
}
