<%-- 
    Document   : loginError.jsp
    Created on : 4 oct. 2023, 14:13:49
    Author     : a895279
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login Erreur CA AutoFuture</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">
            <div class="col-xl-13 col-lg-15 col-md-12">  
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                                <img src="images/dealership.jpg" alt="alt"/>

                            
                            <!-- ici commence le formulaire de login -->               
                            <div class="col-lg-5">  
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Accès à la plataforme Autofuture!</h1>
                                    </div>
                                    
                                    <!-- ici commence le formaulaire re_login-->
                                    <form class="user" action="SvLogin" method="POST"> <!-- SvLogin aà creer -->
                                        
                                        <center>
                                            <h2> Nom d'utilisateur ou Mot de passe incorrect </h2>
                                        </center>
                                        <hr>
                                        <br>
                                        <br>
                                        <a href="login.jsp" class="btn btn-primary btn-user btn-block">
                                            Revenir à la page Login 
                                        </a>
                                    </form>
                                    <hr>

                                </div>
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
    <script src="js/sb-admin-2.min.js"></script>

</body>

</html>