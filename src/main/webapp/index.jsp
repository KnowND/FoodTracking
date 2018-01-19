<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<body>
<h2>Hello World!</h2>

<div class="container">
    <form class="form-horizontal" role="form" action="/login" method="post">
        <div class="form-group">
            <div class="col-sm-4 col-sm-offset-4">
                <a href="login.jsp">${login_page}</a>
            </div>
        </div>
    </form>

    <form class="form-horizontal" role="form" action="/registration" method="post">
        <div class="form-group">
            <div class="col-sm-4 col-sm-offset-4">
                <a href="registration.jsp">${registration}</a>            </div>
        </div>
    </form>

    <form class="form-horizontal" role="form" action="/foodintake" method="post">
        <div class="form-group">
            <div class="col-sm-4 col-sm-offset-4">
                <a href="foodIntake.jsp">${food_list}</a>
            </div>
        </div>
    </form>
</div>

</body>
</html>
