package companies;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class BouncingDiagnols {

    class Path{
        int start;
        int sum = 0;
        List<Integer> path = new ArrayList<>();

        public Path(int start){
            this.start = start;
        }
    }

    private void constructPath(int dir_idx, int i, int j, int[][] matrix, Path path){
        int[][] dirs = {
                {-1, 1},
                {1,1}
        };
        int[] dir = dirs[dir_idx];

        if(dir_idx == 0){
            while(i >= 0 ){
                path.path.add(matrix[i][j]);
                path.sum += matrix[i][j];
                if(j == matrix[0].length - 1){
                    return;
                }
                i += dir[0];
                j += dir[1];
            }
            i += 2 ;
            constructPath(1, i, j, matrix, path);
        }
        if(dir_idx == 1){
            while(i < matrix[0].length){
                path.path.add(matrix[i][j]);
                path.sum += matrix[i][j];
                if(j == matrix[0].length - 1){
                    return;
                }
                i += dir[0];
                j += dir[1];
            }
            i -= 2;
            constructPath(0, i, j, matrix, path);
        }

    }

    private Path getPath(int start, int[][] matrix){

        int i = start, j = 0;
        Path path = new Path(matrix[i][j]);
        constructPath(0, i, j, matrix, path);
        return path;
    }

    public int[] bouncingDiagnals(int[][] matrix){
        if(matrix == null || matrix.length == 0||matrix[0].length == 0){
            return new int[0];
        }
        PriorityQueue<Path> pq = new PriorityQueue<>(new Comparator<Path>() {
            @Override
            public int compare(Path o1, Path o2) {
                if(o1.sum != o2.sum){
                    return o1.sum - o2.sum;
                }
                else{
                    int i = 0;
                    while(i < o1.path.size() && i < o2.path.size()){
                        if(o1.path.get(i) != o2.path.get(i)){
                            return o1.path.get(i) - o2.path.get(i);
                        }
                    }
                    if(o1.path.size() == i && o2.path.size() !=i){
                        return 1;
                    }
                    else if (o1.path.size() != i && o2.path.size() == i){
                        return -1;
                    }
                    return 0;
                }
            }
        });

        for(int i = 0; i < matrix.length; i ++){
            Path p = getPath(i, matrix);
            pq.add(p);
        }
        int[] rst = new int[matrix.length];
        int i = 0;
        while(!pq.isEmpty()){
            rst[i++] = pq.poll().start;
        }
        return rst;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {2,3,2},
                {0,2,5},
                {1,0,1}
        };
        int[][] matrix2 = {
                {1,3,2,5},
                {3,2,5,0},
                {9,0,1,3},
                {6,1,0,8}

        };

        int[] rst = new BouncingDiagnols().bouncingDiagnals(matrix2);
        for(int rs : rst)System.out.println(rs);
    }
}