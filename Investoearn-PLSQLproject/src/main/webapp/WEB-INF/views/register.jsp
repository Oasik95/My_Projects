<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Register</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->

    <link href="<c:url value="/resources/styles/css/sb-admin-2.min.css" />" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                            </div>
                            <form action="submit" modelAttribute="entrepreneur" method="post" class="users">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input required pattern="[a-zA-Z\-]+$" type="text" class="form-control form-control-users" id="exampleFirstName"
                                                placeholder="First Name" name="firstname">
                                    </div>
                                    <div class="col-sm-6">
                                        <input required pattern="[a-zA-Z\-]+$" type="text" class="form-control form-control-users" id="exampleLastName"
                                                 placeholder="Last Name" name="lastname">

                                    </div>
                                    <div class="col-sm-6">
                                        <input required pattern="[a-zA-Z\-]+$" type="text" class="form-control form-control-users" id="userName"
                                                 placeholder="UserName" name="username">
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-control form-control-users">

                                            <label>Gender</label>
                                            <label class="radio-inline"> <input type="radio"  name="gender" value="Male">Male</label>
                                            <label class="radio-inline"><input type="radio" name="gender" value="Female">Female</label>
                                        <label class="radio-inline"><input type="radio" name="gender" value="Others">others</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input required pattern="[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" type="email" class="form-control form-control-users" id="exampleInputEmail"
                                        placeholder="Email Address" name="email">
                                </div>
                                <div class="form-group">
                                    <input required  type="text" class="form-control form-control-users" id="exampleInputphonenumber"
                                           placeholder="PhoneNumber" name="phonenumber">
                                </div>
                                <div class="form-group">
                                    <input required  type="text" class="form-control form-control-users" id="NID"
                                           placeholder="NID" name="nid">
                                </div>
                                <div class="form-group">
                                    <input required type="date" class="form-control form-control-users" id="dob"
                                           placeholder="DateofBirth" name="dob">
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input required   type="password" class="form-control form-control-users"
                                            id="exampleInputPassword" placeholder="Password" name="password">
                                    </div>
                                    <div class="col-sm-6">
                                        <input required type="password" class="form-control form-control-users"
                                            id="exampleRepeatPassword" placeholder="Repeat Password" name="repass">

                                    </div>
                                </div>
                                <input type="submit" value=" Register Account" class="btn btn-primary btn-users btn-block">


                                <hr>
                                <a href="index.html" class="btn btn-google btn-users btn-block">
                                    <i class="fab fa-google fa-fw"></i> Register with Google
                                </a>
                                <a href="index.html" class="btn btn-facebook btn-users btn-block">
                                    <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                                </a>
                            </form>
                            <hr>
                            <div class="text-center">

                            </div>
                            <div class="text-center">
                                <a class="small" href="login">Already have an account? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->

    <script src="<c:url value="/resources/javascript/js/sb-admin-2.min.js" />"></script>


</body>


</html>

