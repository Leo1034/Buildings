package buildings.threads;

import buildings.Floor;

public class Cleaner extends Thread {
    private Floor floor;

    public Cleaner(Floor floor){
        this.floor = floor;
    }

    @Override
    public void run(){
        for (int i = 0; i < floor.getCountSpace(); i++){
            System.out.println("Cleaning space number " + i + " with total area " + floor.getSpace(i).getArea() + " square meters");
        }
    }
}
