package buildings;

public class OfficeFloor {

    private static class Node{
        Office value;
        Node next = this;
    }

    private Node head = new Node();

    private Node getNode(int id){
        if (id < 0)
            throw new SpaceIndexOutOfBoundsException();
        Node n = head;
        for (int i = -1; i < id; i++){
            if (n.next.value == null)
                throw new SpaceIndexOutOfBoundsException();
            n = n.next;
        }
        return n;
    }

    private Node addNode(int id){
        if (id < 0 || id > getNumberOfOffice())
            throw new SpaceIndexOutOfBoundsException();
        Node n = head;
        for (int i = -1; i < id; i++){
            n = n.next;
        }
        Node node = new Node();
        node.next = n.next;
        n.next = node;
        return node;
    }

    private void removeNode(int id){
        if (id < 0 || id > getNumberOfOffice() - 1)
            throw new SpaceIndexOutOfBoundsException();
        Node n = head;
        for (int i = -1; i < id; i++){
            n = n.next;
        }
        n.next = n.next.next;
    }

    public OfficeFloor(int number){
        if (number <= 0)
            throw new FloorIndexOutOfBoundsException();
        for (int i = 0; i < number; i++){
            addNode(i).value = new Office();
        }
    }

    public OfficeFloor(Office[] office){
        if (office == null)
            throw new FloorIndexOutOfBoundsException();
        int length = office.length;
        for (int i = 0; i < length; i++){
            addNode(i).value = office[i];
        }
    }

    public int getNumberOfOffice(){
        int count = 0;
        Node n = head;
        while (n.next.value != null){
            n = n.next;
            count++;
        }
        return count;
    }

    public double getTotalAreaOnFloor(){
        double area = 0;
        Node n = head;
        while (n.next.value != null){
            n = n.next;
            area += n.value.getAreaOfOffice();
        }
        return area;
    }

    public int getTotalNumberOfRooms(){
        int rooms = 0;
        Node n = head;
        while (n.next.value != null){
            n = n.next;
            rooms += n.value.getNumberOfRooms();
        }
        return rooms;
    }

    public Office[] getArrayOfOffice(){
        Office[] offices = new Office[getNumberOfOffice()];
        Node n = head;
       for (int i = 0; i < getNumberOfOffice(); i++){
           n = n.next;
           offices[i] = n.value;
       }
       return offices;
    }

    public Office getOfficeByNumber(int number){
        if (number < 0 || number > getNumberOfOffice() - 1)
            throw new SpaceIndexOutOfBoundsException();
        return getNode(number).value;
    }

    public void changeOffice(int number, Office office){
        if (number < 0 || number > getNumberOfOffice() - 1)

        getNode(number).value = office;
    }

    public void addOffice(int number){
        if (number < 0 || number > getNumberOfOffice())
            throw new SpaceIndexOutOfBoundsException();
        addNode(number).value = new Office();
    }

    public void removeOffice(int number){
        if (number < 0 || number > getNumberOfOffice() - 1)
            throw new SpaceIndexOutOfBoundsException();
        removeNode(number);
    }

    public Office getBestSpace(){
        Office bestSpaceOffice = head.next.value;
        Node n = head.next;
        for (int i = 0; i < getNumberOfOffice() - 1; i++){
            n = n.next;
            if (n.value.getAreaOfOffice() > bestSpaceOffice.getAreaOfOffice()){
                bestSpaceOffice = n.value;
            }
        }

        return bestSpaceOffice;
    }
}
