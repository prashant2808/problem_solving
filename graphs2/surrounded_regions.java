class Solution {
  public void solve(char[][] board) {
      int m=board.length;
      int n=board[0].length;
      boolean vis[][]= new boolean [m][n];
      for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
              if(board[i][j]=='O'&&check(i,j,board,vis)){
                  System.out.println("i - >"+i+" j -> "+j);
                  mark(i,j,board);
              }
              vis= new boolean [m][n];
          }
      }  
  }
  boolean check(int i,int j,char [][] board,boolean [][] vis){
      if(i<0||j<0||i==board.length||j==board[0].length){
          return false;
      }
      if(vis[i][j]||board[i][j]=='X')return true;
      vis[i][j]=true;
      return check(i+1,j,board,vis)
      &&check(i-1,j,board,vis)
      &&check(i,j+1,board,vis)
      &&check(i,j-1,board,vis);
  }
  void mark(int i,int j,char [][] board){
       if(i==0||j==0||i==board.length||j==board[0].length||board[i][j]=='X'){
          return;
      }
      board[i][j]='X';
      mark(i+1,j,board);
      mark(i-1,j,board);
      mark(i,j+1,board);
      mark(i,j-1,board);
  }
}