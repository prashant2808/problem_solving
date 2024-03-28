import java.util.*;
/*************************************************************

     Following is thr TreeNode class structure

     class BinaryTreeNode<T>
     {
         T data;
         BinaryTreeNode<T> left;
         BinaryTreeNode<T> right;

         BinaryTreeNode(T data) {
             this.data = data;
             left = null;
             right = null;
         }
     };

 *************************************************************/

public class Solution {
    public static void printLeftView(TreeNode<Integer> root) {
        // Write your code here.
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode x=q.poll();
                if(i==0){
                    System.out.print(x.data+" ");
                }
                if(x.left!=null)q.offer(x.left);
                if(x.right!=null)q.offer(x.right);
            }
        }
    }
}
