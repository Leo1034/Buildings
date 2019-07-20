package buildings;

import buildings.Office;

public class OfficeBuilding {

    private static class Node{
        OfficeFloor value;
        Node next = this;
    }

    private Node head = new Node();

    private Node getNode(int id){
        if (id < 0) throw new FloorIndexOutOfBoundsException();
        Node n = head;
        for ( int i = -1; i < id; i++){
            if (n.next.value == null)
                throw new FloorIndexOutOfBoundsException();
            n = n.next;
        }
        return n;
    }

    private Node addNode(int id){
        if (id < 0 || id > getTotalNumberOfFloor())
            throw new FloorIndexOutOfBoundsException();
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
        if (id < 0 || id > getTotalNumberOfFloor() - 1)
            throw new FloorIndexOutOfBoundsException();
        Node n = head;
        for (int i = -1; i < id; i++){
            n = n.next;
        }
        n.next = n.next.next;
    }

    public OfficeBuilding(int countFloor, int[] countOffices){
        if (countFloor <= 0 || countFloor > countOffices.length - 1)
            throw new FloorIndexOutOfBoundsException();
        for (int i = 0; i < countFloor; i++){
            addNode(i).value = new OfficeFloor(countOffices[i]);
        }
    }

    public OfficeBuilding(OfficeFloor[] officeFloors){
        if (officeFloors == null)
            throw new FloorIndexOutOfBoundsException();
        for (int i = 0; i < officeFloors.length; i++){
            addNode(i).value = officeFloors[i];
        }
    }

    public int getTotalNumberOfFloor(){
        int count = 0;
        Node n = head.next;
        while (n.value != null){
            count++;
            n = n.next;
        }
        return count;
    }

    public int getTotalNumberOfOffices(){
        int count = 0;
        Node n = head.next;
        while (n.value != null){
            count += n.value.getNumberOfOffice();
            n = n.next;
        }
        return count;
    }

    public double getTotalAreaOfBuilding(){
        Node n = head.next;
        double area = 0;
        while (n.value != null){
            area += n.value.getTotalAreaOnFloor();
            n = n.next;
        }
        return area;
    }

    public int getNumberOfRoom(){
        Node n = head.next;
        int count = 0;
        while (n.value != null){
            count += n.value.getTotalNumberOfRooms();
            n = n.next;
        }
        return count;
    }

    public OfficeFloor[] getArrayOfFloor(){
        OfficeFloor[] officeFloors = new OfficeFloor[getTotalNumberOfFloor()];
        Node n = head.next;
        int i = 0;
        while (n.value != null){
        officeFloors[i] = n.value;
        i++;
        n = n.next;
        }
        return officeFloors;
    }

    public OfficeFloor getFloorByNumber(int id){
        if (id < 0 || id > getTotalNumberOfFloor() - 1)
            throw new FloorIndexOutOfBoundsException();
        return getArrayOfFloor()[id];
    }

    public void changeFloor(int id, OfficeFloor officeFloor){
        if (id < 0 || id > getTotalNumberOfFloor() - 1)
            throw new FloorIndexOutOfBoundsException();
        Node n = head;
        for (int i = -1; i < id; i++){
            n = n.next;
        }
        n.value = officeFloor;
    }

    public Office getOfficeByNumber(int id){
        if (id < 0 || id > getTotalNumberOfOffices() - 1)
            throw new SpaceIndexOutOfBoundsException();
        Office office = null;
        int count = 0;
        for (int i = 0; i < getArrayOfFloor().length; i++){
            for (int j = 0; j < getArrayOfFloor()[i].getNumberOfOffice(); j++){
                if (id == count){
                    office = getArrayOfFloor()[i].getOfiiceByNumber(j);
                }
                count++;
            }
        }
        return office;
    }

    public void changeOffice(int id,Office office){
        if (id < 0 || id > getTotalNumberOfOffices() - 1)
            throw new SpaceIndexOutOfBoundsException();
        int count = 0;
        for (int i = 0; i < getArrayOfFloor().length; i++){
            int countOnFloor = 0;
            for (int j = 0; j < getArrayOfFloor()[i].getNumberOfOffice(); j++){
                if (id == count){
                    getArrayOfFloor()[i].changeOffice(countOnFloor, office);
                }
                countOnFloor++;
                count++;
            }
        }
    }

    public void addOffice(int id, Office office){
        if (id < 0 || id > getTotalNumberOfOffices())
            throw new SpaceIndexOutOfBoundsException();
        int count = 0;
        for (int i = 0; i < getArrayOfFloor().length; i++){
            int countOnFloor = 0;
            for (int j = 0; j < getArrayOfFloor()[i].getNumberOfOffice(); j++){
                if (id == count){
                    getArrayOfFloor()[i].addOffice(countOnFloor);
                    getArrayOfFloor()[i].changeOffice(countOnFloor, office);
                }
                countOnFloor++;
                count++;
            }
        }
    }

    public void removeOffice(int id){
        if (id < 0 || id > getTotalNumberOfOffices() - 1)
            throw new SpaceIndexOutOfBoundsException();
        int count = 0;
        for (int i = 0; i < getArrayOfFloor().length; i++){
            int countOnFloor = 0;
            for (int j = 0; j < getArrayOfFloor()[i].getNumberOfOffice(); j++){
                if (id == count){
                    getArrayOfFloor()[i].removeOffice(countOnFloor - 1);
                }
                countOnFloor++;
                count++;
            }
        }
    }

    public Office getBestSpace(){
        Office office = new Office(0);
       Node n = head.next;
       while (n.value != null){
           if (office.getAreaOfOffice() < n.value.getBestSpace().getAreaOfOffice()){
               office = n.value.getBestSpace();
           }
           n = n.next;
       }
        return office;
    }

    public Office[] getArraySorted(){
        Office[] arraySorted = new Office[getTotalNumberOfOffices()];
        int count = 0;
        for (int i = 0; i < getTotalNumberOfFloor(); i++){
            for (int j = 0; j < getArrayOfFloor()[i].getNumberOfOffice(); j++){
                arraySorted[count] = getArrayOfFloor()[i].getOfiiceByNumber(j);
                count++;
            }
        }
        Office office = null;
        for (int i = 0; i < arraySorted.length; i++){
            for (int j = i + 1; j < arraySorted.length; j++){
                if (arraySorted[j].getAreaOfOffice() > arraySorted[i].getAreaOfOffice()){
                    office = arraySorted[i];
                    arraySorted[i] = arraySorted[j];
                    arraySorted[j] = office;
                }
            }
        }
        return arraySorted;
    }


}
