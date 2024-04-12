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
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder,0,preorder.length-1);      
    }
    TreeNode construct(int [] preorder,int i,int j){
        if(i>j)return null;
        TreeNode root= new TreeNode(preorder[i]);
        int pivot=findpivot(preorder,i+1,j);
        if(pivot==-1){
            root.left=null;
            root.right=construct(preorder,i+1,j);
        }
        else {
            root.left=construct(preorder,i+1,pivot);
            root.right=construct(preorder,pivot+1,j);
        }
        return root;
    }
    int findpivot(int [] preorder,int i,int j){
        if(i>j)return -1;
        int pivot=-1;
        for(int x=i;x<=j;x++){
            if(preorder[i-1]>preorder[x]){
                pivot=x;
            }
            else break;
        }
        return pivot;
    }
}
