package buildings;

import java.io.Serializable;

public interface Space extends Serializable, Cloneable, Comparable<Space> {

    int getCountRooms();
    void changeCountRooms(int countRooms);
    double getArea();
    void changeArea(double Area);
    Object clone();
    public String toString();
    @Override
    public int compareTo(Space second);

}
