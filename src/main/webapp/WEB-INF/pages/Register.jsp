<%--
  Created by IntelliJ IDEA.
  User: Anh Tu Nguyen
  Date: 9/13/2022
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Please sign in</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet"
          crossorigin="anonymous" />
    <script>
        $("#submitForm").click(function() {
            alert("Registration Successfully.");
        });
    </script>
</head>

<body>
<div class="container">
    <f:form class="form-signin" action="/register/save" modelAttribute="Login">
        <h2 class="form-signin-heading">Register</h2>
        <p>
            <label for="firstname" class="sr-only">First Name</label>
            <f:input path = "firstName" id="firstname" cssClass ="form-control" placeholder = "First Name"/>
            <f:errors path = "firstName"/>
        </p>
        <p>
            <f:input path = "lastName" id="lastname" cssClass ="form-control" placeholder = "Last Name"/>
            <f:errors path = "lastName"/>
        </p>
        <p>
            <f:input path = "email" id="email" cssClass ="form-control" placeholder = "Email"/>
            <f:errors path = "email"/>
        </p>
        <p>
            <f:input path = "password" id="password" cssClass = "form-control" placeholder = "Password" type = "password"/>
            <f:errors path = "password"/>
        </p>
        <p>
            <f:select path = "appUserRole" id="appUserRole" cssClass ="form-control" type = "" cssStyle="padding: 8px">
                <f:option value="ADMIN" label="ADMIN"/>
                <f:option value="MANAGER" label="MANAGER"/>
            </f:select>
            <f:errors path = "appUserRole"/>
        </p>
        <button class="btn btn-lg btn-primary btn-block" id="submitForm" type = "submit">Register</button>
    </f:form>
    <a:out value="${msg}"></a:out>
</div>
</body>

</html>
