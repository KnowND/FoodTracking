<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: edik2
  Date: 15.01.2018
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <form class="form-horizontal" role="form" action="/foodintake" method="post">
        <input type="hidden" name="id" value="${param.id}"/>
        <input type="hidden" name="calories" value="${param.calories}"/>
        <div class="form-group">
            <table>
                <tr>
                    <td>
                        <label for="grams" class="col-sm-3 control-label">${param.name}</label>
                        <div class="col-sm-3">
                            <p><input type="text" id="grams" name="grams" placeholder="${grams}" class="form-control">
                                ${gram}</p>
                        </div>
                    </td>
                    <td>
                        <button type="submit" id="submit" class="btn btn-primary btn-block">${add}</button>
                    </td>
                </tr>
            </table>
        </div>
    </form>

</div>

</body>
</html>
