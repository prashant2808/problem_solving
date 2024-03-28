

//User function Template for Java


 class Pair{
    Node node;
    int col;
    public Pair(Node node ,int col)
    {
        this.node=node;
        this.col=col;
    }

}

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> bottomView(Node root)
    {
         ArrayList<Integer> res = new ArrayList<>();
         TreeMap<Integer,Integer> map =new TreeMap<>();
         Queue<Pair> q= new LinkedList<>();
         q.offer(new Pair(root,0));
         while(!q.isEmpty())
         {
             Pair temp = q.poll();
             int col=temp.col;
             Node node =temp.node;
             if(map.get(col)==null)map.put(col,node.data);
             else
             {
                 map.put(col,node.data);
             }
             if(node.left!=null)q.offer(new Pair(node.left,col-1));
             if(node.right!=null)q.offer(new Pair(node.right,col+1));
         }
         for(int value:map.values())
         {
             res.add(value);
         }
         return res;
        
    }
}
