<%-- 
    Document   : chargeEmployee.jsp
    Created on : 10 oct. 2023, 10:48:13
    Author     : a895279
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title>Nouveau Collaborateur</title> 

<%@include file="components/header.jsp" %>
<%@include file="components/bodypremierepart.jsp" %>

<h3> Nouveau collaborateur </h3>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-7">
                        <div class="p-5">

                            <!--Emp_5.1. 1 ceci est le forrmulaire  d'entree à connecter à doPost en SvEmployee -->
                            <form class="user" action="SvEmployee" method="POST">

                                <div class="form-group "> 

                                    <div class="form-group">
                                      <label for="InputCodeEmployee">ID de l'employee</label>
                                      <input type="text" class="form-control" id="emploNumberId" name="emploNumberName" aria-describedby="productlHelp" placeholder="" readonly="readonly">
                                      <small id="productlHelp" class="form-text text-muted">Pensez à bien identifier ... .</small>
                                    </div>

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Nom de famille</label>
                                      <input type="text" class="form-control" id="emploLastNameId" name="empLastNameNm" placeholder="ie. Chanal">
                                    </div>   

                                     <div class="form-group">
                                      <label for="formGroupExampleInput2">Prenom de l'employee </label>
                                      <input type="text" class="form-control" id="empFirstNameId" name="empFirstNameNm" placeholder="ie. Lucy">
                                    </div>    

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Extention</label>
                                      <input type="text" class="form-control" id="empExtentionId" name="empExtentionNm" placeholder="">
                                    </div>

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Adresse électronique @</label>
                                      <input type="text" class="form-control" id="empMailaddresslId" name="empMailaddresslNm"ie. placeholder="nom@autofure.com">
                                    </div>       

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Poste</label>
                                      <input type="text" class="form-control" id="empPosteId" name="empPosteNm" placeholder="">
                                    </div>

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Agence</label>
                                      <input type="text" class="form-control" id=empOfficeCodeId" name="empOfficeCodeNm" placeholder="">
                                    </div> 

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Responsable</label>
                                      <input type="text" class="form-control" id="empReportsToId" name="empReportsToNm" placeholder="">
                                    </div> 

                                    <hr>
                                </div>

                                <!--ici on ajoute les liens avc les lines de produit et les listes de ordres-->

                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Enregistrer Colaborateur
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