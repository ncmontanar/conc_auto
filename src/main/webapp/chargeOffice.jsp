<%-- 
    Document   : chargeOffice.jsp
    Created on : 8 oct. 2023, 13:45:00
    Author     : a895279
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title>Nouvelle Agence</title> 

<%@include file="components/header.jsp" %>
<%@include file="components/bodypremierepart.jsp" %>

<h3> Ajouter une nouvelle agence au système</h3>
<p> Pensez à récuperer toutes les informations nécessaires avant de demarrer l'enregistrement: </p>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-7">
                        <div class="p-5">
                            
                            <!-- //Off_1.1 es el formulario el de debe llamar   -->
                            <form class="user" action="SvOffice" method="POST">
                                <div class="form-group " > 
                                    <div class="form-group ">
                                    
                                        <div class="text-center">
                                            <h4 class="h4 text-gray-900 mb-4">Agence</h4>
                                        </div>       
                                        <hr>
                                        
                                        <!-- office le id n-est pas automatique -->
                                        <div class="form-group">
                                            <label for="InputAgence">Code Agence</label>
                                            <input type="text" class="form-control" id="codeAgenceId" name="codeAgenceNameNn" placeholder="">
                                             <small id="productlHelp" class="form-text text-muted">Pensez à bien identifier le code précedent ...</small>
                                        </div>
                                        
                                        
                                        <div class="form-group">
                                            <label for="InputAgence">Ville</label>
                                            <input type="text" class="form-control" id="villeAgenceNameId" name="villeAgenceNameNn" placeholder="ie. Paris">
                                        </div>

                                        <div class="form-group">
                                            <label for="InputAgence">Téléphone</label>
                                            <input type="text" class="form-control" id="telAgenceId" name="telAgenceNn" placeholder="ie. + code 12 34 56 78 9">
                                        </div>

                                        <div class="form-group">
                                            <label for="InputAgence">Adresse Principale</label>
                                            <input type="text" class="form-control" id="addresAgenceId" name="addresAgenceNn" placeholder="">
                                        </div>        

                                        <div class="form-group">
                                            <label for="InputAgence">Adresse Comp</label>
                                            <input type="text" class="form-control" id="addresCompAgenceId" name="addresCompAgenceNn" placeholder="">
                                        </div>    

                                        <div class="form-group">
                                            <label for="InputAgence">Departement</label>
                                            <input type="text" class="form-control" id="depAgenceId" name="depAgenceNn" placeholder="">
                                        </div>    

                                        <div class="form-group">
                                            <label for="InputAgence">Pays</label>
                                            <input type="text" class="form-control" id="paysAgenceId" name="paysAgenceNn" placeholder="">
                                        </div>    

                                        <div class="form-group">
                                            <label for="InputAgence">Code Postal</label>
                                            <input type="text" class="form-control" id="cpAgenceId" name="cpAgenceNn" placeholder="">
                                        </div>    

                                        <div class="form-group">
                                            <label for="InputAgence">Région</label>
                                            <input type="text" class="form-control" id="regAgenceId" name="regAgenceNn" placeholder="">
                                        </div> 
                                        
                                        <hr>
                                        <button class="btn btn-primary btn-user btn-block" type="submit">
                                            Ajouter nouvelle Agence
                                        </button>
                                        <hr>

                                    </div>
                                </div>
                            </form>
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

<%@include file="components/piedfinale.jsp" %>