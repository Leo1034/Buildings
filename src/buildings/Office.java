package buildings;

public class Office {

    private int DEFAULT_NUMBER_OF_ROOMS = 1;
    private double DEFAULT_AREA_OF_OFFICE = 250;

    private int numberOfRooms;
    private double areaOfOffice;

    public Office(){
        numberOfRooms = DEFAULT_NUMBER_OF_ROOMS;
        areaOfOffice = DEFAULT_AREA_OF_OFFICE;
    }

    public Office(double areaOfOffice){
        if (areaOfOffice <= 0)
            throw new InvalidSpaceAreaException();
        numberOfRooms = DEFAULT_NUMBER_OF_ROOMS;
        this.areaOfOffice = areaOfOffice;
    }

    public Office(int numberOfRooms, double areaOfOffice){
        if (numberOfRooms <= 0)
            throw new InvalidRoomsCountException();
        if (areaOfOffice <= 0)
            throw new InvalidSpaceAreaException();
        this.numberOfRooms = numberOfRooms;
        this.areaOfOffice = areaOfOffice;
    }

    public void changeNubmerOfRooms(int numberOfRooms){
        if (numberOfRooms <= 0)
            throw new InvalidRoomsCountException();
        this.numberOfRooms = numberOfRooms;
    }

    public void changeAreaOfOffice(double areaOfOffice){
        if (areaOfOffice <= 0)
            throw new InvalidSpaceAreaException();
        this.areaOfOffice = areaOfOffice;
    }

    public int getNumberOfRooms(){
        return numberOfRooms;
    }

    public double getAreaOfOffice(){
        return areaOfOffice;
    }
    }
