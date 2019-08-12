import buildings.dwelling.Dwelling;
import buildings.dwelling.DwellingFloor;
import buildings.dwelling.Flat;
import buildings.office.Office;
import buildings.office.OfficeBuilding;
import buildings.office.OfficeFloor;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Flat flat = new Flat();
        Office office = new Office();
        DwellingFloor dwellingFloor = new DwellingFloor(5);
        OfficeFloor officeFloor = new OfficeFloor(5);
        int[] f = {1, 2, 3, 4, 5};
        Dwelling dwelling = new Dwelling(5, f);
        OfficeBuilding officeBuilding = new OfficeBuilding(5, f);

//        Dwelling dwelling = new Dwelling(5, f);
//        dwelling.changeSpace(0, new Flat(10, 10));
//
//        Building building = null;
//
//        try (FileWriter out = new FileWriter("2.txt")) {
//            Buildings.writeBuildingFormat(dwelling, out);
//        } catch (IOException e) {
//        }
//        try (Scanner in = new Scanner(new File("2.txt"))){
//            building = Buildings.readBuildingFormat(in);
//        }



//        Buildings.serializeBuilding(dwelling);
//        Building building = Buildings.deserializeBuilding();
////        Building building1 = null;

//        try (FileOutputStream out = new FileOutputStream("1")) {
//            Buildings.outputBuilding(dwelling, out);
//        } catch (IOException e) {
//        }
//        try (FileInputStream in = new FileInputStream("1")) {
//            building1 = Buildings.inputBuilding(in);
//        } catch (IOException e) {
//        }
//        System.out.println(flat.toString());
//        System.out.println(office.toString());
//        System.out.println(dwellingFloor.toString());
//        System.out.println(officeFloor.toString());
        System.out.println(dwelling.toString());
        System.out.println(officeBuilding.toString());
    }
}

