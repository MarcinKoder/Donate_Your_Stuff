<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Log in</title>
    <link rel="stylesheet" href="../../css/style.css"/>
</head>
<body>
<header>
    <%@include file="../jspf/header.jspf" %>
</header>
<section class="login-page">
    <h2>Zaloguj się</h2>
    <form:form modelAttribute="userDto" method="post" action="/login">
        <c:if test="${param['error'] != null}">
            <p>Błędne login/hasło!</p>
        </c:if>
        <div class="form-group">
            <form:input path="email" type="email" required="true" placeholder="Email"/><form:errors path="email"/>
        </div>
        <div class="form-group">
            <form:password path="password" required="true" placeholder="Hasło"/><form:errors path="password"/><br>
            <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>
        <div class="form-group form-group--buttons">
            <a href="#" class="btn btn--without-border">Załóż konto</a>
            <button class="btn" type="submit">Zaloguj się</button>
        </div>
    </form:form>
</section>

<%@include file="../jspf/footer.jspf" %>
</body>
</html>

