package servlet;

import controller.StudentController;
import model.Student;
import org.omg.CORBA.Request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private StudentController studentController;
    public void init() {
        studentController = new StudentController();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "showAll":
                    showAll(request, response);
                    break;
                case "add" :
                    addStudentGet(request,response);
                    break;
                case "delete" :
                    deleteStudent(request, response);
                    break;
                case "edit" :
                    editStudentGet(request, response);
                    break;
                default:
                    showAll(request, response);
        }
        } else {
            showAll(request, response);
        }
    }

    public void editStudentGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam =request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
    try {
        int id = Integer.parseInt(request.getParameter(idParam));
        request.setAttribute("id", id);
        System.out.println(id);
        Student studentEdit = studentController.findStudentById(id);
        request.setAttribute("studentEdit", studentEdit);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/edit.jsp");
        dispatcher.forward(request, response);
    } catch (NumberFormatException e) {
        e.printStackTrace();
    }
}
    }
    public void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> students = studentController.showAll();
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/home.jsp");
        dispatcher.forward(request, response);
    }

    public void addStudentGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/add.jsp");
        dispatcher.forward(request, response);
    }

    public void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("idStudent"));
        studentController.delete(id);
        response.sendRedirect("/student?action=home");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "add" :
                addStudentPost(request, response);
                break;
            case "edit" :
                editStudentPost(request, response);
                break;
        }
    }
    public void addStudentPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String DateOfBirthAdd = request.getParameter("DateOfBirth");
        String EmailAdd = request.getParameter("Email");
        String AddressAdd = request.getParameter("Address");
        String PhoneAdd = request.getParameter("Phone");
        int ClassroomAdd = Integer.parseInt(request.getParameter("idClassroom"));
        Student student = new Student(DateOfBirthAdd, EmailAdd, AddressAdd, PhoneAdd, ClassroomAdd);
        studentController.add(student);
        response.sendRedirect("/student?action=home");
    }

    public void editStudentPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("idStudent"));
        String DateOfBirth = request.getParameter("DateOfBirth");
        String Email = request.getParameter("Email");
        String Address = request.getParameter("Address");
        String Phone = request.getParameter("Phone");
        int Classroom = Integer.parseInt(request.getParameter("idClassroom"));
        Student student = new Student(DateOfBirth, Email, Address, Phone, Classroom);
        studentController.edit(id, student);
        response.sendRedirect("/student?action=home");
    }
}