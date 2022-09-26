<%--
  Created by IntelliJ IDEA.
  User: Anh Tu Nguyen
  Date: 9/19/2022
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Planecor Management</title>
</head>
<body>

<section class="tri-header">
    <nav>
        <a href="/validatelogin"><img src="/images/High Resolution Logo.png"></a>
        <div class="nav-links">
            <ul>
                <li><a href="/validatelogin">Home</a></li>
                <li><a href="/addhanger">Add Hangar</a></li>
                <li><a href="/addplane">Add Plane</a></li>
                <li><a href="/addpilot">Add Pilot</a></li>
                <li><a href="/register">Give Access</a></li>
                <li><a href="/">Log Out</a></li>
            </ul>
        </div>
    </nav>
    <f:form class="hangar-form" action="/addplane/create" modelAttribute="Airplane">
        <h1 class="hangar-title">Plane:</h1>
        <div class="texts">
            <div class="divrow">
                <div class="column" style="background-color:#a76d6d;">
                    <table>
                        <tr>
                            <th>Registration No</th>
                            <th><f:input path="regNo"/></th>
                            <th><f:errors path="regNo"/></th>
                        </tr>
                        <tr>
                            <th>Manufacturer Name</th>
                            <th><f:input path="ManufacturerName"/></th>
                            <th><f:errors path="ManufacturerName"/></th>
                        </tr>
                        <tr>
                            <th>Model No</th>
                            <th><f:input path="ModelNo"/></th>
                            <th><f:errors path="ModelNo"/></th>
                        </tr>
                        <tr>
                            <th>Plane Name</th>
                            <th><f:input path="PlaneName"/></th>
                            <th><f:errors path="PlaneName"/></th>
                        </tr>
                        <tr>
                            <th>Capacity</th>
                            <th><f:input path="Capacity" type = "number"/></th>
                            <th><f:errors path="Capacity"/></th>
                        </tr>
                        <tr>
                            <th>Email</th>
                            <th><f:input path="email"/></th>
                            <th><f:errors path="email"/></th>
                        </tr>
                        <tr>
                            <th>House No</th>
                            <th><f:input path="HouseNo"/></th>
                            <th><f:errors path="HouseNo"/></th>
                        </tr>
                        <tr>
                            <th>Address</th>
                            <th><f:input path="Address"/></th>
                            <th><f:errors path="Address"/></th>
                        </tr>
                        <tr>
                            <th>City</th>
                            <th><f:input path="City"/></th>
                            <th><f:errors path="City"/></th>
                        </tr>
                        <tr>
                            <th>State</th>
                            <th><f:input path="State"/></th>
                            <th><f:errors path="State"/></th>
                        </tr>
                        <tr>
                            <th>Country</th>
                            <th><f:input path="Country"/></th>
                            <th><f:errors path="Country"/></th>
                        </tr>
                        <tr>
                            <th>Pin Code</th>
                            <th><f:input path="PinCode"/></th>
                            <th><f:errors path="PinCode"/></th>
                        </tr>
                        <tr>
                            <td>
                                <button type="submit" class="btn btn-success">Add Plane</button>
                            </td>
                            <td>
                                <button type="reset" class="btn btn-danger" value="Reset">Reset</button>
                            </td>
                        </tr>
                        <a:out value="${msg}"></a:out>
                    </table>
                </div>
            </div>
        </div>
        </div>
    </f:form>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#datepicker").datepicker({dateFormat: 'dd/mm/yy'});
        });
    </script>
</section>
</body>
</html>
