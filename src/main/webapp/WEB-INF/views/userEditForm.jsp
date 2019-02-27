<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit User</title>
    <link rel="stylesheet" type="text/css" href="../../css/style.css"/>
</head>
<body>
<header>
    <%@include file="../jspf/header.jspf"%>
</header>
<h2> Edytuj Konto </h2>

<section class="login-page">
    <form:form modelAttribute="user" action="/user/edit" method="post">
        <div class="form-group">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <td>ID</td>
                    <td>Imię</td>
                    <td>Naziwsko</td>
                    <td>Email</td>
                    <td>Hasło</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>${user.email}</td>
                    <td>***********</td>
                </tr>

                <div class="form-group"><form:hidden path="id"/><form:errors path="id"/></div>
                <div class="form-group"><form:input path="name" placeholder="${user.name}" required="true"/><form:errors
                        path="name"/></div>
                <div class="form-group"><form:input path="surname" placeholder="${user.surname}"
                                                    required="true"/><form:errors path="surname"/></div>
                <div class="form-group"><form:input path="email" type="email" placeholder="${user.email}"
                                                    required="true"/><form:errors path="email"/></div>
                <div class="form-group"><form:hidden path="password"/><form:errors
                        path="password"/></div>
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