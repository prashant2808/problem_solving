  class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
       boolean [][] vis=new boolean[m][n];
       int count =0;
       for(int i=0;i<m;i++)
       {
           for(int j=0;j<n;j++)
           {
               if(!vis[i][j]&&grid[i][j]=='1')
               {
                   dfs(i,j,grid,vis);
                   count++;
               }

           }
       }
       return count ;
    }
    private static void dfs(int i,int j,char[][]grid,boolean[][]vis)
    {
        if(i==grid.length||j==grid[0].length||i<0||j<0||grid[i][j]!='1'||vis[i][j])
        return;
        vis[i][j]=true;
        dfs(i+1,j,grid,vis);
        dfs(i-1,j,grid,vis);
        dfs(i,j+1,grid,vis);
        dfs(i,j-1,grid,vis);   
    }
} 
