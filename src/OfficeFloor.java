public class OfficeFloor {

    private static class Node{
        Office value;
        Node next = this;
    }

    private Node head = new Node();

    private Node getNode(int id){
        Node n = head;
        for (int i = -1; i < id; i++){
            n = n.next;
        }
        return n;
    }

    private Node addNode(int id){
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
        Node n = head;
        for (int i = -1; i < id; i++){
            n = n.next;
        }
        n.next = n.next.next;
    }

    public OfficeFloor(int number){
        for (int i = 0; i < number; i++){
            addNode(i).value = new Office();
        }
    }

    public OfficeFloor(Office[] office){
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

    public Office getOfiiceByNumber(int number){
        return getNode(number).value;
    }

    public void changeOffice(int number, Office office){
        getNode(number).value = office;
    }

    public void addOffice(int number){
        addNode(number).value = new Office();
    }

    public void removeOffice(int number){
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
