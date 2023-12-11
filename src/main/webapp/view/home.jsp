<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/11/2023
  Time: 8:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/student?action=add">Thêm người mới</a>
<form action="">
    <table>
        <thead>
            <tr>
                <th>idStudent</th>
                <th>DateOfBirth</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Classroom</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.getIdStudent()}</td>
                <td>${student.getDateOfBirth()}</td>
                <td>${student.getEmail()}</td>
                <td>${student.getAddress()}</td>
                <td>${student.getPhone()}</td>
                <td>${student.getDateOfBirth()}</td>
                <td><button><a href="/student?action=edit&id=${student.getIdStudent()}"></a>EDIT</button></td>
                <td><button><a href="/student?action=delete&id=${student.getIdStudent()}"></a>DELETE</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>
