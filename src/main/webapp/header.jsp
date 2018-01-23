<%--
  Created by IntelliJ IDEA.
  User: edik2
  Date: 16.01.2018
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
<div class="header clearfix">
    <nav>
        <ul class="nav nav-pills float-right">
            <li class="nav-item">
                <a class="nav-link active" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">${language}</button>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="/changelanguage?lang=ukr&country=UA">UKR</a>
                        </li>
                        <li>
                            <a href="/changelanguage?lang=en&country=US">EN</a>
                        </li>
                        <%--<li><a href="#">JavaScript</a></li>--%>
                    </ul>
                </div>
            </li>
                <%--<a class="nav-link" href="/changelanguage?lang=en&country=US">English</a>--%>
            <c:if test="${accountId != null}">
                <li class="nav-item">
                    <a class="nav-link" href="/exit">${exit}</a>
                </li>
            </c:if>
            <c:if test="${accountId == null}">
                <li class="nav-item">
                    <a class="nav-link" href="/login">${enter}</a>
                </li>
            </c:if>
            <c:if test="${accountId == null}">
                <li class="nav-item">
                    <a class="nav-link" href="/registration">${registration}</a>
                </li>
            </c:if>
            <%--<c:choose>--%>
                <%--<c:when test="${accountId != null}">--%>
                    <%--<li class="nav-item">--%>
                        <%--<a class="nav-link" href="/exit">${exit}</a>--%>
                    <%--</li>--%>
                <%--</c:when>--%>
                <%--<c:when test="${accountId == null}">--%>
                    <%--<li class="nav-item">--%>
                        <%--<a class="nav-link" href="/enter">${enter}</a>--%>
                    <%--</li>--%>
                <%--</c:when>--%>
                <%--<c:when test="${accountId == null}">--%>
                    <%--<li class="nav-item">--%>
                        <%--<a class="nav-link" href="/registration">${registration}</a>--%>
                    <%--</li>--%>
                <%--</c:when>--%>

            <%--</c:choose>--%>

        </ul>
    </nav>
    <h3 class="text-muted">Food Tracking</h3>
</div>
<script src="https://code.jquery.com/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>
