<%-- 
    Document   : chargeCustomer.jsp
    Created on : 16 sept. 2023, 17:40:42
    Author     : CamiloM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title>Nouveau Client</title> 

<%@include file="components/header.jsp" %>
<%@include file="components/bodypremierepart.jsp" %>

<h3> Charger un nouveau client </h3>
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

                                <div class="form-group "> 

<!--                                <div class="form-group">
                                      <label for="InputCodevoiture">customerNumber</label>
                                      <input type="text" class="form-control" id="customerNumberId" name="customerNumberId" aria-describedby="productlHelp" placeholder="customerNumber">
                                      <small id="productlHelp" class="form-text text-muted">Pensez à bien identifier ... .</small>
                                    </div>-->

                                    <div class="form-group">
                                        <label for="InputNomCustomer">Nom complet du client - pour contact :</label>
                                        <input type="text" class="form-control" id="customerNameId" name="customerNameId" placeholder="ie.Dupont Marie Chantal">
                                        <small id="customerNameHelp" class="form-text text-muted">Pensez à bien identifier Nom et prenom</small>
                                    </div>

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Nom de famille</label>
                                      <input type="text" class="form-control" id="contactLastName" name="contactLastName" placeholder="ie. Dupont">
                                    </div>   

                                     <div class="form-group">
                                      <label for="formGroupExampleInput2">Nom du Client </label>
                                      <input type="text" class="form-control" id="contactFirstName" name="contactFirstName" placeholder="ie. Marie Chantal">
                                    </div>    

                                     <div class="form-group">
                                      <label for="formGroupExampleInput2">Téléphone</label>
                                      <input type="text" class="form-control" id="phone" name="phone" placeholder="06 12 34 56 78">
                                    </div> 

                                     <div class="form-group">
                                      <label for="formGroupExampleInput2">Adresse principale</label>
                                      <input type="text" class="form-control" id="addressLine1" name="addressLine1" placeholder="">
                                    </div>       

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Complement d-Adresse</label>
                                      <input type="text" class="form-control" id="addressLine2" name="addressLine2" placeholder="">
                                    </div> 

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Ville</label>
                                      <input type="text" class="form-control" id="city" name="city" placeholder="ie. Paris">
                                    </div>

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Département</label>
                                      <input type="text" class="form-control" id="state" name="state" placeholder="">
                                    </div>

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Code Postale</label>
                                      <input type="text" class="form-control" id="postalCode" name="postalCode" placeholder="">
                                    </div>

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Pays</label>
                                      <input type="float" class="form-control" id="country" name="country" placeholder="ie. FRA">
                                      <small id="countryHelp" class="form-text text-muted">Pensez à bien identifier utiliser les 3 premieres lettres du pays</small>
                                    </div>

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Plafon du credit client en €</label>
                                      <input type="float" value="0" step="0.01" class="form-control" id="creditLimit" name="creditLimit" placeholder="150.5">
                                    </div>

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Chargé de Client</label>
                                      <input type="number" class="form-control" id="salesRepEmployeeNumberId" name="salesRepEmployeeNumberNm" placeholder="ie. 101">
                                    </div>


                                    <hr>
                                </div>

                                <!--ici on ajoute les liens avc les lines de produit et les listes de ordres-->

                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Enregistrer Client
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