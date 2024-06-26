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
        <th>SERIAL</th>
        <th>TITLE</th>
        <th>AMOUNT</th>
        <th>STUTAS</th>
        <th>DISCRIPTION</th>
    </tr>

    </thead>
    <tbody>
    <c:forEach var="List" items="${InvestList}">
        <tr>
            <td data-label="S.No">${List.id}</td>
            <td data-label="S.No">${List.title}</td>
            <td data-label="Age">${List.amount}</td>
            <td data-label="Age">${List.stutas}</td>
            <td data-label="Name">${List.description}</td>


        </tr>
    </c:forEach>







    </tbody>
</table>

</body>
</html>