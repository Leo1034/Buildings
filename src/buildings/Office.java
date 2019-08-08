package buildings;

import java.io.Serializable;

public class Office implements Space, Serializable {

    private int DEFAULT_COUNT_ROOMS = 1;
    private double DEFAULT_AREA = 250;

    private int countRooms;
    private double area;

    public Office() {
        countRooms = DEFAULT_COUNT_ROOMS;
        area = DEFAULT_AREA;
    }

    public Office(double area) {
        if (area <= 0)
            throw new InvalidSpaceAreaException();
        countRooms = DEFAULT_COUNT_ROOMS;
        this.area = area;
    }

    public Office(int countRooms, double area) {
        if (countRooms <= 0)
            throw new InvalidRoomsCountException();
        if (area <= 0)
            throw new InvalidSpaceAreaException();
        this.countRooms = countRooms;
        this.area = area;
    }

    public void changeCountRooms(int countRooms) {
        if (countRooms <= 0)
            throw new InvalidRoomsCountException();
        this.countRooms = countRooms;
    }

    public void changeArea(double area) {
        if (area <= 0)
            throw new InvalidSpaceAreaException();
        this.area = area;
    }

    public int getCountRooms() {
        return countRooms;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Office (" + countRooms + ", " + area + ")";
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Office)) {
            return false;
        }
        Office obj = (Office) object;
        if (getArea() != obj.getArea())
            return false;
        if (getCountRooms() != obj.getCountRooms())
            return false;
        return true;
    }

    @Override
    public int hashCode(){
        int value1 = getCountRooms();
        long area = (long) getArea();
        int value2 = (int) (area >> 32);
        int value3 = (int)(area);
        return value1 ^ value2 ^ value3;
    }

    @Override
    public Object clone(){
        return new Office(countRooms, area);
    }
}

