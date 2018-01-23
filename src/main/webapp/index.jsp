<%--
  Created by IntelliJ IDEA.
  User: edik2
  Date: 16.01.2018
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Food Tracking</title>

    <!-- Bootstrap core CSS
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">-->
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"--%>
          <%--integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>

    <style>
        /* Space out content a bit */
        body {
            padding-top: 1.5rem;
            padding-bottom: 1.5rem;
        }

        /* Make the masthead heading the same height as the navigation */
        .header h3 {
            margin-top: 0;
            margin-bottom: 0;
            line-height: 3rem;
        }

        /* Customize container */
        @media (min-width: 68em) {
            .container {
                max-width: 69rem;
            }
        }

        .container-narrow > hr {
            margin: 2rem 0;
        }

        /* Main marketing message and sign up button */
        .jumbotron {
            text-align: center;
            border-bottom: .05rem solid #e5e5e5;
        }

        .jumbotron .btn {
            padding: .75rem 1.5rem;
            font-size: 1.5rem;
        }

        /* Supporting marketing content */
        .marketing {
            margin: 3rem 0;
        }

        .marketing p + h4 {
            margin-top: 1.5rem;
        }

        /* Responsive: Portrait tablets and up */
        @media screen and (min-width: 48em) {

            /* Remove the bottom border on the jumbotron for visual effect */
            .jumbotron {
                border-bottom: 0;
            }
        }

    </style>
    <!-- Custom styles for this template -->
    <%--<link href="/css/narrow-jumbotron.css" rel="stylesheet" type="text/css">--%>

</head>

<body padding-top: 1.5rem
      padding-bottom: 1.5rem>

<div class="container">

    <jsp:include page="header.jsp"></jsp:include>

    <div class="jumbotron">
        <h1 class="display-3">${welcome1}</h1>
        <p class="lead">${welcome2}</p>
        <c:if test="${sessionScope.accountId != null}">
            <p class="lead">${massage}</p>
            <p class="lead">${taking_calories} / ${sessionScope.norma}</p>

        </c:if>

        <p><c:if test="${sessionScope.accountId == null}"><a class="btn btn-lg btn-success" href="/registration"
                                                         role="button">${registration}</a></c:if>
            <a class="btn btn-lg btn-success" href="/selectfood" role="button">${food_list}</a>
            <c:if test="${sessionScope.accountId == null}"><a class="btn btn-lg btn-success" href="/login"
                                                          role="button">${login_page}</a></c:if></p>
    </div>

</div>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>--%>

</body>
</html>

