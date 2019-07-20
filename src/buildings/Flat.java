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
       if (areaOfFlat <= 0)
           throw new InvalidSpaceAreaException();
       numberOfRooms = DEFAULT_NUMBER_OF_ROOMS;
       this.areaOfFlat = areaOfFlat;
   }

    public Flat(int numberOfRooms, int areaOfFlat){
       if (numberOfRooms <= 0)
           throw new InvalidRoomsCountException();
       if (areaOfFlat <= 0)
           throw new InvalidSpaceAreaException();
       this.numberOfRooms = numberOfRooms;
       this.areaOfFlat = areaOfFlat;
   }

   public void changeNumberOfRooms(int numberOfRooms){
       if (numberOfRooms <= 0)
           throw new InvalidRoomsCountException();
       this.numberOfRooms = numberOfRooms;
   }

   public void changeAreaOfFlat(int areaOfFlat){
       if (areaOfFlat <= 0)
           throw new InvalidSpaceAreaException();
       this.areaOfFlat = areaOfFlat;
   }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public double getAreaOfFlat() {
        return areaOfFlat;
    }
}
