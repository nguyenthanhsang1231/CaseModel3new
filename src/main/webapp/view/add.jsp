<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/11/2023
  Time: 8:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD</title>
</head>
<body>
<form method="post">
    <h1>ADD NEW BOOK</h1>
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
            <td><input type="date" name="DateOfBirth"/></td>
            <td><input type="text" name="Email" /></td>
            <td><input type="text" name="Address" /></td>
            <td><input type="text" name="Phone" /></td>
            <td><input type="number" name="idClassroom" /></td>
            <td><button type="submit">OK</button></td>
        </tr>
    </table>

</form>

</body>
</html>
