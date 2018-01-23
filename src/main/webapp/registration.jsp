<%--
  Created by IntelliJ IDEA.
  User: edik2
  Date: 22.01.2018
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${registration}</title>
    <style>
        .palel-primary
        {
            border-color: #bce8f1;
        }
        .panel-primary>.panel-heading
        {
            background:#bce8f1;

        }
        .panel-primary>.panel-body
        {
            background-color: #EDEDED;
        }
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="row">
    <div class="col-md-6 col-sm-12 col-lg-6 col-md-offset-3">
        <div class="panel panel-primary">
            <div class="panel-heading">${details}
            </div>
            <div class="panel-body">
                <form action="/registration" method="post" >
                    <div class="form-group">
                        <label for="login">${login} *</label>
                        <label for="login">${sessionScope.busy}</label>
                        <input id="login" name="login" class="form-control" type="text" data-validation="required">
                        <span id="error_login" class="text-danger"></span>
                    </div>
                    <div class="form-group">
                        <label for="password">${password} *</label>
                        <input id="password" name="password" class="form-control" type="password" data-validation="required">
                        <span id="error_password" class="text-danger"></span>
                    </div>
                    <div class="form-group">
                        <label for="name">${name}</label>
                        <input id="name" name="name" class="form-control" type="text">
                    </div>
                    <div class="form-group">
                        <label for="surname">${surname}</label>
                        <input id="surname" name="surname" class="form-control" type="text">
                    </div>
                    <div class="form-group">
                        <label for="age">${age} *</label>
                        <input id="age" name="age"  class="form-control" type="number" min="1" max="127" data-validation="required">
                        <span id="error_age" class="text-danger"></span>
                    </div>

                    <div class="form-group">
                        <label for="weight">${weight} *</label>
                        <input id="weight" name="weight"  class="form-control" type="number" min="10" max="300" data-validation="required">
                        <span id="error_weight" class="text-danger"></span>
                    </div>

                    <div class="form-group">
                        <label for="height">${height} *</label>
                        <input id="height" name="height"  class="form-control" type="number" min="30" max="300" data-validation="required">
                        <span id="error_height" class="text-danger"></span>
                    </div>

                    <div class="form-group">
                        <label for="gender">${gender} *</label>
                        <select name="gender" id="gender" class="form-control">
                            <option selected value="male">${male}</option>
                            <option value="female">${female}</option>
                        </select>
                        <span id="error_gender" class="text-danger"></span>
                    </div>

                    <div class="form-group">
                        <label for="wol">${wol} *</label>
                        <select name="wol" id="wol" class="form-control">
                            <option selected value="1.2">${wol1}</option>
                            <option value="1.375">${wol2}</option>
                            <option value="1.55">${wol3}</option>
                            <option value="1.725">${wol4}</option>
                            <option value="1.9">${wol5}</option>
                        </select>
                        <span id="error_wol" class="text-danger"></span>
                    </div>

                    <button id="submit" type="submit" value="submit" class="btn btn-primary center">${register}</button>

                </form>

            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
<script>
    $(document).ready(function(){
        $flag=1;
        $("#login").focusout(function(){
            if($(this).val()==''){
                $(this).css("border-color", "#FF0000");
                $('#submit').attr('disabled',true);
                $("#error_login").text("${have_enter} ${login}");
            }
            else
            {
                $(this).css({"border-color":"#2eb82e"});
                $('#submit').attr('disabled',false);
                $("#error_login").text("");

            }
        });

        $("#password").focusout(function(){
            if($(this).val()==''){
                $(this).css("border-color", "#FF0000");
                $('#submit').attr('disabled',true);
                $("#error_password").text("${have_enter} ${password}");
            }
            else
            {
                $(this).css({"border-color":"#2eb82e"});
                $('#submit').attr('disabled',false);
                $("#error_password").text("");

            }
        });

        $("#gender").focusout(function(){
            $(this).css("border-color", "#2eb82e");

        });
        $("#age").focusout(function(){
            if($(this).val()==''){
                $(this).css("border-color", "#FF0000");
                $('#submit').attr('disabled',true);
                    $("#error_age").text("${have_enter} ${age}");
            }
            else
            {
                $(this).css({"border-color":"#2eb82e"});
                $('#submit').attr('disabled',false);
                $("#error_age").text("");

            }
        });

        $("#weight").focusout(function(){
            if($(this).val()==''){
                $(this).css("border-color", "#FF0000");
                $('#submit').attr('disabled',true);
                $("#error_weight").text("${have_enter} ${weight2}");
            }
            else
            {
                $(this).css({"border-color":"#2eb82e"});
                $('#submit').attr('disabled',false);
                $("#error_weight").text("");

            }
        });

        $("#height").focusout(function(){
            if($(this).val()==''){
                $(this).css("border-color", "#FF0000");
                $('#submit').attr('disabled',true);
                $("#error_height").text("${have_enter} ${height}");
            }
            else
            {
                $(this).css({"border-color":"#2eb82e"});
                $('#submit').attr('disabled',false);
                $("#error_height").text("");

            }
        });

        <%--$("#wol").focusout(function(){--%>
            <%--if($(this).val()==''){--%>
                <%--$(this).css("border-color", "#FF0000");--%>
                <%--$('#submit').attr('disabled',true);--%>
                <%--$("#error_wol").text("${have_enter} ${wol}");--%>
            <%--}--%>
            <%--else--%>
            <%--{--%>
                <%--$(this).css({"border-color":"#2eb82e"});--%>
                <%--$('#submit').attr('disabled',false);--%>
                <%--$("#error_age").text("");--%>

            <%--}--%>
        <%--});--%>

        $( "#submit" ).click(function() {
            if($("#login" ).val()=='')
            {
                $("#login").css("border-color", "#FF0000");
                $('#submit').attr('disabled',true);
                $("#error_login").text("${have_enter} ${login}");
            }
            if($("#password" ).val()=='')
            {
                $("#password").css("border-color", "#FF0000");
                $('#submit').attr('disabled',true);
                $("#error_password").text("${have_enter} ${password}");
            }
            if($("#weight" ).val()=='')
            {
                $("#weight").css("border-color", "#FF0000");
                $('#submit').attr('disabled',true);
                $("#error_weight").text("${have_enter} ${weight2}");
            }
            if($("#age" ).val()=='')
            {
                $("#age").css("border-color", "#FF0000");
                $('#submit').attr('disabled',true);
                $("#error_age").text("${have_enter} ${age}");
            }
            if($("#height" ).val()=='')
            {
                $("#height").css("border-color", "#FF0000");
                $('#submit').attr('disabled',true);
                $("#error_height").text("${have_enter} ${height}");
            }
        });

    });
</script>
</html>
