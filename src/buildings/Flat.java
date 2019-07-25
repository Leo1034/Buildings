package buildings;

import java.io.Serializable;

public class Flat implements Space, Serializable {


   private int DEFAULT_COUNT_ROOMS = 2;
   private double DEFAULT_AREA = 50;

   private int countRooms;
   private double area;

   public Flat(){
       countRooms = DEFAULT_COUNT_ROOMS;
       area = DEFAULT_AREA;
   }

   public Flat(double area){
       if (area <= 0)
           throw new InvalidSpaceAreaException();
       countRooms = DEFAULT_COUNT_ROOMS;
       this.area = area;
   }

    public Flat(int countRooms, double area){
       if (countRooms <= 0)
           throw new InvalidRoomsCountException();
       if (area <= 0)
           throw new InvalidSpaceAreaException();
       this.countRooms = countRooms;
       this.area = area;
   }

   public void changeCountRooms(int countRooms){
       if (countRooms <= 0)
           throw new InvalidRoomsCountException();
       this.countRooms = countRooms;
   }

   public void changeArea(double area){
       if (area <= 0)
           throw new InvalidSpaceAreaException();
       this.area = area;
   }

    public int getCountRooms() {
        return countRooms;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Flat (" + countRooms + ", " + area + ")";
    }
}
