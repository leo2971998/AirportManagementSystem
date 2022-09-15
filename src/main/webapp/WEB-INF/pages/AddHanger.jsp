<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<html>
<head>
  <title>Add Hanger</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  <script>
    $(function () {
      $("#datepicker").datepicker({dateFormat: 'dd/mm/yy'});
    });
  </script>
</head>
<body>
<f:form action="/addhanger/create" modelAttribute="Hanger">
  <table>
    <tr>
      <th>Social Security Number</th>
      <th><f:input path="ssNo"/></th>
      <th><f:errors path="ssNo"/></th>
    </tr>
    <tr>
      <th>Manager Name</th>
      <th><f:input path="ManagerName"/></th>
      <th><f:errors path="ManagerName"/></th>
    </tr>
    <tr>
      <th>Hanger Location</th>
      <th><f:input path="HangerLocation"/></th>
      <th><f:errors path="HangerLocation"/></th>
    </tr>
    <tr>
      <th>Hanger Capacity</th>
      <th><f:input path="HangerCapacity" type = "number"/></th>
      <th><f:errors path="HangerCapacity"/></th>
    </tr>
    <tr>
      <th>Date of Birth</th>
      <th><f:input path="Dob" type="text" id="datepicker"/></th>
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
      <td><input type="submit" value="Add Pilot"></td>
      <td><input type="reset" value="Reset"></td>
    </tr>
  </table>
</f:form>
<a:out value="${msg}"></a:out>
</body>
</html>