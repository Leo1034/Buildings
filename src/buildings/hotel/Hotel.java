package buildings.hotel;

import buildings.Space;
import buildings.dwelling.Dwelling;
import buildings.dwelling.Flat;

public class Hotel extends Dwelling {

    public Hotel(int countFloor, int... arraySpace){
        super(countFloor, arraySpace);
    }

    public Hotel(HotelFloor ... arrayOfDwellingFloor){
        super(arrayOfDwellingFloor);
    }

    public int getCountStar(){
        int countStar = 0;
        for (int i = 0; i < getCountFloor(); i++){
           countStar = Math.max(countStar,((HotelFloor)getFloor(i)).getCountStar());
        }
        return countStar;
    }

    @Override
    public Space getBestSpace(){
        Space bestSpace = null;
        double result = 0;
        for (int i = 0; i < getCountFloor(); i++){
            double coeff = ((HotelFloor)getFloor(i)).getCountStar() * 0.25;
            if (bestSpace == null || getFloor(i).getBestSpace().getArea() * coeff > result){
                bestSpace = getFloor(i).getBestSpace();
                result = getFloor(i).getBestSpace().getArea() * coeff;
            }
        }
        return bestSpace;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("HotelBuilding (" + getCountStar() + ", ");
        for (int i = 0; i < getCountFloor(); i++){
            sb.append(getFloor(i).toString());
            if (i != getCountFloor() - 1){
                sb.append(", ");
            }else sb.append(")");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof Hotel))
            return false;
        Hotel obj = (Hotel) object;
        if (getCountFloor() != obj.getCountFloor())
            return false;
        for (int i = 0; i < getCountFloor(); i++){
            if (!(getFloor(i).equals(obj.getFloor(i))));
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        int value = getCountFloor();
        for (int i = 0; i < getCountFloor(); i++){
            value ^= getFloor(i).hashCode();
        }
        return value;
    }
}
