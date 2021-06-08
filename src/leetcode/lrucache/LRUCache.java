package leetcode.lrucache;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Node{
    public int key; public int value; public int freq;
    public Node(int key, int value, int freq){
        this.key = key;
        this.value = value;
        this.freq = freq;
    }

}
class LRUCache {
    HashMap<Integer,Node> map;
    PriorityQueue<Node> q;
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        q = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
        map = new HashMap<>();

    }

    public int get(int key) {
        if(map.containsKey(key)){
            //return node and add freq
            map.get(key).freq = map.get(key).freq + 1 ;
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            //update
            map.get(key).value = value;
        }
        else{
            Node n = new Node(key, value, 0);

            if(q.size() < cap){
                map.put(key, n);
                q.add(n);
                //normal put
            }
            else{
                Node temp = q.poll();
                map.remove(temp.key);
                map.put(key, n);
                q.add(n);

                //poll and add with new node
            }
            // System.out.println(q.peek().key);
        }

    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */