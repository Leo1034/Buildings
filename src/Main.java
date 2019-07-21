import buildings.*;
public class Main {
    public static void main(String[] args) {
        int[] f = {1,2,3,4,5};
        Dwelling dwelling = new Dwelling(5, f);
        Space space = dwelling.getSpace(3);
        dwelling.getCountRooms();
        System.out.println("f");
    }
}
