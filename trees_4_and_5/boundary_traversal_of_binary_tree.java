/************************************************************

 Following is the Binary Tree node structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/
import java.util.*;
import java.util.List;

public class Solution {
    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        List<Integer> res = new ArrayList<>();
        if(root==null)return res;
        res.add(root.data);
        res.addAll(left(root));
        leaves(root,res);
        res.addAll(right(root));
        return res;

    }
   static  List<Integer> left(TreeNode root){
        List<Integer> li= new ArrayList<>();
        TreeNode curr=root.left;
         
        while(curr!=null){
            if(isLeaf(curr))break;
            else{
                li.add(curr.data);
                if(curr.left!=null)curr=curr.left;
                else curr=curr.right;
            }
        }
        
        return li;

    }
   static  List<Integer> right(TreeNode root){
        List<Integer> li= new ArrayList<>();
        TreeNode curr=root.right;
        while(curr!=null){
            if(isLeaf(curr))break;
            else{
                li.add(0,curr.data);
                if(curr.right!=null)curr=curr.right;
                else curr=curr.left;
            }
        }
       
         
        return li;

    }
    static void leaves(TreeNode root,List<Integer> li){
        if(root==null)return;
        leaves(root.left,li);
         if(isLeaf(root)){
             li.add(root.data);
         }
         leaves(root.right,li);
    }
   static  boolean isLeaf(TreeNode root){
        return root.left==null&&root.right==null;
    }
}
