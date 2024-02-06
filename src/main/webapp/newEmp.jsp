<%--
  Created by IntelliJ IDEA.
  User: oyaagoub
  Date: 11/23/23
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<
<html>
<head>
    <title>nuevo Empleado</title>
</head>
<body>
<h1>nuevo Empleado</h1>
<form  action="/emp_new" method="post" style="display:flex;flex-direction: column;justify-content: center;align-items: center">
    <input type="number" name="empno" placeholder="EmpNo" required>
    <input type="text" name="api" placeholder="apellidos" required>
    <input type="text" name="sal" placeholder="salario" required>
    <input type="text" name="com" placeholder="commision" required>
    departamento :
    <select name="dep_id">
        <c:forEach var="dep" items="${departamentos}">
            <option value="${dep.deptno}">${dep.dnombre}</option>
        </c:forEach>

    </select>
    <input type="submit" value="enviar">
</form>
</body>
</html>
