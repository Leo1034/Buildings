package buildings.dwelling;

import buildings.Building;
import buildings.BuildingFactory;
import buildings.Floor;
import buildings.Space;

public class DwellingFactory implements BuildingFactory {


    @Override
    public Space createSpace(double area) {
        return new Flat(area);
    }

    @Override
    public Space createSpace(int roomsCount, double area) {
        return new Flat(roomsCount,area);
    }

    @Override
    public Floor createFloor(int spaceCount) {
        return new DwellingFloor(spaceCount);
    }

    @Override
    public Floor createFloor(Space[] spaces) {
        return new DwellingFloor(spaces);
    }

    @Override
    public Building createBuilding(int floorsCount, int[] spacesCounts) {
        return new Dwelling( floorsCount, spacesCounts);
    }

    @Override
    public Building createBuilding(Floor[] floors) {
        return new Dwelling(floors);
    }
}
