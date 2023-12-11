<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/11/2023
  Time: 8:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post">
    <h1>EDIT NEW BOOK</h1>
    <table>
        <tr>
            <br>
            <th>DataOfBirth</th>
            <th>Email</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Class Room</th>
        </tr>
        <tr>
            <td><input type="text" name="DateOfBirth" value="${studentEdit.getDateOfBirth}"/></td>
            <td><input type="text" name="Email" value="${studentEdit.getEmail}" /></td>
            <td><input type="text" name="Address" value="${studentEdit.getAddress}"/></td>
            <td><input type="text" name="Phone" value="${studentEdit.getPhone}" /></td>
            <td><input type="text" name="idClassroom" value="${studentEdit.getIdClassroom}"/></td>
            <td><button type="submit">OK</button></td>
        </tr>
    </table>

</form>
</body>
</html>
