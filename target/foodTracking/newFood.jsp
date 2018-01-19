<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <%--<meta charset="UTF-8">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <title>${addfood}</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style>
        /* Customize container */
        @media (min-width: 68em) {
            .container {
                max-width: 69rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
    <%--<link href="../static/css/justified-nav.css" rel="stylesheet">--%>

</head>

<body>
<div class="container">
    <form class="form-horizontal" role="form" action="/newfood" method="post">
        <h2>Реєстрація</h2>
        <div class="form-group">
            <label for="name" class="col-sm-3 control-label">${name}</label>
            <div class="col-sm-5">
                <input type="text" id="name" name="name" placeholder="${name}" class="form-control" autofocus>
            </div>
        </div>

        <div class="form-group">
            <label for="calories" class="col-sm-3 control-label">${calories}</label>
            <div class="col-sm-5">
                <input type="text" id="calories" name="calories" placeholder="${calories}" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label for="proteins" class="col-sm-3 control-label">${proteins}</label>
            <div class="col-sm-5">
                <input type="text" id="proteins" name="proteins" placeholder="${proteins}"
                       class="form-control">

            </div>
        </div>

        <div class="form-group">
            <label for="grease" class="col-sm-3 control-label">${grease}</label>
            <div class="col-sm-5">
                <input type="text" id="grease" name="grease" placeholder="${grease}" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="angularRods" class="col-sm-3 control-label">${angularrods}</label>
            <div class="col-sm-5">
                <input type="text" id="angularRods" name="angularRods" placeholder="${angularrods}"
                       class="form-control">
            </div>
        </div>
        <!-- /.form-group -->
        <div class="form-group">
            <div class="col-sm-4 col-sm-offset-4">
                <button type="submit" id="submit" class="btn btn-primary btn-block">${addfood}</button>
            </div>
        </div>
    </form> <!-- /form -->
</div> <!-- ./container -->
</body>
</html>
