package buildings;

public class Dwelling {

   private DwellingFloor[] arrayOfDwellingFloor;

   public Dwelling(int numberOfFloor, int[] arrayOfFlatOnFloors){
       if (arrayOfFlatOnFloors.length != numberOfFloor)
           throw new FloorIndexOutOfBoundsException();
       arrayOfDwellingFloor = new DwellingFloor[numberOfFloor];
         for (int i = 0; i < numberOfFloor; i++){
             arrayOfDwellingFloor[i] = new DwellingFloor(arrayOfFlatOnFloors[i]);
         }
    }

    public Dwelling(DwellingFloor[] arrayOfDwellingFloor){
       if (arrayOfDwellingFloor == null)
           throw new FloorIndexOutOfBoundsException();
       this.arrayOfDwellingFloor = arrayOfDwellingFloor;
    }

    public int getTheNumberOfFloors(){
        return arrayOfDwellingFloor.length;
    }

    public int getTotalNumberOfFlatInTheDwelling(){
        int totalNumberOfFlat = 0;
        for (DwellingFloor dwellingFloor:arrayOfDwellingFloor){
            totalNumberOfFlat += dwellingFloor.getTheNumberOfFlatOnTheFloor();
        }
        return totalNumberOfFlat;
    }

    public double getTotalAreaOfFlatInTheDwelling(){
        double totalArea = 0;
        for (DwellingFloor dwellingFloor:arrayOfDwellingFloor){
            totalArea += dwellingFloor.getTheTotalAreaOfTheFloorFlat();
        }
        return totalArea;
    }

    public int getTotalNubmerOfRoomsInTheDwelling(){
        int totalNumberOfRooms = 0;
        for (DwellingFloor dwellingFloor:arrayOfDwellingFloor){
            totalNumberOfRooms += dwellingFloor.getTheTotalNubmerOfFloorRooms();
        }
        return totalNumberOfRooms;
    }

    public DwellingFloor[] getArrayOfDwellingFloor(){
        return arrayOfDwellingFloor;
    }

    public DwellingFloor getFloor(int floorNumber){
       if (floorNumber < 0 || floorNumber > arrayOfDwellingFloor.length - 1)
           throw new FloorIndexOutOfBoundsException();
        return arrayOfDwellingFloor[floorNumber];
    }

    public void replaceTheFloor(int floorNumber, DwellingFloor dwellingFloor){
       if (floorNumber < 0 || floorNumber > getTheNumberOfFloors() - 1)
           throw new FloorIndexOutOfBoundsException();
        arrayOfDwellingFloor[floorNumber] = dwellingFloor;
    }

    public Flat getFlatByNumberInTheDwelling(int flatNumber){
       if (flatNumber < 0 || flatNumber > getTotalNumberOfFlatInTheDwelling() - 1)
           throw new SpaceIndexOutOfBoundsException();
       Flat requiredFlat = null;
       int number = 0;
       for(DwellingFloor dwellingFloor:arrayOfDwellingFloor){
           for (Flat flat:dwellingFloor.getArrayOfFlat()){
               if (number == flatNumber){
                   requiredFlat = flat;
               }
               number++;
           }
       }
       return requiredFlat;
    }

    public void replaceTheFlatInTheDwelling(int flatNumber, Flat flat){
       if (flatNumber < 0 || flatNumber > getTotalNumberOfFlatInTheDwelling() - 1)
           throw new SpaceIndexOutOfBoundsException();
        int number = 0;
        for (DwellingFloor dwellingFloor:arrayOfDwellingFloor){
            int lenght = dwellingFloor.getArrayOfFlat().length;
            for (int i = 0; i < lenght; i++){
                if (number == flatNumber){
                    dwellingFloor.replaceTheFlat(i, flat);
                }
                number++;
            }
        }
    }

    public void addFlatInTheDwelling(int flatNumber, Flat flat){
       if (flatNumber < 0 || flatNumber > getTotalNumberOfFlatInTheDwelling())
           throw new SpaceIndexOutOfBoundsException();
        int flatNumberInDwelling = 0;
        for(DwellingFloor dwellingFloor:arrayOfDwellingFloor){
            int flatNumberInTheFloor = 0;
            for (Flat flat1:dwellingFloor.getArrayOfFlat()){
                if (flatNumber == flatNumberInDwelling){
                    dwellingFloor.addNewFlat(flatNumberInTheFloor,flat);
                }
            flatNumberInTheFloor++;
                flatNumberInDwelling++;
            }

        }
    }

    public void removeFlatInTheDwelling(int flatNumber){
       if (flatNumber < 0 || flatNumber > getTotalNumberOfFlatInTheDwelling() -1)
           throw new SpaceIndexOutOfBoundsException();
        int flatNumberInTheDwelling = 0;
        for (DwellingFloor dwellingFloor:arrayOfDwellingFloor){
            int flatNumberInTheFloor = 0;
            for (Flat flat:dwellingFloor.getArrayOfFlat()){
                if (flatNumber == flatNumberInTheDwelling){
                    dwellingFloor.removeFlat(flatNumberInTheFloor);
                }
                flatNumberInTheFloor++;
                flatNumberInTheDwelling++;
            }

        }
    }

    public Flat getBestSpace(){
        Flat bestSpaceFlat = new Flat();
        for (DwellingFloor dwellingFloor:arrayOfDwellingFloor){
            if (dwellingFloor.getBestSpace().getAreaOfFlat() > bestSpaceFlat.getAreaOfFlat()){
                bestSpaceFlat = dwellingFloor.getBestSpace();
            }
        }
        return bestSpaceFlat;
    }

    public Flat[] getAnArraySortedByDescendingArea(){
       int z = 0;
       int numberOfFlat = getTotalNumberOfFlatInTheDwelling();
       Flat[] arrayFlat = new Flat[numberOfFlat];
       for (DwellingFloor dwellingFloor:arrayOfDwellingFloor){
           for (Flat flat:dwellingFloor.getArrayOfFlat()){
               arrayFlat[z] = flat;
               z++;
           }
       }
       for (int i = numberOfFlat - 1; i > 0; i--){
           for (int j = 0; j < i; j++){
               if (arrayFlat[j].getAreaOfFlat() < arrayFlat[j + 1].getAreaOfFlat()){
                   Flat temp = arrayFlat[j];
                   arrayFlat[j] = arrayFlat[j + 1];
                   arrayFlat[j + 1] = temp;
               }
           }
       }
       return arrayFlat;
    }
}
