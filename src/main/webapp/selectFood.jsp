<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="UTF-8"/>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style>
        input {
            height: 1.2em;
        }

        input[name="q"] {
            padding-right: 1.8em;
        }

        input[type="image"] {
            width: 1.2em;
            position: relative;
            left: -1.8em;
            vertical-align: middle;
        }

        /* Customize container */
        @media (min-width: 68em) {
            .container {
                max-width: 69rem;
            }
        }

        .button1 {
            display: block;
            width: 115px;
            height: 25px;
            background: #4E9CAF;
            padding: 10px;
            text-align: center;
            border-radius: 5px;
            color: white;
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="container">


    <form role="form" action="/selectFood" method="post" target="_blank">
        <div class="col-lg-5">
            <div class="input-group">
                <input type="text" class="form-control" name="search_food" placeholder="">
                <span class="input-group-btn">
        <button class="btn btn-secondary" type="submit" id="submit">${search}</button>
                            <p><a class="btn btn-lg btn-success" href="/registration" role="button">${registration}</a>
            <a class="btn btn-lg btn-success" href="/selectFood" role="button">${food_list}</a>
            <a class="btn btn-lg btn-success" href="/login" role="button">${login_page}</a></p>
                    <a class="button1" href="/newfood">New Food</a>
      </span>
            </div>
        </div>
    </form>

    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">${name}</th>
            <th scope="col">${proteins}</th>
            <th scope="col">${grease}</th>
            <th scope="col">${angular_rods}</th>
            <th scope="col">${calories}</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${foodList}" var="food">
            <tr>
                <td>
                    <a href="/foodintake/?id=${food.id}&name=${food.foodName}&calories=${food.calories}"><c:out
                            value="${food.foodName}"/></a>
                </td>
                <td>
                    <c:out value="${food.proteins}"/>
                </td>
                <td>
                    <c:out value="${food.grease}"/>
                </td>
                <td>
                    <c:out value="${food.angularRods}"/>
                </td>
                <td>
                    <c:out value="${food.calories}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>


</body>
</html>
