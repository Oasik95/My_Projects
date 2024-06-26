<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Profile Card</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Google Fonts -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container">
    <div class="row d-flex justify-content-center">
        <div class="col-md-10 mt-5 pt-5">
            <div class="row z-depth-3">
                <div class="col-sm-4 bg-info rounded-left">
                    <div class="card-block text-center text-white">
                        <i class="fas fa-users-tie fa-7x mt-5"></i>
                        <h2 class="font-weight-bold mt-4"> ${username}</h2>

                        <p>Web Designer</p><i class="far fa-edit fa-2x mb-4"></i>
                    </div>
                </div>
                <div class="col-sm-8 bg-white rounded-right">
                    <h3 class="mt-3 text-center">Information</h3>
                    <hr class="bg-primary mt-0 w-25">
                    <div class="row">
                        <div class="col-sm-6">
                            <p class="font-weight-bold">Email:</p>
                            <h6 class=" text-muted">${email}</h6>
                        </div>
                        <div class="col-sm-6">
                            <p class="font-weight-bold">UserName:</p>
                            <h6 class=" text-muted">${username}</h6>
                        </div>
                        <div class="col-sm-6">
                            <p class="font-weight-bold">Phone:</p>
                            <h6 class="text-muted">${phonenumber}</h6>
                        </div>
                        <div class="col-sm-6">
                            <p class="font-weight-bold">NID:</p>
                            <h6 class="text-muted">${nid}</h6>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6">
                            <p class="font-weight-bold">Date of Birth</p>
                            <h6 class="text-muted">${dob}</h6>
                        </div>
                        <div class="col-sm-2">
                            <p class="font-weight-bold">Gender</p>
                            <h6 class="text-muted">${gender}</h6>
                        </div>
                    </div>
                    <hr class="bg-primary">
                    <ul class="list-unstyled d-flex justify-content-center mt-4">
                        <li><a href="#!"><i class="fab fa-facebook-f px-3 h4 text-info"></i></a></li>
                        <li><a href="#!"><i class="fab fa-youtube px-3 h4 text-info"></i></a></li>
                        <li><a href="#!"><i class="fab fa-twitter px-3 h4 text-info"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

