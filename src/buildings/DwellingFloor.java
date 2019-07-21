package buildings;

public class DwellingFloor {

    private Flat[] arrayOfFlat;

    public DwellingFloor(int numberOfFlatOnTheFloor){
        if (numberOfFlatOnTheFloor <= 0)
            throw new SpaceIndexOutOfBoundsException();
        arrayOfFlat = new Flat[numberOfFlatOnTheFloor];
        for (int i = 0; i < numberOfFlatOnTheFloor; i++){
            arrayOfFlat[i] = new Flat();
        }
    }

    public DwellingFloor(Flat[] arrayOfFlatOnTheFloor){
        arrayOfFlat = arrayOfFlatOnTheFloor;
    }

    public int getTheNumberOfFlatOnTheFloor(){
        return arrayOfFlat.length;
    }

    public double getTheTotalAreaOfTheFloorFlat(){
        double totalArea = 0;
        for (Flat flat:arrayOfFlat){
            totalArea += flat.getAreaOfFlat();
        }
        return totalArea;
    }

    public int getTheTotalNubmerOfFloorRooms(){
        int totalNumberOfRooms = 0;
        for(Flat flat:arrayOfFlat){
            totalNumberOfRooms += flat.getNumberOfRooms();
        }
        return totalNumberOfRooms;
    }

    public Flat[] getArrayOfFlat() {
        return arrayOfFlat;
    }

    public Flat getFlatByNumber(int flatNumber){
        if (arrayOfFlat[flatNumber] == null)
            throw new SpaceIndexOutOfBoundsException();
        return arrayOfFlat[flatNumber];
    }

    public void replaceTheFlat (int flatNumber, Flat flat){
        if (arrayOfFlat[flatNumber] == null)
            throw new SpaceIndexOutOfBoundsException();
        arrayOfFlat[flatNumber] = flat;
    }

    public void addNewFlat(int flatNumberToBeAdded, Flat flat){
        if (flatNumberToBeAdded < 0 || flatNumberToBeAdded > getTheNumberOfFlatOnTheFloor())
            throw new SpaceIndexOutOfBoundsException();
        Flat[] newArray = new Flat[arrayOfFlat.length + 1];
        System.arraycopy(arrayOfFlat, 0, newArray, 0, flatNumberToBeAdded);
        newArray[flatNumberToBeAdded] = flat;
        System.arraycopy(arrayOfFlat, flatNumberToBeAdded, newArray, flatNumberToBeAdded + 1, arrayOfFlat.length - flatNumberToBeAdded);
        arrayOfFlat = newArray;
    }

    public void removeFlat(int flatNumberToBeRemoved){
        if (flatNumberToBeRemoved < 0 || flatNumberToBeRemoved > getTheNumberOfFlatOnTheFloor() - 1)
            throw new SpaceIndexOutOfBoundsException();
        Flat[] newArray = new Flat[arrayOfFlat.length - 1];
        System.arraycopy(arrayOfFlat, 0, newArray, 0, flatNumberToBeRemoved);
        System.arraycopy(arrayOfFlat, flatNumberToBeRemoved + 1, newArray, flatNumberToBeRemoved, arrayOfFlat.length - flatNumberToBeRemoved - 1);
        arrayOfFlat = newArray;
    }

    public Flat getBestSpace(){
        Flat bestSpaceFlat = arrayOfFlat[0];
        for (Flat flat:arrayOfFlat){
            if (flat.getAreaOfFlat() > bestSpaceFlat.getAreaOfFlat()){
                bestSpaceFlat = flat;
            }
        }
        return bestSpaceFlat;
    }
}
