package buildings;

import java.io.Serializable;

public class DwellingFloor implements Floor, Serializable {

    private Space[] arraySpace;

    public DwellingFloor(int countSpace){
        if (countSpace <= 0)
            throw new SpaceIndexOutOfBoundsException();
        arraySpace = new Flat[countSpace];
        for (int i = 0; i < countSpace; i++){
            arraySpace[i] = new Flat();
        }
    }

    public DwellingFloor(Space ... arraySpace){
        this.arraySpace = arraySpace;
    }

    public int getCountSpace(){
        return arraySpace.length;
    }

    public double getTotalArea(){
        double totalArea = 0;
        for (Space flat: arraySpace){
            totalArea += flat.getArea();
        }
        return totalArea;
    }

    public int getCountRooms(){
        int totalCountRooms = 0;
        for(Space flat: arraySpace){
            totalCountRooms += flat.getCountRooms();
        }
        return totalCountRooms;
    }

    public Space[] getArraySpace() {
        return arraySpace;
    }

    public Space getSpace(int id){
        if (arraySpace[id] == null)
            throw new SpaceIndexOutOfBoundsException();
        return arraySpace[id];
    }

    public void changeSpace(int id, Space flat){
        if (arraySpace[id] == null)
            throw new SpaceIndexOutOfBoundsException();
        arraySpace[id] = flat;
    }

    public void addSpace(int id, Space flat){
        if (id < 0 || id > getCountSpace())
            throw new SpaceIndexOutOfBoundsException();
        Space[] newArray = new Flat[arraySpace.length + 1];
        System.arraycopy(arraySpace, 0, newArray, 0, id);
        newArray[id] = flat;
        System.arraycopy(arraySpace, id, newArray, id + 1, arraySpace.length - id);
        arraySpace = newArray;
    }

    public void removeSpace(int id){
        if (id < 0 || id > getCountSpace() - 1)
            throw new SpaceIndexOutOfBoundsException();
        Space[] newArray = new Flat[arraySpace.length - 1];
        System.arraycopy(arraySpace, 0, newArray, 0, id);
        System.arraycopy(arraySpace, id + 1, newArray, id, arraySpace.length - id - 1);
        arraySpace = newArray;
    }

    public Space getBestSpace(){
        Space bestSpace = arraySpace[0];
        for (Space flat: arraySpace){
            if (flat.getArea() > bestSpace.getArea()){
                bestSpace = flat;
            }
        }
        return bestSpace;
    }

    @Override
    public String toString(){
        String s = new String();
        s = "DwellingFloor (" + getCountSpace() + ", ";
        for (int i = 0; i < getCountSpace(); i++){
            s += getSpace(i).toString();
            if (i != getCountSpace() - 1)
                s += ", ";
            else s += ")";
        }
        return s;
    }
}
