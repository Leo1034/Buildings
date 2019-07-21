package buildings;

public interface Floor {

    int getCountSpace();
    double getTotalArea();
    int getCountRooms();
    Space[] getArraySpace();
    Space getSpace(int id);
    void changeSpace(int id, Space space);
    void addSpace(int id, Space space);
    void removeSpace(int id);
    Space getBestSpace();

}
