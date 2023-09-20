<%-- 
    Document   : chargeVoiture.jsp : ajouter une voiuture au stock
    Created on : 16 sept. 2023, 
    Author     : CamiloM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="components/header.jsp" %>
<%@include file="components/bodypremierepart.jsp" %>

<h1> Charger une unité au Stock </h1>
<p> veuillez ingreser les nouveaux produits : </p>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
 
                    <div class="col-lg-7">
                        <div class="p-5">

                            <form class="user">

                                <div class="form-group "> 
                                                                        
                                    <div class="form-group">
                                      <label for="InputCodevoiture">Code de l'unité - voiture</label>
                                      <input type="text" class="form-control" id="productCode" aria-describedby="productlHelp" placeholder="Saisissez le code du produit">
                                      <small id="productlHelp" class="form-text text-muted">Pensez à bien identifier ... .</small>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="InputNomVoiture">Nom de l'unité - voiture</label>
                                        <input type="text" class="form-control" id="productName" placeholder="Saisissez le product Name">
                                    </div>
                                    
                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">productScale</label>
                                      <input type="text" class="form-control" id="productScale" placeholder="productScale">
                                    </div>   
                                    
                                     <div class="form-group">
                                      <label for="formGroupExampleInput2">productVendor</label>
                                      <input type="text" class="form-control" id="productVendor" placeholder="productVendor">
                                    </div>    
                                    
                                     <div class="form-group">
                                      <label for="formGroupExampleInput2">productDescription</label>
                                      <input type="text" class="form-control" id="productDescription" placeholder="productDescription">
                                    </div> 
                                    
                                     <div class="form-group">
                                      <label for="formGroupExampleInput2">quantityInStock</label>
                                      <input type="text" class="form-control" id="quantityInStock" placeholder="quantityInStock">
                                    </div>       
                                    
                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">buyPrice</label>
                                      <input type="text" class="form-control" id="buyPrice" placeholder="buyPrice">
                                    </div> 
                                    
                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">MSRP</label>
                                      <input type="text" class="form-control" id="MSRP" placeholder="MSRP">
                                    </div>
                                    <hr>
<!--                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user"
                                            id="exampleInputPassword" placeholder="Password">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            id="exampleRepeatPassword" placeholder="Repeat Password">
                                    </div>
                                </div>-->
                                
                                <!--ici on ajoute les liens avc les lines de produit et les listes de ordres-->


                                <a href="login.html" class="btn btn-primary btn-user btn-block">
                                    Enregistrer Unité - Voiture
                                </a>
                                <hr>
                            </form>
                            <hr>
                            
                            <!--A utiliser si besoin-->
                            
<!--                            <div class="text-center">
                                <a class="small" href="forgot-password.html">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="login.html">Already have an account? Login!</a>
                            </div>-->
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