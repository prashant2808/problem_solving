
/*class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution
{
	int getLevelDiff(Node root)
	{ 
	     int oddsum=0;
	     int evensum=0;
	     int level=1;
	     Queue<Node> q= new LinkedList<>();
	     q.offer(root);
	     while(!q.isEmpty()){
	         int s=q.size();
	         for(int i=0;i<s;i++){
	             Node x=q.poll();
	             if(level%2==0){
	                 evensum+=x.data;
	                 
	             }
	             else {
	                 oddsum+=x.data;
	             }
	             if(x.left!=null)q.offer(x.left);
	             if(x.right!=null)q.offer(x.right);
	         }
	         level++;
	     }
	     return oddsum-evensum;
	}
}
