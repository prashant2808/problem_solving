 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        Queue<TreeNode> q= new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode node=q.poll();
            if(node==null)
            {
                sb.append("n ");
                continue;
            }
            sb.append(node.val+" ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0)return null;
        Queue<TreeNode> q= new LinkedList<>();
        String [] arr=data.split(" ");
        TreeNode root= new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
         for(int i=1;i<arr.length;i++)
         {
             TreeNode temp=q.poll();
             if(!arr[i].equals("n"))
             {
                 TreeNode left= new TreeNode(Integer.parseInt(arr[i]));
                 temp.left=left;
                 q.add(left);
             }
             if(!arr[++i].equals("n"))
             {
                 TreeNode right= new TreeNode(Integer.parseInt(arr[i]));
                 temp.right=right;
                 q.add(right);
             }
         }
         return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
