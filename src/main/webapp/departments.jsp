<%--
  Created by IntelliJ IDEA.
  User: oyaagoub
  Date: 11/23/23
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>departamentos</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        table {
            border: 1px solid black;
            width: 60%;
        }

        th {
            text-align: left;
            padding: 10px;
            background: antiquewhite;
            border: 1px solid black;
        }

        td {
            padding: 10px;
            border: 1px solid black;
        }

        a {
            padding: 10px 15px;
            background: antiquewhite;
            border-radius: 10px;
            margin: 10px;
        }
    </style>
</head>
<body>
<center>${error}</center>
<center>Lista departamentos</center>
<table>
    <thead>
    <tr>
        <th>Dept no</th>
        <th>nombre</th>
        <th>localidad</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dep" items="${departments}">
        <tr>
            <td>${dep.deptno}</td>
            <td>${dep.dnombre}</td>
            <td>${dep.loc}</td>
            <c:if test="${isLoginIn eq true}">
                <c:choose>
                    <c:when test="${rol}">
                        <td><a href="/employees?id=${dep.deptno}">ver sus empleados</a></td>
                        <td><a href="/edit?id=${dep.deptno}&action=update">Edit</a></td>
                        <td><a href="/delete?id=${dep.deptno}&on=dep">Delete</a></td>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${dep.deptno eq pertenece}">
                            <td><a href="/employees?id=${dep.deptno}">ver sus empleados</a></td>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${rol eq true}">
    <a href="/employees">lista de empleados</a>
    <a href="/edit?action=new">now Department</a>
</c:if>
<center>total:  ${total}</center>
<c:if test="${isLoginIn eq false}">
    <a href="/login" style="padding: 10px 15px;background: antiquewhite;border-radius: 10px;margin:10px;">Login</a>
</c:if>
<c:if test="${isLoginIn eq true}">
    <a href="/logout" style="padding: 10px 15px;background: antiquewhite;border-radius: 10px;margin:10px;">logout</a>
</c:if>
</body>
</html>
