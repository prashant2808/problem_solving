// User function Template for Java

class Tree {
   static int ans=-1;
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        find(root,key);
        return ans;
    }
  static  void find (Node root,int key){
        if(root==null)return;
        if(root.data==key){
            ans=key;
            return ;
        }
        if(root.data>key){
            ans=root.data;
            find(root.left,key);
        }
        if(root.data<key){
            find(root.right,key);
        }
  
    }
}
