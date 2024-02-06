<%--
  Created by IntelliJ IDEA.
  User: oyaagoub
  Date: 11/23/23
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        table {
            border: 1px solid black;
            width: 80%;
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
<center>Lista de empleados</center>
<table>
    <thead>
    <tr>
        <th>Emp-no</th>
        <th>Apellidos</th>
        <th>Salario</th>
        <th>Comisión</th>
        <th>Dept. No</th>
        <th>Sueldo</th>
        <th>Notas</th>
        <th>Funciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dep" items="${emplds}">
        <c:if test="${rol eq true}">
        <tr>
            <td>${dep.empno}</td>
            <td>${dep.apellido}</td>
            <td>${dep.salario}</td>
            <td>${dep.comision}</td>
            <td>${dep.dep.deptno}</td>
            <td>
                <c:choose>
                    <c:when test="${dep.salario + dep.comision < 1500}">
                        ${dep.salario + dep.comision + 200}
                    </c:when>
                    <c:otherwise>
                        ${dep.salario + dep.comision}
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:if test="${dep.salario + dep.comision < 1500}">
                    Plus 200€
                </c:if>
            </td>
            <td>
                <c:choose>
                    <c:when test="${rol eq true}">
                        <a href="/editE?id=${dep.empno}&action=update">Editar</a>
                        <a href="/delete?id=${dep.empno}&on=emp">Delete</a>
                    </c:when>
                    <c:otherwise>

                        <c:if test="${dep.empno eq pertenece}">
                            <a href="/editE?id=${dep.empno}&action=update">Editar</a>
                        </c:if>

                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        </c:if>
        <c:if test="${rol eq false}">
            <c:if test="${dep.empno eq pertenece}">
                <td>${dep.empno}</td>
                <td>${dep.apellido}</td>
                <td>${dep.salario}</td>
                <td>${dep.comision}</td>
                <td>${dep.dep.deptno}</td>
                <td>
                    <c:choose>
                        <c:when test="${dep.salario + dep.comision < 1500}">
                            ${dep.salario + dep.comision + 200}
                        </c:when>
                        <c:otherwise>
                            ${dep.salario + dep.comision}
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:if test="${dep.salario + dep.comision < 1500}">
                        Plus 200€
                    </c:if>
                </td>
                <td>
                    <a href="/editE?id=${dep.empno}&action=update">Editar</a>
                </td>
            </c:if>

        </c:if>
    </c:forEach>

    </tbody>
</table>
<center>Total de empleados: ${total}</center>
<a href="/departments">Volver al inicio</a>

<c:if test="${rol eq true}">
    <a href="/editE?action=new">nuevo empleado</a>
</c:if>
</body>
</html>
