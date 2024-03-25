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
    public List<List<Integer>> levelOrder(TreeNode root) {
        TreeMap<Integer,List<Integer>>map= new TreeMap<>();
        traverse(root,0,map);
        List<List<Integer>> res= new ArrayList<>();
        for(List<Integer> li:map.values())res.add(li);
        return res;

        
    }
    void traverse(TreeNode root,int level,TreeMap<Integer,List<Integer>> map){
        if(root==null)return;
        if(!map.containsKey(level)){
            map.put(level,new ArrayList<>());
        }
        map.get(level).add(root.val);
        traverse(root.left,level+1,map);
        traverse(root.right,level+1,map);
    }
}
