

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h1>JSTL Test</h1>

<p>
    The games we play:
<ul>
    <c:forEach items="${list}" var="game">
        <li>${game}</li>
    </c:forEach>
</ul>
</p>
</body>
</html>