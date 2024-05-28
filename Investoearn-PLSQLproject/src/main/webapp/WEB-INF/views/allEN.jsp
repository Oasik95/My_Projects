<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Responsive Table</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/styles/css/style.css" />" rel="stylesheet">

</head>

<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>FIRST_NAME</th>
        <th>LAST_NAME</th>
        <th>USER_NAME</th>
        <th>GENDER</th>
        <th>EMAIL</th>
        <th>PHONE_NUMBER</th>
        <th>NID</th>
        <th>DOB</th>

    </tr>

    </thead>
    <tbody>
    <c:forEach var="EN" items="${ENList}">
        <tr>
            <td data-label="S.No">${EN.id}</td>
            <td data-label="S.No">${EN.firstname}</td>
            <td data-label="Age">${EN.lastname}</td>
            <td data-label="Age">${EN.username}</td>
            <td data-label="Name">${EN.gender}</td>
            <td data-label="Name">${EN.email}</td>
            <td data-label="Name">${EN.phonenumber}</td>
            <td data-label="Name">${EN.nid}</td>
            <td data-label="Name">${EN.dob}</td>



        </tr>
    </c:forEach>







    </tbody>
</table>

</body>
</html>