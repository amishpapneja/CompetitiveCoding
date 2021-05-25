package assessment.twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SocialNetwork {
    public static void main(String[] args) {
//        Integer yo[] =new int[5]{2,1,1,2,1};
        List<Integer> yo2 = new ArrayList<>();
        List<Integer> input1 = Arrays.asList(3,3,3,3,3,1,3);
        List<Integer> input2 = Arrays.asList(2,2,2,2);

        yo2.add(2);
        yo2.add(1);
        yo2.add(1);
        yo2.add(2);
        yo2.add(1);
//        yo2.add(2);

        socialGraphs(input1);

    }
    public static void socialGraphs(List<Integer> counts) {
        int countSize = counts.size();
        boolean[] isVisited = new boolean[countSize];


        for(int i=0;i<countSize;i++){
            Integer foundSize = counts.get(i);
            int limit = foundSize;
            List<Integer> currentGroup = new ArrayList<>();
            if(!isVisited[i]){
                currentGroup.add(i);
                isVisited[i] = true;
                limit--;
            }
//            int j= i=1;
            for(int j = i+1;j<countSize;j++){
                if(counts.get(j)==foundSize && limit!=0 && !isVisited[j]){
                    currentGroup.add(j);
                    isVisited[j] = true;
                    limit--;
                }

            }
            if(currentGroup.size()!=0)System.out.println(currentGroup);
        }

    }
}
