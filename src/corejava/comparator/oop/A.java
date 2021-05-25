package corejava.comparator.oop;

import java.util.ArrayList;

public class A {
    ArrayList<Integer> list = new ArrayList<>();;
    int size;
    boolean status;


    public void addInt(int i){
//        list =
        this.list.add(i);
    }
}
class B extends A{
    public B (){
        size= 2;
        status = true;

    }

}
class C extends  A {
    public  C(){
        size = 3;
        status = false;
    }

}
class Main{
    public static void main(String[] args) {
        A b = new B();
        A c = new C();
        b.addInt(1);
        c.addInt(2);
        System.out.println(b.list);
        System.out.println(c.list);


    }
}