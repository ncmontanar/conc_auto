<%-- 
    Document   : chargeCustomer.jsp
    Created on : 16 sept. 2023, 17:40:42
    Author     : CamiloM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="components/header.jsp" %>
<%@include file="components/bodypremierepart.jsp" %>

<h1> Charger un nouveau client </h1>
<p> veuillez ingreser les informations nécessaires : </p>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
 
                    <div class="col-lg-7">
                        <div class="p-5">
                            
                            <!-- es el formulario el de debe llamar   -->

                            <form class="user" action="SvCustomer" method="POST">
                <!-- ** form-group row sirve para dar orden a las columnas : como esta agrupado el formulario -->

                                <div class="form-group "> 
                                                                        
                                    <div class="form-group">
                                      <label for="InputCodevoiture">customerNumber</label>
                                      <input type="text" class="form-control" id="customerNumberId" name="customerNumberId" aria-describedby="productlHelp" placeholder="customerNumber">
                                      <small id="productlHelp" class="form-text text-muted">Pensez à bien identifier ... .</small>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="InputNomVoiture">customerName</label>
                                        <input type="text" class="form-control" id="customerName" name="customerName" placeholder="customerName">
                                    </div>
                                    
                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">contactLastName</label>
                                      <input type="text" class="form-control" id="contactLastName" name="contactLastName" placeholder="contactLastName">
                                    </div>   
                                    
                                     <div class="form-group">
                                      <label for="formGroupExampleInput2">contactFirstName</label>
                                      <input type="text" class="form-control" id="contactFirstName" name="contactFirstName" placeholder="contactFirstName">
                                    </div>    
                                    
                                     <div class="form-group">
                                      <label for="formGroupExampleInput2">phone</label>
                                      <input type="text" class="form-control" id="phone" name="phone" placeholder="phone">
                                    </div> 
                                    
                                     <div class="form-group">
                                      <label for="formGroupExampleInput2">addressLine1</label>
                                      <input type="text" class="form-control" id="addressLine1" name="addressLine1" placeholder="addressLine1">
                                    </div>       
                                    
                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">addressLine2</label>
                                      <input type="text" class="form-control" id="addressLine2" name="addressLine2" placeholder="addressLine2">
                                    </div> 
                                    
                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">city</label>
                                      <input type="text" class="form-control" id="city" name="city" placeholder="city">
                                    </div>
                                    
                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">state</label>
                                      <input type="text" class="form-control" id="state" name="state" placeholder="state">
                                    </div>

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">postalCode</label>
                                      <input type="text" class="form-control" id="postalCode" name="postalCode" placeholder="postalCode">
                                    </div>
                                    
                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">country</label>
                                      <input type="text" class="form-control" id="country" name="country" placeholder="country">
                                    </div>

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">creditLimit</label>
                                      <input type="text" class="form-control" id="creditLimit" name="creditLimit" placeholder="creditLimit">
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
                                
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Enregistrer Client
                                </button>
                                </a>


<!--                                <a href="/SvCustomer" class="btn btn-primary btn-user btn-block">   
                                    Enregistrer Client
                                </a>-->
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