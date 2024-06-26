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
        <th>Action</th>
    </tr>

    </thead>
    <tbody>
    <c:forEach var="history" items="${historyList}">
        <tr>
            <td data-label="S.No">${history.id}</td>
            <td data-label="S.No">${history.title}</td>
            <td data-label="Age">${history.amount}</td>
            <td data-label="Age">${history.stutas}</td>
            <td data-label="Name">${history.description}</td>
            <td> <a class="" href="<c:url value="/admin/approve/${history.id}" />" >ACCEPT</a>
                <a class="" href="<c:url value="/admin/reject/${history.id}" />" > REJECT</a>  </td>


        </tr>
    </c:forEach>







    </tbody>
</table>

</body>
</html>