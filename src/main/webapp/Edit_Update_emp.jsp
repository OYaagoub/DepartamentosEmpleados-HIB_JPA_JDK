<%--
  Created by IntelliJ IDEA.
  User: oyaag
  Date: 08/01/2024
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nuevo Empleado</title>
    <style>
        body {
            margin: 0;
            font-family: sans-serif;
        }

        h1 {
            text-align: center;
            font-size: 24px;
        }

        form {
            width: 500px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input, select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }
        select{
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<center>${error}</center>
<c:if test="${action eq 'update'}">
    <h1>Actualizar Empleado</h1>
</c:if>
<c:if test="${action eq 'new'}">
    <h1>Crear nuevo Empleado</h1>
</c:if>

<form method="post" action="/employees">
    <label for="empno">Empno:</label>

    <c:if test="${action eq 'update'}">
        <input type="text" id="empno"  disabled value="${emp.empno}" required>
        <input type="hidden" id="empno" name="empno"  value="${emp.empno}" required>
    </c:if>
    <c:if test="${action eq 'new'}">
        <input type="text" id="empno" name="empno" value="${emp.empno}" required>
    </c:if>
    <input type="hidden"  name="action" value="${action}"  required>
    <label for="apellido">Apellido:</label>
    <input type="text" id="apellido" name="apellido" value="${emp.apellido}" required>

    <label for="salario">Salario:</label>
    <input type="number" id="salario" name="salario" value="${emp.salario}" required>

    <label for="comision">Comisión:</label>
    <input type="number" id="comision" name="comision" value="${emp.comision}" required>


    <c:if test="${rol eq true}">
        <label for="rol">Rol</label>
        <select id="rol" name="rol" required>

            <option value="normal" <c:if test="${emp.rol eq 'normal'}"> selected </c:if> >normal</option>
            <option value="Administrator" <c:if test="${emp.rol eq 'Administrator'}"> selected </c:if> >Administrativo</option>
        </select>
        <label for="dep">Departamento:</label>
        <select id="dep" name="dep" required>
            <c:forEach var="dep" items="${departments}">
                <option value="${dep.deptno}" <c:if test="${dep.deptno==emp.dep.deptno}"> selected </c:if> >${dep.dnombre}</option>
            </c:forEach>

        </select>
    </c:if>
    <c:if test="${rol eq false}">
        <label for="rol">Rol</label>
        <input type="text" id="rol" disabled value="${emp.rol}" required>
        <input type="hidden" id="rol" name="rol"  value="${emp.rol}" required>

        <label for="dep">Departamento:</label>
        <input type="text" id="dep" disabled value="${emp.dep.deptno}" required>
        <input type="hidden" id="dep" name="dep"  value="${emp.dep.deptno}" required>
    </c:if>




    <input type="submit" value="Guardar">
</form>
</body>
</html>
