/*
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
}
*/

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca=lca(root,a,b);
        return distance(lca,a)+distance(lca,b);
        
        
    }
   static   Node lca(Node root,int p,int q)
    {
        if(root==null)return null;
        if(root.data==p||root.data==q)return root;
        Node left=lca(root.left,p,q);
        Node right=lca(root.right,p,q);
        if(left!=null&&right!=null)return root;
        return left!=null?left:right;
    }
    static int distance(Node root,int target){
        if(root==null)return 1000000;
        if(root.data==target)return 0;
        int left=1+distance(root.left,target);
        int right=1+distance(root.right,target);
        return  Math.min(left,right);
    }
}
