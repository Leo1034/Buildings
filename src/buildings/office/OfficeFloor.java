package buildings.office;

import buildings.Floor;
import buildings.FloorIndexOutOfBoundsException;
import buildings.Space;
import buildings.SpaceIndexOutOfBoundsException;

import java.io.Serializable;
import java.util.Iterator;

public class OfficeFloor implements Floor {

    private static class Node implements Serializable{
        Space value;
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
        if (id < 0 || id > getCountSpace())
            throw new SpaceIndexOutOfBoundsException();
        Node n = head;
        for (int i = -1; i < id - 1; i++){
            n = n.next;
        }
        Node node = new Node();
        node.next = n.next;
        n.next = node;
        return node;
    }

    private void removeNode(int id){
        if (id < 0 || id > getCountSpace() - 1)
            throw new SpaceIndexOutOfBoundsException();
        Node n = head;
        for (int i = -1; i < id; i++){
            n = n.next;
        }
        n.next = n.next.next;
    }

    public OfficeFloor(int id){
        if (id <= 0)
            throw new FloorIndexOutOfBoundsException();
        for (int i = 0; i < id; i++){
            addNode(i).value = new Office();
        }
    }

    public OfficeFloor(Space ... office){
        if (office == null)
            throw new FloorIndexOutOfBoundsException();
        int length = office.length;
        for (int i = 0; i < length; i++){
            addNode(i).value = office[i];
        }
    }

    public int getCountSpace(){
        int count = 0;
        Node n = head;
        while (n.next.value != null){
            n = n.next;
            count++;
        }
        return count;
    }

    public double getTotalArea(){
        double area = 0;
        Node n = head;
        while (n.next.value != null){
            n = n.next;
            area += n.value.getArea();
        }
        return area;
    }

    public int getCountRooms(){
        int rooms = 0;
        Node n = head;
        while (n.next.value != null){
            n = n.next;
            rooms += n.value.getCountRooms();
        }
        return rooms;
    }

    public Space[] getArraySpace(){
        Space[] offices = new Office[getCountSpace()];
        Node n = head;
       for (int i = 0; i < getCountSpace(); i++){
           n = n.next;
           offices[i] = n.value;
       }
       return offices;
    }

    public Space getSpace(int id){
        if (id < 0 || id > getCountSpace() - 1)
            throw new SpaceIndexOutOfBoundsException();
        return getNode(id).value;
    }

    public void changeSpace(int id, Space office){
        if (id < 0 || id > getCountSpace() - 1)
        getNode(id).value = office;
    }

    public void addSpace(int id, Space office){
        if (id < 0 || id > getCountSpace())
            throw new SpaceIndexOutOfBoundsException();
        addNode(id).value = office;
    }

    public void removeSpace(int id){
        if (id < 0 || id > getCountSpace() - 1)
            throw new SpaceIndexOutOfBoundsException();
        removeNode(id);
    }

    public Space getBestSpace(){
        Space bestSpaceOffice = head.next.value;
        Node n = head.next;
        for (int i = 0; i < getCountSpace() - 1; i++){
            n = n.next;
            if (n.value.getArea() > bestSpaceOffice.getArea()){
                bestSpaceOffice = n.value;
            }
        }
        return bestSpaceOffice;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer("OfficeFloor (" + getCountSpace() + ", ");
        for (int i = 0; i < getCountSpace(); i++){
            sb.append(getSpace(i).toString());
            if (i != getCountSpace() - 1)
                sb.append(", ");
            else sb.append(")");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object object){
        if (!(object instanceof OfficeFloor))
            return false;
        OfficeFloor obj = (OfficeFloor) object;

        if (getCountSpace() != obj.getCountSpace())
            return false;

        for (int i = 0; i < getCountSpace(); i ++){
            if (!(getSpace(i).equals(obj.getSpace(i)))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode(){
        int hash = getCountSpace();
        for (int i = 0; i < getCountSpace(); i++){
            hash ^= getSpace(i).hashCode();
        }
        return hash;
    }

    @Override
    public Object clone(){
        Office[] buffer = new Office[getCountSpace()];
        for (int i = 0; i < getCountSpace(); i++){
            buffer[i] = (Office) getSpace(i).clone();
        }
        return buffer;
    }

    class OfficeFloorIterator implements Iterator<Space> {
        Node pos;

        public OfficeFloorIterator(Node pos){
            this.pos = pos;
        }

        public OfficeFloorIterator(){
            this(head);
        }

        @Override
        public boolean hasNext(){
            return pos.next.value != null;
        }

        @Override
        public Space next(){
            return pos.next.value;
        }
    }

    @Override
    public Iterator<Space> iterator() {
        return new OfficeFloorIterator();
    }

    @Override
    public int compareTo(Floor second){
        if (getCountSpace() < second.getCountSpace())
            return -1;
        if (getCountSpace() > second.getCountSpace())
            return 1;
        return 0;
    }
}
