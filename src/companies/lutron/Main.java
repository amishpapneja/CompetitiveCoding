package companies.lutron;

public class Main {
    public static void main(String[] args) {
        // design tool, lighitn system
        // draw the rooms of the
        // rectablge
        // user draws
        // backend only
        // rectangle -> lenght , breadth (two int variables, four two dimentional points)
        // rectangle -> (position ,length, breadth, area)
    }

}
class Rectangle{
    private int length;
    private int breadth;
//    private int area;
    int coordinate1;
    int coordinate2;
    Rectangle previous;

    //counstructor
    public Rectangle(int length, int breadth, int c1, int c2){
        // preserve old variable states.
        this.length = length;
        this.previous = this;
        // this returns the same reference
        // m
//        this.area = calculateArea();
        //....

    }
    //getters and setter

    public int getLength() {
        return length;
    }
    public int getArea(){
        return this.length * this.breadth;
    }
    public void setBreadth(int breadth){
        //previous.setBreadth(this.breadth);
        this.breadth = breadth;
    }

    public void setLength(int length){
//        previous.setLength(this.length);
        this.length = length;
    }
    //
}
