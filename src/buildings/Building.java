package buildings;

public interface Building {

    int getCountFloor();
    int getCountSpace();
    double getTotalArea();
    int getCountRooms();
    Floor[] getArrayFloor();
    Floor getFloor(int id);
    void changeFloor(int id, Floor floor);
    Space getSpace(int id);
    void changeSpace(int id, Space space);
    void addSpace(int id, Space space);
    void  removeSpace(int id);
    Space getBestSpace();
    Space[] getArraySorted();


}
