package buildings;

public class Flat {

   private int DEFAULT_NUMBER_OF_ROOMS = 2;
   private int DEFAULT_AREA_OF_FLAT = 50;

   private int numberOfRooms;
   private double areaOfFlat;

   public Flat(){
       numberOfRooms = DEFAULT_NUMBER_OF_ROOMS;
       areaOfFlat = DEFAULT_AREA_OF_FLAT;
   }

   public Flat(int areaOfFlat){
       numberOfRooms = DEFAULT_NUMBER_OF_ROOMS;
       this.areaOfFlat = areaOfFlat;
   }

    public Flat(int numberOfRooms, int areaOfFlat){
       this.numberOfRooms = numberOfRooms;
       this.areaOfFlat = areaOfFlat;
   }

   public void changeNumberOfRooms(int numberOfRooms){
       this.numberOfRooms = numberOfRooms;
   }

   public void changeAreaOfFlat(int areaOfFlat){
       this.areaOfFlat = areaOfFlat;
   }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public double getAreaOfFlat() {
        return areaOfFlat;
    }
}
