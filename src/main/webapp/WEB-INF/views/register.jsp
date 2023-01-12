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
</head>
<body>



register!!!!!!
<form:form method="post"  action="/login/register" modelAttribute="userregister">

    <form:input path="username" type="email" name="username" placeholder="Email" />
    <br>
    <form:input path="password" type="password" name="password" placeholder="Hasło" />
    <br>
    <form:input path="password2" type="password" name="password2" placeholder="Powtórz hasło" />
    <br>
    <form:input path="firstName" type="txt" name="firstName" placeholder="Imię" />
    <br>
    <form:input path="lastName" type="txt" name="lastName" placeholder="Nazwisko" />
    <br>
    <form:input path="street" type="txt" name="street" placeholder="Ulica" />
    <br>
    numer domu
    <br>
    <form:input path="houseNumber" type="txt" name="houseNumber" placeholder="Numer domu" />
    <br>
    numer mieszkania
    <br>
    <form:input path="apartmentNumber" type="txt" name="apartmentNumber" placeholder="Numer mieszkania" />
    <br>
    <form:input path="city" type="txt" name="city" placeholder="Miasto" />
    <br>
    <form:input path="zipCode" type="txt" name="zipCode" placeholder="Kod pocztowy" />
    <br>
    <form:input path="country" type="txt" name="country" placeholder="Obywatelstow" />
    <br>
    Numer telefonu
    <br>
    <form:input path="phoneNumber" type="number" name="phoneNumber" placeholder="Numer telefonu" />
    <br>


    <button class="btn" type="submit">Załóż konto</button>

</form:form>
</body>
</html>