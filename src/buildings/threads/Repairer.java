package buildings.threads;

import buildings.Floor;

public class Repairer extends Thread {
    private Floor floor;

    public Repairer(Floor floor) {
        this.floor = floor;
    }

    @Override
    public void run(){
        for (int i = 0; i < floor.getCountSpace(); i++){
            System.out.println("Repairing space number " + i + " with total area " + floor.getSpace(i).getArea() + " square meters");
        }
    }
}
