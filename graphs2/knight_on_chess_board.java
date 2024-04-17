 public class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int knight(int A, int B, int C, int D, int E, int F) {
        if(C==E&&D==F)return 0;
        int dirx[]={1,2,-1,-2,1,2,-1,-2};
        int diry[]={2,1,2,1,-2,-1,-2,-1};
        boolean [][] vis= new boolean [A][B];
        Queue<Pair> q = new LinkedList<>();
        int steps=0;
        q.offer(new Pair(C,D));
        vis[C-1][D-1]=true;
        while(!q.isEmpty()){
            int s=q.size();
            while(s-->0){
                Pair p= q.poll();
                int row=p.row;
                int col=p.col;
                if(row==E&&col==F)return steps;
                for(int i=0;i<8;i++){
                    int nrow=dirx[i]+row;
                    int ncol=diry[i]+col;
                    if(nrow>=1&&ncol>=1&&nrow<=A&&ncol<=B&&!vis[nrow-1][ncol-1]){
                        q.offer(new Pair(nrow,ncol));
                        vis[nrow-1][ncol-1]=true;
                    }
                }
            }
            steps++;
            
        }
        
        return -1;
    }
    
}
