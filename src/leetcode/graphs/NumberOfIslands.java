package leetcode.graphs;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] M = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','1'}

        };
        System.out.println(new NumberOfIslands().numIslands(M));
        ;
    }

    /**
     * ACCEPTED
     * DFS - O(n_square)
     *
     * Runtime: 2 ms, faster than 50.31% of Java online submissions for Number of Islands.
     * Memory Usage: 44.5 MB, less than 10.39% of Java online submissions for Number of Islands.
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int islands = 0;
        int len = grid.length;
        for(int i=0; i<len; i++){
            for(int j = 0; j< grid[i].length; j++){
                char curr = grid[i][j];
                if(curr == '0') continue;
                if(curr == '1'){
                    islands++;
                    dfs(i,j, grid);

                }
            }
        }
        return islands;

    }
    public void dfs(int i, int j, char[][] grid){
        if(i>=0 && j>=0 &&
                i<grid.length &&
                j<grid[i].length &&

                grid[i][j] == '1'){
            grid[i][j] = '0';
            dfs(i,j+1,grid);
            dfs(i,j-1, grid);
            dfs(i+1,j,grid);
            dfs(i-1,j,grid);
        }
        else return;

    }
}
