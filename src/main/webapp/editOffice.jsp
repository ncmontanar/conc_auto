<%-- 
    Document   : editOffice.jsp
    Created on : 8 oct. 2023, 13:45:26
    Author     : a895279
--%>

<%@page import="models.Office"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title>Edition Agence</title> 


<%@include file="components/header.jsp" %>
<%@include file="components/bodypremierepart.jsp" %>


<!--Off_4.17 Creer la session complète :  officEdition -->
<% Office offic = (Office)request.getSession().getAttribute("officEdition");%>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
 
                    <div class="col-lg-7">
                        <div class="p-5">
                            
                            <!--Off.4.1 (4.14) es el formulario el de debe llamar   -->
                            <form class="user" action="SvEditOffice" method="POST">
                                
                                <div class="form-group " > 
                                   
                                     <div class="form-group ">
                                        <div class="text-center">
                                            <h4 class="h4 text-gray-900 mb-4">Mise à jour informations pour une agence :</h4>
                                        </div>       
                                        <hr>

                                        <div class="form-group">
                                            <label for="InputAgence">Code Agence</label>
                                            <input type="text" class="form-control" id="codeAgenceIdMod" name="codeAgenceNameNnMod" placeholder="" readonly="readonly" value="<%=offic.getOfficeCode()%>"> 
                                        </div>
                                        
                                        
                                        <div class="form-group">
                                            <label for="InputAgence">Ville</label>
                                            <input type="text" class="form-control" id="villeAgenceNameIdMod" name="villeAgenceNameNnMod" placeholder="ie. Paris"  value="<%=offic.getCity()%>">
                                        </div>

                                        <div class="form-group">
                                            <label for="InputAgence">Téléphone</label>
                                            <input type="text" class="form-control" id="telAgenceIdMod" name="telAgenceNnMod" placeholder="ie. + code 12 34 56 78 9"  value="<%=offic.getPhone()%>">
                                        </div>

                                        <div class="form-group">
                                            <label for="InputAgence">Adresse Principale</label>
                                            <input type="text" class="form-control" id="addresAgenceIdMod" name="addresAgenceNnMod" placeholder=""  value="<%=offic.getAddressLine1()%>">
                                        </div>        

                                        <div class="form-group">
                                            <label for="InputAgence">Adresse Comp</label>
                                            <input type="text" class="form-control" id="addresCompAgenceIdMod" name="addresCompAgenceNnMod" placeholder=""  value="<%=offic.getAddressLine2()%>">
                                        </div>    

                                        <div class="form-group">
                                            <label for="InputAgence">Departement</label>
                                            <input type="text" class="form-control" id="depAgenceIdMod" name="depAgenceNnMod" placeholder=""  value="<%=offic.getState()%>">
                                        </div>    

                                        <div class="form-group">
                                            <label for="InputAgence">Pays</label>
                                            <input type="text" class="form-control" id="paysAgenceIdMod" name="paysAgenceNnMod" placeholder=""  value="<%=offic.getCountry()%>">
                                        </div>    

                                        <div class="form-group">
                                            <label for="InputAgence">Code Postal</label>
                                            <input type="text" class="form-control" id="cpAgenceIdMod" name="cpAgenceNnMod" placeholder="" value="<%=offic.getPostalCode()%>">
                                        </div>    

                                        <div class="form-group">
                                            <label for="InputAgence">Région</label>
                                            <input type="text" class="form-control" id="regAgenceIdMod" name="regAgenceNnMod" placeholder=""  value="<%=offic.getTerritory()%>">
                                        </div>
                                    
                                        
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Enregistrer Modifications Agence
                                </button>
                                </a>
                                
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