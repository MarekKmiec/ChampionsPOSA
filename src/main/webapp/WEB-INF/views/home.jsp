<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<%--git!--%>
<%--<ul >--%>
<%--    <li><a href="/login" >Zaloguj</a></li>--%>
<%--    <li><a href="/register" >Załóż konto</a></li>--%>
<%--</ul>--%>

<table>
    <thead>
    <tr>
        <th th:text="#{msgs.headers.name}">Name</th>
        <th th:text="#{msgs.headers.price}">Price</th>
    </tr>
    </thead>
    <tbody>
    <tr th:each="prod: ${allProducts}">
        <td th:text="${prod.name}">Oranges</td>
        <td th:text="${#numbers.formatDecimal(prod.price, 1, 2)}">0.99</td>
    </tr>
    </tbody>
</table>



</body>
</html>