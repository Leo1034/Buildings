import buildings.*;
public class Main {
    public static void main(String[] args) {
      int[] count = {1,1,1,1,1};
      OfficeBuilding officeBuilding = new OfficeBuilding(5,count);
      Office office = officeBuilding.getOfficeByNumber(5);
        System.out.println("f");
    }
}
