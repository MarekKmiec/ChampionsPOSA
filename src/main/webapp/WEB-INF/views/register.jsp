<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF-8">
        <title>dziala</title>
    <style>
        .errors {
            color: red;
        }

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
</head>
<body>
<table>
    <tr>
        <th> Formularz rejestracyjny</th>
    </tr>


register!!!!!!
<form:form method="post"  action="/register" modelAttribute="user">
<tr>
    <td>

    <form:input path="username" type="email" name="username" placeholder="Email" /><form:errors path="username" cssClass="errors"/>
    <br>
    <form:input path="password" type="password" name="password" placeholder="Hasło" /><form:errors path="password" cssClass="errors"/>
    <br>
    <form:input path="matchingPassword" type="password" name="matchingPassword" placeholder="Powtórz hasło" /><form:errors path="matchingPassword" cssClass="errors"/>
    <br>
    <form:input path="firstName" type="txt" name="firstName" placeholder="Imię" /><form:errors path="firstName" cssClass="errors"/>
    <br>
    <form:input path="lastName" type="txt" name="lastName" placeholder="Nazwisko" /><form:errors path="lastName" cssClass="errors"/>
    <br>
    <form:input path="street" type="txt" name="street" placeholder="Ulica" /><form:errors path="street" cssClass="errors"/>
    <br>
    <form:input path="houseNumber" type="txt" name="houseNumber" placeholder="Numer domu" /><form:errors path="houseNumber" cssClass="errors"/>
    <br>
    <form:input path="apartmentNumber" type="txt" name="apartmentNumber" placeholder="Numer mieszkania" /><form:errors path="apartmentNumber" cssClass="errors"/>
    <br>
    <form:input path="city" type="txt" name="city" placeholder="Miasto" /><form:errors path="city" cssClass="errors"/>
    <br>
    <form:input path="zipCode" type="txt" name="zipCode" placeholder="Kod pocztowy" /><form:errors path="zipCode" cssClass="errors"/>
    <br>
    <form:input path="country" type="txt" name="country" placeholder="Obywatelstow" /><form:errors path="country" cssClass="errors"/>
    <br>
    <form:input path="phoneNumber" type="txt" name="phoneNumber" placeholder="Numer telefonu" /><form:errors path="phoneNumber" cssClass="errors"/>
    <br>
    <form:hidden path="id" />
</td>
    </table>


    <button class="btn" type="submit">Załóż konto</button>

</form:form>
</body>
</html>