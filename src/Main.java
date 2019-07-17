import buildings.*;
public class Main {
    public static void main(String[] args){
//        int[] arrayNumberOfFloor = {1,2,3,4,5,6,7,8,9,10};
//        Dwelling dwelling = new Dwelling(10, arrayNumberOfFloor);
//        Flat flat = new Flat(1000,121212);
//        dwelling.addFlatInTheDwelling(3, flat);
//        Flat[] array = dwelling.getAnArraySortedByDescendingArea();
//        int i = 0;
//        System.out.println(dwelling.getTotalNumberOfFlatInTheDwelling());
//        Office[] office = new Office[3];
//        for (int i = 0; i < 3; i++){
//            office[i] = new Office();
//        }
//        OfficeFloor officeFloor = new OfficeFloor(6);
      //  Office[] offices = officeFloor.getArrayOfOffice();
        Office office = new Office(12,1200);
//        officeFloor.changeOffice(2,office1);
      //  officeFloor.addOffice(2);
//        System.out.println(officeFloor.getTotalNumberOfRooms());
//        Office bestSpaceOffice = officeFloor.getBestSpace();
//        System.out.println(" ");
        OfficeFloor[] array = new OfficeFloor[5];
        for (int i = 0; i < 5; i++){
            array[i] = new OfficeFloor(5);
        }
        OfficeBuilding officeBuilding = new OfficeBuilding(array);
    OfficeFloor officeFloor = new OfficeFloor(10);
    //officeBuilding.changeFloor(0,officeFloor);
    officeBuilding.addOffice(24,office);
    Office office1 = officeBuilding.getBestSpace();
    Office[] offices = officeBuilding.getArraySorted();
        System.out.println(officeBuilding.getNumberOfRoom());
    }
}
