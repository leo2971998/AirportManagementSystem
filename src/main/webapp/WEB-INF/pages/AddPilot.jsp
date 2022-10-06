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
    <f:form class="hangar-form" action="/addpilot/create" modelAttribute="Pilot" id ="form1">
        <h1 class="hangar-title">Pilot:</h1>
        <div class="texts">
            <div class="divrow">
                <div class="column" style="background-color:#a76d6d;">
                    <table>
                        <tr>
                            <th>Social Security Number</th>
                            <th><f:input path="ssNo"/></th>
                            <th><f:errors path="ssNo"/></th>
                        </tr>
                        <tr>
                            <th>Pilot Name</th>
                            <th><f:input path="PilotName"/></th>
                            <th><f:errors path="PilotName"/></th>
                        </tr>
                        <tr>
                            <th>License Number</th>
                            <th><f:input path="licenseNo"/></th>
                            <th><f:errors path="licenseNo"/></th>
                        </tr>
                        <tr>
                            <th>Date of Birth</th>
                            <th><f:input path="Dob" type="text" id="datepicker" name = "datepicker"/></th>
                            <th><f:errors path="Dob"/></th>
                        </tr>
                        <tr>
                            <th>Gender</th>
                            <th>
                                <f:select path="Gender" id="Gender" cssStyle="padding: 5px;width: 182px">
                                    <f:option value="Male" label="Male"/>
                                    <f:option value="Female" label="Female"/>
                                </f:select>
                            </th>
                            <th><f:errors path="Gender"/></th>
                        </tr>
                        <tr>
                            <th>Mobile Number</th>
                            <th><f:input path="mobileNo"/></th>
                            <th><f:errors path="mobileNo"/></th>
                        </tr>
                        <tr>
                            <th>Email</th>
                            <th><f:input path="email"/></th>
                            <th><f:errors path="email"/></th>
                        </tr>
                        <tr>
                            <th>House Number</th>
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
                            <th>Plane Id</th>
                            <th>
                                <f:select path="airplaneId" name = "airplaneId">
                                    <f:option value="" disabled="true" selected = "true">Select</f:option>
                                    <a:forEach var = "a" items = "${AList}">
                                        <f:option value="${a.planeId}">${a.planeId}</f:option>
                                    </a:forEach>
                                </f:select>
                            </th>
                        </tr>
                        <tr>
                            <th>Plane Name</th>
                            <th>${AP.planeName}</th>
                            <th><td><input type="submit" id = "fetch" value="Fetch" formaction="getairplanebyid" hidden="hidden"></td></th>
                        </tr>
                        <tr>
                            <th>Manufacturer Name</th>
                            <th>${AP.manufacturerName}</th>
                        </tr>
                        <tr>
                            <td>
                                <button type="submit" class="btn btn-success">Add Pilot</button>
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
    <script>
        $('#form1 select').on('change', function() {
            document.getElementById('fetch').click();
        });
    </script>
</section>
</body>
</html>
