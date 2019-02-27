<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User Settings</title>
<link rel="stylesheet" type="text/css" href="../../css/style.css"/>
</head>
<body>
<header>
    <%@include file="../jspf/header.jspf"%>
</header>
<section class="steps">
    <div class="steps--container">
        <div class="steps--item">
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
            <div class="steps--item">
                <a href="/user/changePassword" class="btn btn--large">Zmień Hasło</a>
            </div>
            <div class="steps--item">
                <a href="/user/edit" class="btn btn--large">Edytuj Profil</a>
            </div>
            <div class="steps--item">
                <a href="/user/confirmDelete" class="btn btn--large">Usuń Konto</a>
            </div>
        </div>
    </div>
</section>

</body>
</html>