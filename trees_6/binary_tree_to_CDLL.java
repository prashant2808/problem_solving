
//User function Template for Java



//User function Template for Java
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
   static Node prev;
   static Node first;
   // Node last=null;
    Node bTreeToClist(Node root)
    {
        prev=null;
        first=null;
        inorder(root);
        first.left=prev;
        prev.right=first;
        return first;
        
         
    }
    static void inorder(Node root){
        if(root==null)return ;
        inorder(root.left);
        if(prev==null){
            first=root;
        }
        root.left=prev;
        if(prev!=null)
        prev.right=root;
        prev=root;
        inorder(root.right);
    }
    
    
}
    
