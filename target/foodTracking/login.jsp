<%--
  Created by IntelliJ IDEA.
  User: edik2
  Date: 14.01.2018
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>${login_page}</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        @media (min-width: 68em) {
            .container {
                max-width: 69rem;
            }
        }
    </style>
</head>
<body>

<div class="container">
    <form class="form-horizontal" role="form" action="/login" method="post">
        <h2>Реєстрація</h2>
        <p>${error_login}</p>
        <div class="form-group">
            <label for="login" class="col-sm-3 control-label">${login}</label>
            <div class="col-sm-7">
                <input type="text" id="login" name="login" placeholder="${login}" class="form-control" autofocus>
            </div>
        </div>

        <div class="form-group">
            <label for="password" class="col-sm-3 control-label">${password}</label>
            <div class="col-sm-7">
                <input type="password" id="password" name="password" placeholder="${password}" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-4 col-sm-offset-4">
                <button type="submit" id="submit" class="btn btn-primary btn-block">${enter}</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
