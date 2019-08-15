package buildings;

import java.io.Serializable;
import java.util.Iterator;

public interface Floor extends Serializable, Cloneable, Iterable<Space>, Comparable<Floor> {

    int getCountSpace();
    double getTotalArea();
    int getCountRooms();
    Space[] getArraySpace();
    Space getSpace(int id);
    void changeSpace(int id, Space space);
    void addSpace(int id, Space space);
    void removeSpace(int id);
    Space getBestSpace();
    Object clone();
    @Override
    String toString();
    @Override
    Iterator<Space> iterator();
    @Override
    int compareTo(Floor second);

}
