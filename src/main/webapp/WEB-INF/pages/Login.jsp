<%--
  Created by IntelliJ IDEA.
  User: Anh Tu Nguyen
  Date: 9/14/2022
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="shortcut icon" type="x-icon" href="/images/favicon.ico">
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="/styles/style.css">
  <title>Planecor Management</title>
  <script>
    $("#submitForm").click(function() {
      alert("Registration Successfully.");
    });
  </script>
</head>
<body>

<section class="tri-header">
  <nav>
    <a href="/home"><img src="/images/High Resolution Logo.png"></a>
    <div class="nav-links">
      <ul>
        <li><a href="/home">Home</a></li>
        <li><a href="/login">Login</a></li>
      </ul>
    </div>
  </nav>
  <div class="login-page">
    <div class="form">

      <f:form class="register-form" action="/register/save" modelAttribute="Login">
        <f:input path = "firstName" placeholder = "First Name"/>
        <f:errors path = "firstName"/>
        <f:input path = "lastName" placeholder = "Last Name"/>
        <f:errors path = "lastName"/>
        <f:input path = "email" placeholder = "Email"/>
        <f:errors path = "email"/>
        <f:input path = "password" cssClass = "form-control" placeholder = "Password" type = "password"/>
        <f:errors path = "password"/>
        <button id="submitForm" type = "submit">Register</button>
        <p class="message">Already Registered? <a href="#">Login</a>
        </p>
      </f:form>
      <f:form action="validatelogin" class="login-form" modelAttribute="Login">
        <f:input path = "email" placeholder="Email"/>
        <f:errors path = "email"/>
        <f:input path = "password" placeholder="Password" type = "password"/>
        <f:errors path = "password"/>
        <input type = "submit" value = "Login"/>

        <p class="message">Not Registered? <a href="#">Register</a>
        </p>
      </f:form>
      <a:out value="${msg}"></a:out>
    </div>
  </div>
  <script src='https://code.jquery.com/jquery-3.6.1.min.js
        '></script>
  <script>
    $('.message a').click(function(){
      $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
    });
  </script>
</section>
</body>
</html>