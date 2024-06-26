<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Login</title>

    <!-- Custom fonts for this template-->

    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->

    <link href="<c:url value="/resources/styles/css/sb-admin-2.min.css" />" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                                    </div>
                                    <form  action="login"  class="users" method="post">
                                        <div class="form-group">
                                            <input required type="text" class="form-control form-control-users"
                                                id="exampleInputEmail" aria-describedby="emailHelp" name="username"
                                                placeholder="Enter UserName">
                                        </div>
                                        <div class="form-group">
                                            <input required type="password" class="form-control form-control-users"
                                                id="exampleInputPassword" placeholder="Password" name="password">
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">Remember
                                                    Me</label>
                                            </div>
                                        </div>
                                        <input type="submit" value=" Login" class="btn btn-primary btn-users btn-block">



                                        <hr>
                                        <a href="show" class="btn btn-google btn-users btn-block">
                                            <i class="fab fa-google fa-fw"></i> Create an Account as entrepreneur
                                        </a>
                                        <a  href="<c:url value="/investor/show" />"  class="btn btn-facebook btn-users btn-block">
                                            <i class="fab fa-facebook-f fa-fw"></i> Create an Account as Investor
                                        </a>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="resetpass">Forgot Password?</a>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

    <!-- Bootstrap core JavaScript-->


    <!-- Custom scripts for all pages-->
    <script src="<c:url value="/resources/javascript/js/sb-admin-2.min.js" />"></script>

</body>

</html>