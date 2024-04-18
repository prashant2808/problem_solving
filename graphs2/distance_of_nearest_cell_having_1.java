 class Tuple {
    int row;
    int col;
    int dist;
    public Tuple(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int m=grid.length;
        int n=grid[0].length;
        int [][] mindis= new int [m][n];
        for(int i=0;i<m;i++)Arrays.fill(mindis[i],Integer.MAX_VALUE);
        Queue<Tuple> q= new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    mindis[i][j]=0;
                    q.offer(new Tuple(i,j,0));
                }
            }
        }
        while(!q.isEmpty()){
            Tuple t= q.poll();
            int row=t.row;
            int col=t.col;
            int dist=t.dist;
            if(row+1<m&&mindis[row+1][col]>1+dist){
                mindis[row+1][col]=dist+1;
                q.offer( new Tuple(row+1,col,dist+1));
            }
            if(row-1>=0&&mindis[row-1][col]>1+dist){
                mindis[row-1][col]=dist+1;
                q.offer( new Tuple(row-1,col,dist+1));
            }
            if(col+1<n&&mindis[row][col+1]>1+dist){
                mindis[row][col+1]=dist+1;
                q.offer( new Tuple(row,col+1,dist+1));
            }
            if(col-1>=0&&mindis[row][col-1]>1+dist){
                mindis[row][col-1]=dist+1;
                q.offer( new Tuple(row,col-1,dist+1));
            }
             
        }
        return mindis;
        
    }
}
