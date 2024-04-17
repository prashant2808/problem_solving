public class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
      boolean [][] insides= new boolean [A+1][B+1];
      for(int i=0;i<=A;i++){
          for(int j=0;j<=B;j++){
              boolean isinside=false;
              for(int k=0;k<E.size();k++){
                  if((int)(Math.pow(E.get(k)-i,2)+Math.pow(F.get(k)-j,2))<=D*D){
                      isinside=true;
                      break;
                  }
              }
              insides[i][j]=isinside;
          }
      }
      Queue<Pair> q= new LinkedList<>();
      if(insides[0][0])return "NO";
      q.offer(new Pair(0,0));
      insides[0][0]=true;
      while(!q.isEmpty()){
          int s=q.size();
          
              Pair p= q.poll();
              int row=p.row;
              int col=p.col;
              if(row==A&&col==B)return "YES";
              for(int x1=-1;x1<=1;x1++){
                  for(int y1=-1;y1<=1;y1++){
                      if(x1==0&&y1==0)continue;
                      int nrow=row+x1;
                      int ncol=col+y1;
                      if(nrow>=0&&ncol>=0&&nrow<=A&&ncol<=B&&!insides[nrow][ncol]){
                          q.offer(new Pair(nrow,ncol));
                          insides[nrow][ncol]=true;
                      }
                      
                  }
              }  
      }
      return "NO";  
    }
}
