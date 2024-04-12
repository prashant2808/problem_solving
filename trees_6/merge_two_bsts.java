//User function Template for Java


/*
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
    
*/
class Solution
{
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        if (root1 == null && root2 == null)
            return ans;
        
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        
        addToStack(root1, s1);
        addToStack(root2, s2);
        
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.peek().data < s2.peek().data) {
                ans.add(s1.peek().data);
                addToStack(s1.pop().right, s1);
            } else  {
                ans.add(s2.peek().data);
                addToStack(s2.pop().right, s2);
            }
        }
        
        while (!s1.isEmpty()) {
            ans.add(s1.peek().data);
            addToStack(s1.pop().right, s1);
        }
        
        while (!s2.isEmpty()) {
            ans.add(s2.peek().data);
            addToStack(s2.pop().right, s2);
        }
        
        return ans;
    }
    private static void addToStack(Node node, Stack<Node> stack) {
        if (node == null)
            return;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
