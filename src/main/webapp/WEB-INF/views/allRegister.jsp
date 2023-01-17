<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--&lt;%&ndash;<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>&ndash;%&gt;--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@page session="false" %>--%>
<%--<spring:url value="/page.html">--%>


<%--<%@ page isELIgnored ="false" %>--%>



<html>
<head>
    <title>User</title>
</head>
<style>
    th {
        color: rgb(255, 255, 255);
        border: 1px solid rgb(219, 219, 219);
        font-weight: normal;
        background-color: rgb(124, 124, 125);
    }
    table {
        border-collapse: collapse;
    }
    td {
        color: rgb(77, 77, 79);
        border: 1px solid rgb(219, 219, 219);
        background-color: rgb(231, 231, 231);
    }
    td, th {
        padding: 15px 20px;
    }
</style>
<body>
<h2>Lista użytkowników</h2>
<table>
    <tr>
        <th>Email</th>
        <th>Imie</th>
        <th>Nazwisko</th>
        <th>Kraj</th>
        <th>Miasto</th>
        <th>Ulica</th>
        <th>Numer domu</th>
        <th>Numer mieskania</th>
        <th>Kod pocztowy</th>
        <th>Numer telefonu</th>
        <th>Action</th>



    </tr>
    <c:forEach items="${user}" var="u">
        <tr>
            <td><c:out value="${u.username}"/></td>
            <td><c:out value="${u.firstName}"/></td>
            <td><c:out value="${u.lastName}"/></td>
            <td><c:out value="${u.country}"/></td>
            <td><c:out value="${u.city}"/></td>
            <td><c:out value="${u.street}"/></td>
            <td><c:out value="${u.houseNumber}"/></td>
            <td><c:out value="${u.apartmentNumber}"/></td>
            <td><c:out value="${u.zipCode}"/></td>
            <td><c:out value="${u.phoneNumber}"/></td>


            <td><a href="<c:url value="/userform/delete/${u.id}"/>"
                   onclick="return confirm('Are you sure you want to delete user \'${u.username}\'?')">Delete</a>
                <br><a href="<c:url value="/userform/edit/${u.id}"/>">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value="/register"/>">Add User</a><br>
<a href="<c:url value="/event/list"/>">ListEvent</a><br>
</body>
</html>

