<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Delete User</title>
    <link rel="stylesheet" type="text/css" href="../../css/style.css"/>
</head>
<body>
<header>
   <%@include file="../jspf/header.jspf"%>
</header>
<section class="login-page">
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
            </tbody>
        </table>
        <table>
            <tr>
                <td><a href="/user/delete" class="btn btn--medium" style="margin: 10px">Usuń</a></td>
                <td><a href="/user/settings" class="btn btn--medium" style="margin: 10px">Wstecz</a></td>
            </tr>
        </table>
    </div>
</section>
</body>
</html>