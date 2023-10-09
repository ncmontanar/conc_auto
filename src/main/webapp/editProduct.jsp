<%-- 
    Document   : editProduct
    Created on : 7 oct. 2023, 19:07:45
    Author     : a895279
--%>

<%@page import="models.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="components/header.jsp" %>
<%@include file="components/bodypremierepart.jsp" %>

<h3> Modification et mise à jour d'une unité dans le Stock </h3>

<!--amener la session complète :  vient de SvEditProduct = misession.setAttribute(" "); -->

<%Product pdrt =(Product)request.getSession().getAttribute("prodEdition");%>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
 
                    <div class="col-lg-7">
                        <div class="p-5">
                            
                            <!-- es el formulario el de debe llamar   -->
                            <!--  le parametre à passer dans le Sv est le name="" de chaque class  -->
                            <form class="user" action="SvEditProduit" method="POST">

                                <div class="form-group " > 
                                    
                                    <div class="form-group "> 
                                                                        
                                    <div class="form-group">
                                      <label for="InputCodevoiture">Code de l'unité - voiture</label>
                                      <input type="text" class="form-control" id="productCodeId" name="productCodeName" aria-describedby="productlHelp" placeholder="" readonly="readonly" value="<%=pdrt.getProductCode()%>">
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="InputNomVoiture">Nom de l'unité - voiture</label>
                                        <input type="text" class="form-control" id="productNameId" name="productNameNameEd" placeholder="ie. 1952 Alpine Renault 1300" value="<%=pdrt.getProductName()%>">
                                        <small id="productlHelp" class="form-text text-muted">Pensez à bien identifier  le produit... .</small>
                                    </div>

                                    <div class="form-group">
                                        <label for="InputNomVoiture">Ligne du produit</label>
                                        <input type="text" class="form-control" id="productLineId" name="productLineNameEd" placeholder="" value="<%=pdrt.getProductLine()%>">
                                    </div>
                                    
                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Taille</label>
                                      <input type="text" class="form-control" id="productScaleId" name="productScaleEd" placeholder="" value="<%=pdrt.getProductScale()%>">
                                    </div>   
                                    
                                     <div class="form-group">
                                      <label for="formGroupExampleInput2">Fournisseur</label>
                                      <input type="text" class="form-control" id="productVendorid" name="productVendorNameEd" placeholder="ie. Classic Metal Creations" value="<%=pdrt.getProductVendor()%>">
                                    </div>    
                                    
                                     <div class="form-group">
                                      <label for="formGroupExampleInput2">Description du produit</label>
                                      <input type="text" class="form-control" id="productDescriptionid" name="productDescriptionNameEd" placeholder="" value="<%=pdrt.getProductDescription()%>">
                                    </div> 
                                    
                                     <div class="form-group">
                                      <label for="formGroupExampleInput2">Stock disponible</label>
                                      <input type="text" class="form-control" id="quantityInStockid" name="quantityInStockNameEd" placeholder="" value="<%=pdrt.getQuantityInStock()%>" >
                                    </div>       
                                    
                                    <div class="form-group">
                                      <label for="formGroupExampleInput3">Prix d'achat</label>
                                      <input type="float" value="0" step="0.01" class="form-control" id="buyPriceId" name="buyPriceNameEd" placeholder="en €" value="<%=pdrt.getBuyPrice()%>">
                                      <small id="productlHelp" class="form-text text-muted">Pour les prix non fermés, pensez à utiliser le point comme séparatur</small>
                                    </div> 
                                    
                                    <div class="form-group">
                                      <label for="formGroupExampleInput4">Prix de vente conseillé</label>
                                      <input type="float" value="0" step="0.01" class="form-control" id="MSRPId" name="MSRPNameEd" placeholder="en €" value="<%=pdrt.getMSRP()%>">
                                       <small id="productlHelp" class="form-text text-muted">Pour les prix non fermés, pensez à utiliser le point comme séparatur</small>
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
                                   Enregistrer Edition - Mettre à jour Unité en stock
                                </button>
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