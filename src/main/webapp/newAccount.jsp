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
        <h2 class="text-center">${registration}</h2>
        <div class="form-group">
            <label for="name" class="col-sm-3 control-label">${name}</label>
            <div class="col-sm-4">
                <input type="text" id="name" name="name" placeholder="${name}" class="form-control" autofocus>
            </div>
        </div>

        <div class="form-group">
            <label for="surname" class="col-sm-3 control-label">${surname}</label>
            <div class="col-sm-4">
                <input type="text" id="surname" name="surname" placeholder="${surname}" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label for="email" class="col-sm-3 control-label">${email}</label>
            <div class="col-sm-4">
                <input type="text" id="email" name="email" placeholder="${email}" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label for="password" class="col-sm-3 control-label">${password}</label>
            <div class="col-sm-4">
                <input type="password" id="password" name="password" placeholder="${password}" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="age" class="col-sm-3 control-label">${age}</label>
            <div class="col-sm-4">
                <input type="text" id="age" name="age" placeholder="${age}" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="weight" class="col-sm-3 control-label">${weight}</label>
            <div class="col-sm-4">
                <input type="text" id="weight" name="weight" placeholder="${weight}" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label for="height" class="col-sm-3 control-label">${height}</label>
            <div class="col-sm-4">
                <input type="text" id="height" name="height" placeholder="${height}" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label for="wol" class="col-sm-3 control-label">${wol}</label>
            <div class="col-sm-4">
                <input type="text" id="wol" name="wol" placeholder="${wol}" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-4 col-sm-offset-2">
                <button type="submit" id="submit" class="btn btn-primary btn-block">${register}</button>
            </div>
        </div>
    </form> <!-- /form -->
</div> <!-- ./container -->
</body>
</html>
