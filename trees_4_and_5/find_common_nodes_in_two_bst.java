
class Solution
{
    //Function to find the nodes that are common in both BST.
	public static ArrayList<Integer> findCommon(Node root1,Node root2)
    {
        //code here
         ArrayList<Integer> res= new ArrayList<>();
         search(root1,res,root2);
         return res;
    }
  static void search(Node root1,ArrayList<Integer> res,Node root2){
        if(root1==null)return;
        search(root1.left,res,root2);
        if(isexist( root2,root1.data))res.add(root1.data);
        search(root1.right,res,root2);
    }
    static boolean isexist(Node root,int val){
        if(root==null)return false;
        if(root.data==val)return true;
        if(root.data>val) return isexist(root.left,val);
        return  isexist(root.right,val);
    }
    
}
