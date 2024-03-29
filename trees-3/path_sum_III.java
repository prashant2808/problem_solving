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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)return 0;
        HashMap<Long,Integer> map= new HashMap<>();
        map.put(0L,1);
        return find(root,targetSum,map,0);
        
    }
    int find(TreeNode root,int targetSum,HashMap<Long,Integer> map,long currSum){
        if(root==null){
            return  0;
        }
        currSum+=root.val;
      //  if(root.left==null&&root.right==null){
         //   System.out.println("cursum is ->"+currSum);
          //  return set.contains(currSum-targetSum)?1:0;
       // }
       int count=0;
       if(map.containsKey(currSum-targetSum))count+=map.get(currSum-targetSum);
        map.put(currSum,map.getOrDefault(currSum,0)+1);
        count+=find(root.left,targetSum,map,currSum);
        count+=find(root.right,targetSum,map,currSum);
        map.put(currSum,map.get(currSum)-1);
        return count ;
    }
}
