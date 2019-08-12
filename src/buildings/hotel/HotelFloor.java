package buildings.hotel;

import buildings.Space;
import buildings.dwelling.DwellingFloor;

public class HotelFloor extends DwellingFloor {

    private static int DEFAULT_COUNT_STAR = 1;
    private int countStar;

    public HotelFloor(int countSpace){
        super(countSpace);
        countStar = DEFAULT_COUNT_STAR;
    }

    public HotelFloor(Space... spaces){
        super(spaces);
        countStar = DEFAULT_COUNT_STAR;
    }

    public int getCountStar(){
        return countStar;
    }

    public void setCountStar(int countStar){
        this.countStar = countStar;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("HotelFloor" + countStar +", ");
        for (int i = 0; i < getCountSpace(); i++){
            sb.append(getSpace(i).toString());
            if (i != getCountSpace() - 1){
                sb.append(", ");
            }else sb.append(")");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof HotelFloor))
            return false;
        HotelFloor obj = (HotelFloor)object;
        if (obj.getCountSpace() != getCountSpace())
            return false;
        if (obj.countStar != countStar)
            return false;
        for (int i = 0; i < getCountSpace(); i++){
            if (!(getSpace(i).equals(obj.getSpace(i))))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        int value = getCountSpace() ^ getCountStar();
        for (int i = 0; i < getCountSpace(); i++){
            value ^= getSpace(i).hashCode();
        }
        return value;
    }
}
