package buildings;

import java.io.*;

public class Buildings {

    public static void outputSpace(Space space, DataOutputStream out) throws IOException {
        out.writeInt(space.getCountRooms());
        out.writeDouble(space.getArea());
    }

    public static void outputFloor(Floor floor, DataOutputStream out)throws IOException {
        out.writeInt(floor.getCountSpace());
        for (int i = 0; i < floor.getCountSpace(); i++){
            outputSpace(floor.getSpace(i), out);
        }
    }

    public static  void outputBuilding(Building building, OutputStream out) throws IOException {
        DataOutputStream dos = new DataOutputStream(out);
        dos.write(building.getCountFloor());
        for (int i = 0; i < building.getCountFloor(); i++){
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
        for (int i = 0; i < countSpace; i++){
            space[i] = inputSpace(in);
        }
        return new OfficeFloor(space);
    }
    public static Building inputBuilding (InputStream in) throws IOException {
        DataInputStream din = new DataInputStream(in);
        int countFloor = din.readInt();
        Floor[] floors = new Floor[countFloor];
        for (int i = 0; i < countFloor; i++){
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
        for (int i = 0; i < floor.getCountSpace(); i++){
            writeSpace(floor.getSpace(i) , out);
        }
    }

    public static void writeBuilding( Building building, Writer out) throws IOException {
        PrintWriter printWriter = new PrintWriter(out);
        printWriter.print(building.getCountFloor());
        printWriter.print(" ");
        for (int i = 0; i < building.getCountFloor(); i++){
            writeFloor(building.getFloor(i), printWriter);
        }
    }

    public static Space readSpace(Reader in) throws IOException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(in);
        streamTokenizer.nextToken();
        int countRoom = streamTokenizer.ttype;
        double area = streamTokenizer.nval;
        return new Office(countRoom, area);
    }

    public static Floor readFloor(Reader in) throws IOException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(in);
        streamTokenizer.nextToken();
        int countSpace = streamTokenizer.ttype;
        Space[] space = new Space[countSpace];
        for (int i = 0; i < countSpace; i++){
            space[i] = readSpace(in);
        }
        return new OfficeFloor(space);
    }

    public static Building readBuilding(Reader in) throws IOException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(in);
        streamTokenizer.nextToken();
        int countFloor = streamTokenizer.ttype;
        Floor[] floor = new Floor[countFloor];
        for ( int i = 0; i < countFloor; i++){
            floor[i] = readFloor(in);
        }
        return new OfficeBuilding(floor);
    }
}
