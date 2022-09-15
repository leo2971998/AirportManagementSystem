<%--
  Created by IntelliJ IDEA.
  User: Anh Tu Nguyen
  Date: 9/14/2022
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<html>
<head>
    <title>Add Plane</title>
</head>
<body>
<f:form action="/addplane/create" modelAttribute="Airplane">
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
            <th><f:input path="Capacity"/></th>
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
            <td><input type="submit" value="Add Plane"></td>
            <td><input type="reset" value="Reset"></td>
        </tr>
    </table>
</f:form>
<a:out value="${msg}"></a:out>
</body>
</html>
