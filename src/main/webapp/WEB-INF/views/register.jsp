<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="../../css/style.css"/>
</head>
<body>
<header>
    <%@include file="../jspf/header.jspf" %>
</header>
<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form modelAttribute="registrationForm" method="post">
        <div class="form-group">
            <form:input path="email" type="email" placeholder="Email" required="true"/><form:errors path="email"/>
        </div>
        <div class="form-group">
            <form:input path="name" placeholder="Podaj Imię" required="true"/><form:errors path="name"/>
        </div>
        <div class="form-group">
            <form:input path="surname" placeholder="Podaj Nazwisko" required="true"/><form:errors path="surname"/>
        </div>
        <div class="form-group">
            <form:password path="password" placeholder="Hasło" required="true"/><form:errors path="password"/>
        </div>
        <div class="form-group">
            <form:password path="confirmPassword" placeholder="Powtórz hasło" required="true"/><form:errors
                path="confirmPassword"/>
        </div>
        <form:errors path="password"/>
        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>


<%@include file="../jspf/footer.jspf" %>
</body>
</html>
