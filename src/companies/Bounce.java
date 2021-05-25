package companies;

import java.util.*;

public class Bounce {
    public static void main(String[] args) {
        int[][] matrix = {
                {2,3,2},
                {0,2,5},
                {1,0,1}



        };
        bounce(matrix);

    }
    public static int bounce(int[][] matrix){
//        List<Integer> list = new ArrayList<>();
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        int size = matrix.length -1;
        for(int i=0; i <=size; i++){
            int key = matrix[i][0];
            int weight = 0;
            for( int j=0; j<=size; j++) {
                if (j == 0) {
                    weight += matrix[j][i];

                } else if (i == size) {
                    weight += matrix[size - j][j];
                } else {
//                    int diagnalUp = Math.abs(j - i);
                    int diagnolDown = size - (Math.abs(size - (i + j)) % size);
//                    weight += matrix[diagnalUp][j];
                    weight += matrix[diagnolDown][j];

                }
            }
            map.put(key, weight);
        }

        List<Map.Entry<Integer, Integer> > list =
                new LinkedList<Map.Entry<Integer, Integer> >(map.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }


//        return weights;
        return 0;
    }

}
