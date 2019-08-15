package buildings.threads;

import buildings.Floor;

public class SeqentalRepairer implements Runnable {
    private Floor floor;
    private Semaphore s;

    public SeqentalRepairer(Floor floor, Semaphore s){
        this.floor = floor;
        this.s = s;
    }

    @Override
    public void run() {
        for ( int i = 0; i < floor.getCountSpace(); i++){
            s.lock(true);
            System.out.println("Repairing space number " + i + " with total area " + floor.getSpace(i).getArea() + " square meters");
            s.unlock();
        }
    }
}
