package buildings;

import buildings.office.Office;
import buildings.office.OfficeBuilding;
import buildings.office.OfficeFloor;

import java.io.*;
import java.util.Scanner;

public abstract class Buildings {
    private static BuildingFactory buildingFactory = null;

    public static void setBuildingFactory(BuildingFactory factory) {
        buildingFactory = factory;
    }

    public static void outputSpace(Space space, DataOutputStream out) throws IOException {
        out.writeInt(space.getCountRooms());
        out.writeDouble(space.getArea());
    }

    public static void outputFloor(Floor floor, DataOutputStream out) throws IOException {
        out.writeInt(floor.getCountSpace());
        for (int i = 0; i < floor.getCountSpace(); i++) {
            outputSpace(floor.getSpace(i), out);
        }
    }

    public static void outputBuilding(Building building, OutputStream out) throws IOException {
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeInt(building.getCountFloor());
        for (int i = 0; i < building.getCountFloor(); i++) {
            outputFloor(building.getFloor(i), dos);
        }
    }

    public static Space inputSpace(DataInputStream in) throws IOException {
        int countRoom = in.readInt();
        double area = in.readDouble();
        return new Office(countRoom, area);
    }

    public static Floor inputFloor(DataInputStream in) throws IOException {
        int countSpace = in.readInt();
        Space[] space = new Space[countSpace];
        for (int i = 0; i < countSpace; i++) {
            space[i] = inputSpace(in);
        }
        return new OfficeFloor(space);
    }

    public static Building inputBuilding(InputStream in) throws IOException {
        DataInputStream din = new DataInputStream(in);
        int countFloor = din.readInt();
        Floor[] floors = new Floor[countFloor];
        for (int i = 0; i < countFloor; i++) {
            floors[i] = inputFloor(din);
        }
        return new OfficeBuilding(floors);
    }

    public static void writeSpace(Space space, PrintWriter out) throws IOException {
        out.print(space.getCountRooms());
        out.print(" ");
        out.println(space.getArea());
        out.print(" ");
    }

    public static void writeFloor(Floor floor, PrintWriter out) throws IOException {
        out.print(floor.getCountSpace());
        out.print(" ");
        for (int i = 0; i < floor.getCountSpace(); i++) {
            writeSpace(floor.getSpace(i), out);
        }
    }

    public static void writeBuilding(Building building, Writer out) throws IOException {
        PrintWriter printWriter = new PrintWriter(out);
        printWriter.print(building.getCountFloor());
        printWriter.print(" ");
        for (int i = 0; i < building.getCountFloor(); i++) {
            writeFloor(building.getFloor(i), printWriter);
        }
    }

    public static Space readSpace(Reader in) throws IOException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(in);
        streamTokenizer.nextToken();
        int countRoom = (int) streamTokenizer.nval;
        streamTokenizer.nextToken();
        double area = streamTokenizer.nval;
        return new Office(countRoom, area);
    }

    public static Floor readFloor(Reader in) throws IOException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(in);
        streamTokenizer.nextToken();
        int countSpace = (int) streamTokenizer.nval;
        Space[] space = new Space[countSpace];
        for (int i = 0; i < countSpace; i++) {
            space[i] = readSpace(in);
        }
        return new OfficeFloor(space);
    }

    public static Building readBuilding(Reader in) throws IOException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(in);
        streamTokenizer.nextToken();
        int countFloor = (int) streamTokenizer.nval;
        Floor[] floor = new Floor[countFloor];
        for (int i = 0; i < countFloor; i++) {
            floor[i] = readFloor(in);
        }
        return new OfficeBuilding(floor);
    }

    public static void serializeBuilding(Building building) throws IOException {
        FileOutputStream fos = new FileOutputStream("Building");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(building);
        oos.flush();
        oos.close();
    }

    public static Building deserializeBuilding() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Building");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Building building = (Building) ois.readObject();
        return building;
    }

    public static void writeSpaceFormat(Space space, PrintWriter out) {
        out.format("%d %f ", space.getCountRooms(), space.getArea());
    }

    public static void writeFloorFormat(Floor floor, PrintWriter out) {
        out.format("%d ", floor.getCountSpace());
        for (int i = 0; i < floor.getCountSpace(); i++) {
            writeSpaceFormat(floor.getSpace(i), out);
        }
    }

    public static void writeBuildingFormat(Building building, Writer out) {
        PrintWriter printWriter = new PrintWriter(out);
        printWriter.format("%d ", building.getCountFloor());
        for (int i = 0; i < building.getCountFloor(); i++) {
            writeFloorFormat(building.getFloor(i), printWriter);
        }
    }

    public static Space readSpaceFormat(Scanner in) throws IOException {
        int count = in.nextInt();
        double area = in.nextDouble();
        return new Office(count, area);
    }

    public static Floor readFloorFormat(Scanner in) throws IOException {
        int count = in.nextInt();
        Space[] spaces = new Space[count];
        for (int i = 0; i < count; i++) {
            spaces[i] = readSpaceFormat(in);
        }
        return new OfficeFloor(spaces);
    }

    public static Building readBuildingFormat(Scanner in) throws IOException {
        int count = in.nextInt();
        OfficeFloor[] officeFloors = new OfficeFloor[count];
        for (int i = 0; i < count; i++){
            officeFloors[i] = (OfficeFloor) readFloorFormat(in);
        }
        return new OfficeBuilding(officeFloors);
    }

    public static <T extends Comparable<T>> void sortFloor(T[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    T temp;
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static Space createSpace(double area) {
        return buildingFactory.createSpace(area);
    }

    public static Space createSpace(int roomsCount, double area) {
        return buildingFactory.createSpace(roomsCount, area);
    }

    public static Floor createFloor(int spacesCount) {
        return buildingFactory.createFloor(spacesCount);
    }

    public static Floor createFloor(Space[] spaces) {
        return buildingFactory.createFloor(spaces);
    }

    public static Building createBuilding(int floorsCount, int[] spacesCounts) {
        return buildingFactory.createBuilding(floorsCount, spacesCounts);
    }

    public static Building createBuilding(Floor[] floors) {
        return buildingFactory.createBuilding(floors);
    }

    public static Floor synchronizedFloor(Floor floor) {
        return new SynchronizedFloor(floor);
    }

}
