<form:form method="post"  action="/register" modelAttribute="user">

    <form:input path="username" type="email" name="username" placeholder="Email" /><form:errors path="username" cssClass="errors"/>
    <br>
    <form:input path="password" type="password" name="password" placeholder="Hasło" /><form:errors path="password" cssClass="errors"/>
    <br>
    <form:input path="password2" type="password" name="password2" placeholder="Powtórz hasło" /><form:errors path="password2" cssClass="errors"/>
    <br>
    <form:input path="firstName" type="txt" name="firstName" placeholder="Imię" /><form:errors path="firstName" cssClass="errors"/>
    <br>
    <form:input path="lastName" type="txt" name="lastName" placeholder="Nazwisko" /><form:errors path="lastName" cssClass="errors"/>
    <br>
    <form:input path="street" type="txt" name="street" placeholder="Ulica" /><form:errors path="street" cssClass="errors"/>
    <br>
    numer domu
    <br>
    <form:input path="houseNumber" type="txt" name="houseNumber" placeholder="Numer domu" /><form:errors path="houseNumber" cssClass="errors"/>
    <br>
    numer mieszkania
    <br>
    <form:input path="apartmentNumber" type="txt" name="apartmentNumber" placeholder="Numer mieszkania" /><form:errors path="apartmentNumber" cssClass="errors"/>
    <br>
    <form:input path="city" type="txt" name="city" placeholder="Miasto" /><form:errors path="city" cssClass="errors"/>
    <br>
    <form:input path="zipCode" type="txt" name="zipCode" placeholder="Kod pocztowy" /><form:errors path="zipCode" cssClass="errors"/>
    <br>
    <form:input path="country" type="txt" name="country" placeholder="Obywatelstow" /><form:errors path="country" cssClass="errors"/>
    <br>
    Numer telefonu
    <br>
    <form:input path="phoneNumber" type="txt" name="phoneNumber" placeholder="Numer telefonu" /><form:errors path="phoneNumber" cssClass="errors"/>
    <br>
    <%--    <form:hidden path="id" />--%>




    <button class="btn" type="submit">uaktualnij dane</button>

</form:form>