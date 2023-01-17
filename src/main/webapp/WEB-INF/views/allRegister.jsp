<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--&lt;%&ndash;<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>&ndash;%&gt;--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@page session="false" %>--%>
<%--<spring:url value="/page.html">--%>


<%--<%@ page isELIgnored ="false" %>--%>





<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>dziala</title>
</head>
<body>

allRegister!!!!

<c:forEach items="${user}" var="u">
    <c:out value="${u.username}"></c:out>
</c:forEach>
<%--<c:out value="${1+1}"/>--%>
<%--<c:out value="<b> bold text </b>" escapeXml="false"/>--%>

</body>
</html>
<%--<html>--%>
<%--<head>--%>
<%--    <title>User</title>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">--%>
<%--</head>--%>
<%--<style>--%>
<%--    /*th {*/--%>
<%--    /*  color: rgb(255, 255, 255);*/--%>
<%--    /*  border: 1px solid rgb(219, 219, 219);*/--%>
<%--    /*  font-weight: normal;*/--%>
<%--    /*  background-color: rgb(124, 124, 125);*/--%>
<%--    /*}*/--%>
<%--    /*table {*/--%>
<%--    /*  border-collapse: collapse;*/--%>
<%--    /*}*/--%>
<%--    /*td {*/--%>
<%--    /*  color: rgb(77, 77, 79);*/--%>
<%--    /*  border: 1px solid rgb(219, 219, 219);*/--%>
<%--    /*  background-color: rgb(231, 231, 231);*/--%>
<%--    /*}*/--%>
<%--    /*td, th {*/--%>
<%--    /*  padding: 15px 20px;*/--%>
<%--    /*}*/--%>
<%--</style>--%>
<%--<body>--%>
<%--<h3>Lista użytkowników</h3>--%>
<%--<table class="table table-striped ">--%>
<%--    <tr>--%>
<%--        <th>User name</th>--%>
<%--        <th>phoneNumber</th>--%>
<%--        <th>action</th>--%>

<%--    </tr>--%>
<%--    <c:forEach items="${user}" var="u">--%>
<%--        <tr>--%>
<%--            <td><c:out value="${u.username}"/></td>--%>
<%--            <td><c:out value="${u.phoneNumber}"/></td>--%>
<%--            <td><a href="<c:url value="/userform/delete/${u.id}"/>"--%>
<%--                   onclick="return confirm('Are you sure you want to delete user \'${u.name}\'?')">Delete</a>--%>
<%--                <br><a href="<c:url value="/userform/edit/${u.id}"/>">Edit</a></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
<%--<a href="<c:url value="/userform/add"/>">Add User</a><br>--%>
<%--<a href="<c:url value="/expense/list"/>">List Expenses</a><br>--%>
<%--<a href="<c:url value="/event/list"/>">ListEvent</a><br>--%>
<%--</body>--%>
<%--</html>--%>
