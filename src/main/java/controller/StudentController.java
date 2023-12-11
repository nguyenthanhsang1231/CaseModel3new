package controller;

import database.Database;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentController implements IStudent<Student> {

    ArrayList<Student> list = new ArrayList<>();
    private Connection connection = Database.getConnection();

    @Override
    public void add(Student student) {
        String sql = "insert into student(DateOfBirth, Email, Address, Phone, idClassroom) values (?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getDateOfBirth());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setInt(5, student.getIdStudent());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(int id, Student student) {
        String sql = "update student set DateOfBirth = ?, Email = ?, Address = ?, Phone = ? where idStudent = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getDateOfBirth());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from student where idStudent = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findById(int id) {
        for (Student student : list ) {
if (id == student.getIdStudent()) {
    return student;
}
        }
        return null;
    }

    @Override
    public ArrayList<Student> showAll() {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "select * from student;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idStudent = resultSet.getInt("idStudent");
                String DateOfBirth = resultSet.getString("DateOfBirth");
                String Email = resultSet.getString("Email");
                String Address = resultSet.getString("Address");
                String Phone = resultSet.getString("Phone");
                int idClassroom = resultSet.getInt("idClassroom");
                Student student = new Student(idStudent, DateOfBirth, Email, Address, Phone, idClassroom);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public Student findStudentById(int id) {
        String sql = "select * from book where idStudent = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String DateOfBirth = resultSet.getString("DateOfBirth");
                String Email = resultSet.getString("Email");
                String Address = resultSet.getString("Address");
                String Phone = resultSet.getString("Phone");
                int idClassroom = resultSet.getInt("idClassroom");
                Student student = new Student(DateOfBirth, Email, Address, Phone, idClassroom);
                return student;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
