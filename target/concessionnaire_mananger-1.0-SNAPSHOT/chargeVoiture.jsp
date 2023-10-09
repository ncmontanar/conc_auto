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
                            
                            <!-- es el formulario el de debe llamar   -->
                            <form class="user" action="SvProduct" method="POST">

                                <div class="form-group " > 
                                    
                                    <div class="form-group "> 
                                                                        
<!--                                  <div class="form-group">
                                      <label for="InputCodevoiture">Code de l'unité - voiture</label>
                                      <input type="text" class="form-control" id="productCodeId" name="productCodeId" aria-describedby="productlHelp" placeholder="Saisissez le code du produit">
                                      <small id="productlHelp" class="form-text text-muted">Pensez à bien identifier ... .</small>
                                    </div>-->
                                    
                                    <div class="form-group">
                                        <label for="InputNomVoiture">Nom de l'unité - voiture</label>
                                        <input type="text" class="form-control" id="productNameId" name="productNameName" placeholder="ie. 1952 Alpine Renault 1300">
                                        <small id="productlHelp" class="form-text text-muted">Pensez à bien identifier  le produit... .</small>
                                    </div>

                                    <div class="form-group">
                                        <label for="InputNomVoiture">Ligne du produit</label>
                                        <input type="text" class="form-control" id="productLineId" name="productLineName" placeholder="">
                                    </div>
                                    
                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Taille</label>
                                      <input type="text" class="form-control" id="productScaleId" name="productScale" placeholder="">
                                    </div>   
                                    
                                     <div class="form-group">
                                      <label for="formGroupExampleInput2">Fournisseur</label>
                                      <input type="text" class="form-control" id="productVendorid" name="productVendor" placeholder="ie. Classic Metal Creations">
                                    </div>    
                                    
                                     <div class="form-group">
                                      <label for="formGroupExampleInput2">Description du produit</label>
                                      <input type="text" class="form-control" id="productDescriptionid" name="productDescription" placeholder="">
                                    </div> 
                                    
                                     <div class="form-group">
                                      <label for="formGroupExampleInput2">Stock disponible</label>
                                      <input type="text" class="form-control" id="quantityInStockid" name="quantityInStock" placeholder="">
                                    </div>       
                                    
                                    <div class="form-group">
                                      <label for="formGroupExampleInput3">Prix d'achat</label>
                                      <input type="float" value="0" step="0.01" class="form-control" id="buyPriceId" name="buyPrice" placeholder="en €">
                                      <small id="productlHelp" class="form-text text-muted">Pour les prix non fermés, pensez à utiliser le point comme séparatur</small>
                                    </div> 
                                    
                                    <div class="form-group">
                                      <label for="formGroupExampleInput4">Prix de vente conseillé</label>
                                      <input type="float" value="0" step="0.01" class="form-control" id="MSRPId" name="MSRP" placeholder="en €">
                                       <small id="productlHelp" class="form-text text-muted">Pour les prix non fermés, pensez à utiliser le point comme séparatur</small>
                                    </div>
                                    <hr>

                                </div>
                                
                                <!--ici on ajoute les liens avc les lines de produit et les listes de ordres-->
                                
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Enregistrer Unité - Voiture
                                </button>

                                <hr>
                            </form>
                            <hr>
                            
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