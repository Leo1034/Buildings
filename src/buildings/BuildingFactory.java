package buildings;

public interface BuildingFactory {
    public Space createSpace(double area);
    public Space createSpace(int roomsCount, double area);
    public Floor createFloor(int spaceCount);
    public Floor createFloor(Space[] spaces);
    public Building createBuilding(int floorsCount, int[] spacesCounts);
    public Building createBuilding(Floor[] floors);
}
