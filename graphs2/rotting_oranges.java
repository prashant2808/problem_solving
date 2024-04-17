class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q= new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)q.offer(new Pair(i,j));
            }
        }
        int time=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair p= q.poll();
                int row=p.row;
                int col=p.col; 
                if(row+1<m&&grid[row+1][col]==1){
                    grid[row+1][col]=2;
                  q.offer(new Pair(row+1,col));  
                }
                if(row-1>=0&&grid[row-1][col]==1){
                    grid[row-1][col]=2;
                  q.offer(new Pair(row-1,col));  
                }
                if(col+1<n&&grid[row][col+1]==1){
                    grid[row][col+1]=2;
                  q.offer(new Pair(row,col+1));  
                }
                if(col-1>=0&&grid[row][col-1]==1){
                    grid[row][col-1]=2;
                  q.offer(new Pair(row,col-1));  
                }
            }
            if(q.size()>0)time++;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)return -1;
            }
        }
        
        return time;
        
    }
}
