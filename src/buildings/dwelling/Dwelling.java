package buildings.dwelling;

import buildings.*;

import java.io.Serializable;
import java.util.Iterator;

public class Dwelling implements Building, Serializable {

   private Floor[] arrayOfDwellingFloor;

    public Dwelling(int countFloor, int... arraySpace) {
        if (arraySpace.length != countFloor)
            throw new FloorIndexOutOfBoundsException();
        arrayOfDwellingFloor = new DwellingFloor[countFloor];
        for (int i = 0; i < countFloor; i++) {
            arrayOfDwellingFloor[i] = new DwellingFloor(arraySpace[i]);
        }
    }

    public Dwelling(Floor ... arrayOfDwellingFloor){
       if (arrayOfDwellingFloor == null)
           throw new FloorIndexOutOfBoundsException();
       this.arrayOfDwellingFloor = arrayOfDwellingFloor;
    }

    public int getCountFloor(){
        return arrayOfDwellingFloor.length;
    }

    public int getCountSpace(){
        int countSpace = 0;
        for (Floor dwellingFloor:arrayOfDwellingFloor){
            countSpace += dwellingFloor.getCountSpace();
        }
        return countSpace;
    }

    public double getTotalArea(){
        double totalArea = 0;
        for (Floor dwellingFloor:arrayOfDwellingFloor){
            totalArea += dwellingFloor.getTotalArea();
        }
        return totalArea;
    }

    public int getCountRooms(){
        int countRooms = 0;
        for (Floor dwellingFloor:arrayOfDwellingFloor){
            countRooms += dwellingFloor.getCountRooms();
        }
        return countRooms;
    }

    public Floor[] getArrayFloor(){
        return arrayOfDwellingFloor;
    }

    public Floor getFloor(int id){
       if (id < 0 || id > arrayOfDwellingFloor.length - 1)
           throw new FloorIndexOutOfBoundsException();
        return arrayOfDwellingFloor[id];
    }

    public void changeFloor(int id, Floor dwellingFloor){
       if (id < 0 || id > getCountFloor() - 1)
           throw new FloorIndexOutOfBoundsException();
        arrayOfDwellingFloor[id] = dwellingFloor;
    }

    public Space getSpace(int id){
       if (id < 0 || id > getCountSpace() - 1)
           throw new SpaceIndexOutOfBoundsException();
       Space requiredFlat = null;
       int number = 0;
       for(Floor dwellingFloor:arrayOfDwellingFloor){
           for (Space flat:dwellingFloor.getArraySpace()){
               if (number == id){
                   requiredFlat = flat;
               }
               number++;
           }
       }
       return requiredFlat;
    }

    public void changeSpace(int id, Space flat){
       if (id < 0 || id > getCountSpace() - 1)
           throw new SpaceIndexOutOfBoundsException();
        int number = 0;
        for (Floor dwellingFloor:arrayOfDwellingFloor){
            int length = dwellingFloor.getArraySpace().length;
            for (int i = 0; i < length; i++){
                if (number == id){
                    dwellingFloor.changeSpace(i, flat);
                }
                number++;
            }
        }
    }

    public void addSpace(int id, Space flat){
       if (id < 0 || id > getCountSpace())
           throw new SpaceIndexOutOfBoundsException();
        int flatNumberInDwelling = 0;
        for(Floor dwellingFloor:arrayOfDwellingFloor){
            int flatNumberInTheFloor = 0;
            for (Space flat1:dwellingFloor.getArraySpace()){
                if (id == flatNumberInDwelling){
                    dwellingFloor.addSpace(flatNumberInTheFloor,flat);
                }
            flatNumberInTheFloor++;
                flatNumberInDwelling++;
            }

        }
    }

    public void removeSpace(int id){
       if (id < 0 || id > getCountSpace() -1)
           throw new SpaceIndexOutOfBoundsException();
        int flatNumberInTheDwelling = 0;
        for (Floor dwellingFloor:arrayOfDwellingFloor){
            int flatNumberInTheFloor = 0;
            for (Space flat:dwellingFloor.getArraySpace()){
                if (id == flatNumberInTheDwelling){
                    dwellingFloor.removeSpace(flatNumberInTheFloor);
                }
                flatNumberInTheFloor++;
                flatNumberInTheDwelling++;
            }
        }
    }

    public Space getBestSpace(){
        Space bestSpaceFlat = new Flat();
        for (Floor dwellingFloor:arrayOfDwellingFloor){
            if (dwellingFloor.getBestSpace().getArea() > bestSpaceFlat.getArea()){
                bestSpaceFlat = dwellingFloor.getBestSpace();
            }
        }
        return bestSpaceFlat;
    }

    public Space[] getArraySorted(){
       int z = 0;
       int numberOfFlat = getCountSpace();
       Space[] arrayFlat = new Flat[numberOfFlat];
       for (Floor dwellingFloor:arrayOfDwellingFloor){
           for (Space flat:dwellingFloor.getArraySpace()){
               arrayFlat[z] = flat;
               z++;
           }
       }
       for (int i = numberOfFlat - 1; i > 0; i--){
           for (int j = 0; j < i; j++){
               if (arrayFlat[j].getArea() < arrayFlat[j + 1].getArea()){
                   Space temp = arrayFlat[j];
                   arrayFlat[j] = arrayFlat[j + 1];
                   arrayFlat[j + 1] = temp;
               }
           }
       }
       return arrayFlat;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer("Dwelling (" + getCountFloor() + ", ");
       for (int i = 0; i < getCountFloor(); i++){
           sb.append(getFloor(i).toString());
           if (i != getCountFloor() - 1)
               sb.append(", ");
           else sb.append(")");
       }
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Dwelling))
            return false;
        Dwelling obj = (Dwelling) object;
        if (getCountFloor() != obj.getCountFloor())
            return false;
        for (int i = 0; i < getCountFloor(); i++) {
            if (!(getFloor(i).equals(obj.getFloor(i)))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = getCountFloor();
        for (int i = 0; i < getCountFloor(); i++) {
            hash ^= getFloor(i).hashCode();
        }
        return hash;
    }

    @Override
    public Object clone(){
        DwellingFloor[] buffer = new DwellingFloor[getCountFloor()];
        for (int i = 0; i < getCountFloor(); i++){
            buffer[i] = (DwellingFloor) getFloor(i).clone();
        }
        return buffer;
    }

    class DwellingIterator implements Iterator<Floor>{
        int pos;

        public DwellingIterator(int pos){
            this.pos = pos;
        }

        public DwellingIterator(){
           this(0);
        }

        @Override
        public boolean hasNext() {
            return pos < getCountFloor();
        }

        @Override
        public Floor next() {
            return getFloor(pos++);
        }
    }

    @Override
    public Iterator<Floor> iterator() {
        return new DwellingIterator();
    }

}
