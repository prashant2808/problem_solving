class TrieNode{
  private char ch;
  private  TrieNode [] children= new TrieNode[26];
 private int wordend;
 public TrieNode(){}
 public TrieNode(char ch,int wordend){
  this.ch=ch;
  this.wordend=wordend;
 }
 public  TrieNode []  getChildren(){
  return children;
 }
 public void setChildren(TrieNode [] children){
  this.children=children;
 }
 public int getWordEnd(){
  return wordend;
 }
 public void setWordEnd(int wordend){
  this.wordend=wordend;
 }
}
class Trie {
   private TrieNode root;

  public Trie() {
      root= new TrieNode();
  }
  public void insert(String word) {
      TrieNode [] children= root.getChildren();
       TrieNode node=root;
      for(int i=0;i<word.length();i++){
          char ch=word.charAt(i);
          int id=(int)(ch-'a');
          if(children[id]==null){
              children[id]= new TrieNode(ch,0);
          }
              node =children[id];
              children=node.getChildren();
          if(i==word.length()-1){
              node.setWordEnd(node.getWordEnd()+1);
          }
      }
  }
  
  public boolean search(String word) {
       TrieNode [] children= root.getChildren();
       TrieNode node =null;
       for(int i=0;i<word.length();i++){
          char ch=word.charAt(i);
          int id=(int)(ch-'a');
          if(children[id]!=null){
              node =children[id];
              children=node.getChildren();
          }
          else {
              node=null;
              break;
          }
       }
       if(node!=null&&node.getWordEnd()>0)return true;
       else return false;
      
  }
  
  public boolean startsWith(String prefix) {
      TrieNode [] children= root.getChildren();
       TrieNode node =null;
       int i=0;
       while(i<prefix.length()){
          char ch=prefix.charAt(i);
          int id=(int)(ch-'a');
          if(children[id]!=null){
              node =children[id];
              children=node.getChildren();
              i++;
          }
          else {
              node=null;
              break;
          }
       }
       if(i==prefix.length())return true;
       else return false;  
  }
}

/**
* Your Trie object will be instantiated and called as such:
* Trie obj = new Trie();
* obj.insert(word);
* boolean param_2 = obj.search(word);
* boolean param_3 = obj.startsWith(prefix);
*/
