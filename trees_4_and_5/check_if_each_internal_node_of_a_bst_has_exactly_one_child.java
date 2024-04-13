 
public class check_if_each_internal_node_of_a_bst_has_exactly_one_child {
  boolean check1(int [] preorder){    // 
    int  n=preorder.length;
    int last=preorder[n-1];
    for(int i=0;i<n-1;i++){
      int next=preorder[i+1];
      if((next<preorder[i]&&last<preorder[i])||(next>preorder[i]&&last>preorder[i]))continue;
      else return false;
    }
    return true;
  }
  

  // this is the second approach where i'm first building the bst and then checking by traversing it 
  boolean check_by_building_bst(int [] preorder){
    TreeNode root= construct(preorder,0,preorder.length-1);
    if(root==null)return true;
    return check2(root);
  }
  boolean check2(TreeNode root){
    if(root.left==null&&root.right==null)return true;
    if(root.left==null||root.right==null)return false;
    return check2(root.left)&&check2(root.right);

  }
  TreeNode construct(int [] preorder,int i,int j){
    if(i>j)return null;
    TreeNode root= new TreeNode(preorder[i]);
    int pivot=findpivot(preorder,i+1,j);
    if(pivot==-1){
        root.left=null;
        root.right=construct(preorder,i+1,j);
    }
    else {
        root.left=construct(preorder,i+1,pivot);
        root.right=construct(preorder,pivot+1,j);
    }
    return root;
}
int findpivot(int [] preorder,int i,int j){
    if(i>j)return -1;
    int pivot=-1;
    for(int x=i;x<=j;x++){
        if(preorder[i-1]>preorder[x]){
            pivot=x;
        }
        else break;
    }
    return pivot;
}    
}
 
