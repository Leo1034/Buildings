import buildings.*;
public class Main {
    public static void main(String[] args){
        int[] arrayNumberOfFloor = {1,2,3,4,5,6,7,8,9,10};
        Dwelling dwelling = new Dwelling(10, arrayNumberOfFloor);
        Flat flat = new Flat(1000,121212);
        dwelling.addFlatInTheDwelling(3, flat);
        Flat[] array = dwelling.getAnArraySortedByDescendingArea();
        int i = 0;
        System.out.println(dwelling.getTotalNumberOfFlatInTheDwelling());
    }
}
