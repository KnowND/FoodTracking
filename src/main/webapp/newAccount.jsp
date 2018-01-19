<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
    <%--<meta charset="UTF-8">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Registration</title>

    <!-- Bootstrap core CSS -->
    <%--<link href="../static/css/bootstrap.min.css" rel="stylesheet">--%>

    <!-- Custom styles for this template -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <%--<link rel="stylesheet" href="../static/css/font-awesome.min.css">--%>
    <%--<link rel="stylesheet" href="../static/css/registre.css">--%>
</head>

<body>
<div class="container">
    <form class="form-horizontal" role="form" action="/registration" method="post">
        <h2>Реєстрація</h2>
        <div class="form-group">
            <label for="name" class="col-sm-3 control-label">Ім'я</label>
            <div class="col-sm-7">
                <input type="text" id="name" name="name" placeholder="Ім'я" class="form-control" autofocus>
            </div>
        </div>

        <div class="form-group">
            <label for="surname" class="col-sm-3 control-label">Прізвище</label>
            <div class="col-sm-7">
                <input type="text" id="surname" name="surname" placeholder="Прізвище" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label for="login" class="col-sm-3 control-label">Email(login)</label>
            <div class="col-sm-7">
                <input type="text" id="login" name="login" placeholder="Унікальньний email або логін"
                       class="form-control">

            </div>
        </div>

        <div class="form-group">
            <label for="password" class="col-sm-3 control-label">Пароль</label>
            <div class="col-sm-7">
                <input type="password" id="password" name="password" placeholder="Пароль" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="age" class="col-sm-3 control-label">Вік</label>
            <div class="col-sm-7">
                <input type="text" id="age" name="age" placeholder="Вік" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="weight" class="col-sm-3 control-label">Вага</label>
            <div class="col-sm-7">
                <input type="text" id="weight" name="weight" placeholder="Вага" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label for="height" class="col-sm-3 control-label">Зріст</label>
            <div class="col-sm-7">
                <input type="text" id="height" name="height" placeholder="Зріст" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label for="wol" class="col-sm-3 control-label">Стиль життя</label>
            <div class="col-sm-7">
                <input type="text" id="wol" name="wol" placeholder="Стиль життя" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-4 col-sm-offset-4">
                <button type="submit" id="submit" class="btn btn-primary btn-block">Зареєструватися</button>
            </div>
        </div>
    </form> <!-- /form -->
</div> <!-- ./container -->
</body>
</html>
