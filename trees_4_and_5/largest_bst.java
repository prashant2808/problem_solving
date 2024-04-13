
//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class NodeValue{
    int min;
    int max;
    int size;
    public NodeValue(int min,int max,int size){
        this.min=min;
        this.max=max;
        this.size=size;
        
    }
}
class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        return traverse(root).size;
        
    }
    private static NodeValue traverse(Node root){
        if(root==null){
            return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        NodeValue left= traverse(root.left);
        NodeValue right=traverse(root.right);
        int min=Math.min(root.data,left.min);
        int max=Math.max(root.data,right.max);
        int size=left.size+right.size+1;
        if(root.data>left.max&&root.data<right.min){
            return new NodeValue(min,max,size);
        }
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.size,right.size));
    }
    
}
