package leetcode.maximumAverage;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node {
    int pass;
    int total;
    double avg;
    double gain;

    Node(int p, int t) {
        this.pass = p;
        this.total = t;
        this.avg = (double) p / t;
        this.gain = (double) (p + 1) / (t + 1) - this.avg;
    }

    public String toString() {
        return "[" + this.pass + "," + this.total + "]";
    }
}

class Solution {
    /**
     * ACCEPTED
     * Runtime: 343 ms, faster than 80.74% of Java online submissions for Maximum Average Pass Ratio.
     * Memory Usage: 84.4 MB, less than 84.46% of Java online submissions for Maximum Average Pass Ratio.
     * @param classes
     * @param extraStudents
     * @return
     */
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingDouble(x -> x.gain));
        // maxHeap
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> Double.compare(b.gain, a.gain));

        for (int[] tup : classes) {
            q.add(new Node(tup[0], tup[1]));
        }
        int count = extraStudents;
        while (count > 0) {
            System.out.println(q);
            Node top = q.poll();
            Node temp = new Node(top.pass + 1, top.total + 1);
            q.add(temp);
            count--;

        }
        // System.out.println(q.peek().avg);
        System.out.println(q);

        Node temp = q.poll();
        double avg = 0;
        int total = 0;

        while (temp != null) {
            avg += temp.avg;
            total += 1;
            temp = q.poll();
        }
        System.out.println(total);
        return (double) avg / total;
    }

    public static void main(String[] args) {
        //classes = [[1,2],[3,5],[2,2]], extraStudents = 2
        int[][] classes = {
                {1, 2}, {3, 5}, {2, 2}
        };
        int extra = 2;
        System.out.println(new Solution().maxAverageRatio(classes, extra));
    }
}