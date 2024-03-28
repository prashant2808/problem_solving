/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> res=  new ArrayList<>();
        find(A,B,res);
         Collections.reverse(res);
         return res;
        
    }
    static boolean find(TreeNode root,int B,ArrayList<Integer> res){
        if(root==null)return false;
        if(root.val==B){
            res.add(root.val);
            return true;
        }
        if(find(root.left,B,res)||find(root.right,B,res)){
            res.add(root.val);
            return true;
        }
        
        return false;  
    }
}
