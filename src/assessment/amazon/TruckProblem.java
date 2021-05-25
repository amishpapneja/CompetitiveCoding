package assessment.amazon;

import java.util.*;
import java.util.stream.Collectors;

class test {
    public static int fillTheTruck(int n, List<Integer> boxes, int unitSize, List<Integer> unitsPerBox, int truckSize) {
        int maxUnits = 0;

        if (boxes == null || boxes.size() == 0 || unitsPerBox == null
                || unitsPerBox.size() == 0 || truckSize <= 0 || n < 1) {
            return maxUnits;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<n; i++){
            int box = boxes.get(i);
            int unit = unitsPerBox.get(i);
            while(box > 0){
                maxHeap.add(unit);
                box--;
            }
        }

        while(truckSize >  0){
            if (!maxHeap.isEmpty()){
                maxUnits += maxHeap.poll();
            }
            truckSize--;
        }

        return maxUnits;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        List<Integer> boxes = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int unitSize = Integer.parseInt(scanner.nextLine());
        List<Integer> unitsPerBox = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int truckSize = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = fillTheTruck(num, boxes, unitSize, unitsPerBox, truckSize);
        System.out.println(res);
    }

    public static int getMaxUnit(int num, List<Integer> boxes, int unitSize, List<Integer> unitsPerBox, long truckSize) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < num; i++) {
            int n = boxes.get(i);
            for (int j = 0; j < n; j++) {
                PQ.add(unitsPerBox.get(i));
                max += PQ.peek();
                if (PQ.size() > truckSize) {
                    max -= PQ.peek();
                    PQ.remove();
                }
            }
        }
        return max;
    }

}





