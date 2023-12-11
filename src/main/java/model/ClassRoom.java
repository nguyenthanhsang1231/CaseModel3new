package model;

public class ClassRoom {
    private int idClassroom;
    private String name;

    public ClassRoom() {
    }

    public ClassRoom(String name) {
        this.name = name;
    }

    public ClassRoom(int idClassroom, String name) {
        this.idClassroom = idClassroom;
        this.name = name;
    }

    public int getIdClassroom() {

        return idClassroom;
    }

    public void setIdClassroom(int idClassroom) {
        this.idClassroom = idClassroom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
