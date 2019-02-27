<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User Password Change</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <%@include file="../jspf/header.jspf"%>
</header>
<section class="login-page">
    <form:form modelAttribute="userToEdit" action="/user/changePassword" method="post">
        <div class="form-group">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <td>ID</td>
                    <td>Imię</td>
                    <td>Naziwsko</td>
                    <td>Email</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${LoggedUser.id}</td>
                    <td>${LoggedUser.name}</td>
                    <td>${LoggedUser.surname}</td>
                    <td>${LoggedUser.email}</td>
                </tr>

                <div class="form-group"><form:hidden path="id"/><form:errors path="id"/></div>
                <div class="form-group"><form:hidden path="name" required="true"/><form:errors path="name"/></div>
                <div class="form-group"><form:hidden path="surname" required="true"/><form:errors path="surname"/></div>
                <div class="form-group"><form:hidden path="email" required="true"/><form:errors path="email"/></div>
                <div class="form-group"><form:password path="password" placeholder="Hasło" required="true"/><form:errors path="password"/></div>
                <div class="form-group"><form:password path="confirmedPassword" placeholder="Powtórz hasło" required="true"/><form:errors path="confirmedPassword"/></div>
                </tbody>
            </table>
            <table>
                <tr>
                    <td>
                        <button class="btn" type="submit">Zatwierdź zmiany</button>
                    </td>
                    <td><a href="/user/settings" class="btn btn--medium" style="margin: 10px">Wstecz</a></td>
                </tr>
            </table>

        </div>
    </form:form>
</section>

</body>
</html>
