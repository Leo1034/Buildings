package buildings;

import java.io.Serializable;

public class OfficeBuilding implements Building, Serializable {

    private static class Node{
        Floor value;
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
        if (id < 0 || id > getCountFloor())
            throw new FloorIndexOutOfBoundsException();
        Node n = head;
        for (int i = -1; i < id -1; i++){
            n = n.next;
        }
        Node node = new Node();
        node.next = n.next;
        n.next = node;
        return node;
}

    private void removeNode(int id){
        if (id < 0 || id > getCountFloor() - 1)
            throw new FloorIndexOutOfBoundsException();
        Node n = head;
        for (int i = -1; i < id; i++){
            n = n.next;
        }
        n.next = n.next.next;
    }

    public OfficeBuilding(int countFloor, int ... countOffices){
        if (countFloor <= 0 || countFloor > countOffices.length)
            throw new FloorIndexOutOfBoundsException();
        for (int i = 0; i < countFloor; i++){
            addNode(i).value = new OfficeFloor(countOffices[i]);
        }
    }

    public OfficeBuilding(Floor ... officeFloors){
        if (officeFloors == null)
            throw new FloorIndexOutOfBoundsException();
        for (int i = 0; i < officeFloors.length; i++){
            addNode(i).value = officeFloors[i];
        }
    }

    public int getCountFloor(){
        int count = 0;
        Node n = head.next;
        while (n.value != null){
            count++;
            n = n.next;
        }
        return count;
    }

    public int getCountSpace(){
        int count = 0;
        Node n = head.next;
        while (n.value != null){
            count += n.value.getCountSpace();
            n = n.next;
        }
        return count;
    }

    public double getTotalArea(){
        Node n = head.next;
        double area = 0;
        while (n.value != null){
            area += n.value.getTotalArea();
            n = n.next;
        }
        return area;
    }

    public int getCountRooms(){
        Node n = head.next;
        int count = 0;
        while (n.value != null){
            count += n.value.getCountRooms();
            n = n.next;
        }
        return count;
    }

    public Floor[] getArrayFloor(){
        Floor[] officeFloors = new OfficeFloor[getCountFloor()];
        Node n = head.next;
        int i = 0;
        while (n.value != null){
        officeFloors[i] = n.value;
        i++;
        n = n.next;
        }
        return officeFloors;
    }

    public Floor getFloor(int id){
        if (id < 0 || id > getCountFloor() - 1)
            throw new FloorIndexOutOfBoundsException();
        return getArrayFloor()[id];
    }

    public void changeFloor(int id, Floor officeFloor){
        if (id < 0 || id > getCountFloor() - 1)
            throw new FloorIndexOutOfBoundsException();
        Node n = head;
        for (int i = -1; i < id; i++){
            n = n.next;
        }
        n.value = officeFloor;
    }

    public Space getSpace(int id){
        if (id < 0 || id > getCountSpace() - 1)
            throw new SpaceIndexOutOfBoundsException();
        Space office = null;
        int count = 0;
        for (int i = 0; i < getArrayFloor().length; i++){
            for (int j = 0; j < getArrayFloor()[i].getCountSpace(); j++){
                if (id == count){
                    office = getArrayFloor()[i].getSpace(j);
                }
                count++;
            }
        }
        return office;
    }

    public void changeSpace(int id, Space office){
        if (id < 0 || id > getCountSpace() - 1)
            throw new SpaceIndexOutOfBoundsException();
        int count = 0;
        for (int i = 0; i < getArrayFloor().length; i++){
            int countOnFloor = 0;
            for (int j = 0; j < getArrayFloor()[i].getCountSpace(); j++){
                if (id == count){
                    getArrayFloor()[i].changeSpace(countOnFloor, office);
                }
                countOnFloor++;
                count++;
            }
        }
    }

    public void addSpace(int id, Space office){
        if (id < 0 || id > getCountSpace())
            throw new SpaceIndexOutOfBoundsException();
        int count = 0;
        for (int i = 0; i < getArrayFloor().length; i++){
            int countOnFloor = 0;
            for (int j = 0; j < getArrayFloor()[i].getCountSpace(); j++){
                if (id == count){
                    getArrayFloor()[i].addSpace(countOnFloor, office);
                }
                countOnFloor++;
                count++;
            }
        }
    }

    public void removeSpace(int id){
        if (id < 0 || id > getCountSpace() - 1)
            throw new SpaceIndexOutOfBoundsException();
        int count = 0;
        for (int i = 0; i < getArrayFloor().length; i++){
            int countOnFloor = 0;
            for (int j = 0; j < getArrayFloor()[i].getCountSpace(); j++){
                if (id == count){
                    getArrayFloor()[i].removeSpace(countOnFloor - 1);
                }
                countOnFloor++;
                count++;
            }
        }
    }

    public Space getBestSpace(){
        Space office = new Office(0);
       Node n = head.next;
       while (n.value != null){
           if (office.getArea() < n.value.getBestSpace().getArea()){
               office = n.value.getBestSpace();
           }
           n = n.next;
       }
        return office;
    }

    public Space[] getArraySorted(){
        Space[] arraySorted = new Office[getCountSpace()];
        int count = 0;
        for (int i = 0; i < getCountFloor(); i++){
            for (int j = 0; j < getArrayFloor()[i].getCountSpace(); j++){
                arraySorted[count] = getArrayFloor()[i].getSpace(j);
                count++;
            }
        }
        Space office = null;
        for (int i = 0; i < arraySorted.length; i++){
            for (int j = i + 1; j < arraySorted.length; j++){
                if (arraySorted[j].getArea() > arraySorted[i].getArea()){
                    office = arraySorted[i];
                    arraySorted[i] = arraySorted[j];
                    arraySorted[j] = office;
                }
            }
        }
        return arraySorted;
    }

    @Override
    public String toString(){
        String s = "OfficeBuilding (" + getCountFloor() + ", ";
        for (int i = 0; i < getCountFloor(); i++){
            s += getFloor(i).toString();
            if (i != getCountFloor() - 1)
                s += ", ";
            else s += ")";
        }
        return s;
    }
}
