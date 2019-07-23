package buildings;

public class PlacementExchanger {

    public static boolean exchangeSpaceCheck(Space space1, Space space2){
        if (space1.getArea() == space2.getArea() && space1.getCountRooms() == space2.getCountRooms()){
            return true;}
        else {
            return false;
        }
    }

    public static boolean exchangeFloorCheck(Floor floor1, Floor floor2){
        if (floor1.getTotalArea() == floor2.getTotalArea() && floor1.getCountSpace() == floor2.getCountSpace()){
            return true;
        }
        return false;
    }

    public static void exchangeFloorRooms(Floor floor1, int index1, Floor floor2, int index2) throws InexchangeableSpacesException{
        if (!exchangeSpaceCheck(floor1.getSpace(index1), floor2.getSpace(index2))){
            throw new  InexchangeableSpacesException();
        }
        Space buf = floor1.getSpace(index1);
        floor1.changeSpace(index1, floor2.getSpace(index2));
        floor2.changeSpace(index2, buf);
    }

    public static void exchangeBuildingFloor(Building building1, int index1, Building building2, int index2) throws InexchangeableFloorsException{
        if (!exchangeFloorCheck(building1.getFloor(index1), building2.getFloor(index2))){
            throw new InexchangeableFloorsException();
        }
        Floor buf = building1.getFloor(index1);
        building1.changeFloor(index1, building2.getFloor(index2));
        building2.changeFloor(index2, buf);
    }
}
