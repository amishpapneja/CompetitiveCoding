package mocks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapChanges {
    public static void main(String[] args) {
        Set<Employee> set = new HashSet<>();
        set.add(new Employee(1, "Amish"));
        set.add(new Employee(1, "Amish")); //equals

        System.out.println(set);
    }

}
class Employee{
    int id;
    String name;

    Employee(int id, String name){
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //equals -> Collision?
    @Override
    public boolean equals(Object o2){
        System.out.println("OUR OWN EQUALS");
//        if
//        Employee o1 = this;
        // o1
        return false;

    }
    //hashCOde -> everyTime
    @Override
    public int hashCode(){
        return 1;
    }


}
