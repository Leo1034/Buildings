package buildings.threads;

public class Semaphore {
    volatile boolean flag;

    public void lock(boolean state){
        while(flag == state)
            Thread.yield();
    }

    public void unlock(){
        flag = !flag;
    }
}
