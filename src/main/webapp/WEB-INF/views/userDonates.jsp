<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XxX
  Date: 27.02.2019
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My donations</title>
    <link rel="stylesheet" type="text/css" href="../../css/style.css"/>
</head>
<body>
<header>
<%@include file="../jspf/header.jspf"%>
</header>
<section class="steps">
    <h3>MY DONATIONS</h3>
    <div class="steps--container">
        <div class="steps--item">
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <td>Ilość</td>
                    <td>Typ</td>
                    <td>Wspierana organizacja</td>
                    <td>Data odbioru</td>
                    <td>Godina odbioru</td>
                    <td>Archwizuj</td>
                </tr>
                </thead>
                <c:forEach var="donate" items="${userDonates}">
                    <tbody>
                    <tr>
                        <th scope="row">${donate.id}</th>
                        <td scope="row">${donate.amount}</td>
                        <td scope="row">${donate.types}</td>
                        <td scope="row">${donate.charity}</td>
                        <td scope="row">${donate.date}</td>
                        <td scope="row">${donate.hour}</td>
                        <td scope="row">
                            <div class="form-group form-group--buttons">
                                <a href="/user/donates/archive/${donate.id}" class="btn btn--small"> Zarchiwizuj </a>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
            <div class="steps--item">
                <a href="/user/orders/add" class="btn btn--large">Podaruj kolejną donację</a>
            </div>
        </div>
    </div>
</section>
</body>
</html>
