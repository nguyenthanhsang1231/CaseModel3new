package model;

public class Student {
    private int idStudent;
    private String DateOfBirth;
    private String Email;
    private String Address;
    private String Phone;
    private int idClassroom;

    public Student() {
    }

    public Student(int idStudent, String dateOfBirth, String email, String address, String phone, int idClassroom) {
        this.idStudent = idStudent;
        DateOfBirth = dateOfBirth;
        Email = email;
        Address = address;
        Phone = phone;
        this.idClassroom = idClassroom;
    }

    public Student(String dateOfBirth, String email, String address, String phone, int idClassroom) {
        DateOfBirth = dateOfBirth;
        Email = email;
        Address = address;
        Phone = phone;
        this.idClassroom = idClassroom;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(int idClassroom) {
        this.idClassroom = idClassroom;
    }
}
