package buildings;

import java.util.Iterator;

public class SynchronizedFloor implements Floor {
private Floor floor;

    SynchronizedFloor(Floor floor) {
        this.floor = floor;
    }

    @Override
    public synchronized int getCountSpace() {
        return floor.getCountSpace();
    }

    @Override
    public synchronized double getTotalArea() {
        return floor.getTotalArea();
    }

    @Override
    public synchronized int getCountRooms() {
        return floor.getCountRooms();
    }

    @Override
    public synchronized Space[] getArraySpace() {
        return floor.getArraySpace();
    }

    @Override
    public synchronized Space getSpace(int id) {
        return floor.getSpace(id);
    }

    @Override
    public synchronized void changeSpace(int id, Space office) {
        floor.changeSpace(id, office);
    }

    @Override
    public synchronized void addSpace(int id, Space office) {
        floor.addSpace(id, office);
    }

    @Override
    public synchronized void removeSpace(int id) {
        floor.removeSpace(id);
    }

    @Override
    public synchronized Space getBestSpace() {
        return floor.getBestSpace();
    }

    @Override
    public synchronized int compareTo(Floor second) {
        return floor.compareTo(second);
    }

    @Override
    public synchronized Iterator<Space> iterator() {
        return floor.iterator();
    }

    @Override
    public synchronized Object clone() {
        return floor.clone();
    }

    @Override
    public synchronized String toString() {
        return floor.toString();
    }

}
