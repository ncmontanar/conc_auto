<%-- 
    Document   : editEmployee.jsp
    Created on : 11 oct. 2023, 12:15:41
    Author     : a895279
--%>

<%@page import="models.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="components/header.jsp" %>
<%@include file="components/bodypremierepart.jsp" %>

<h3> Modification et mise à jour d'un collaborateur </h3>

<!-- 5.6.4 amener la session complète :  vient de SvEditEmployee = misession.setAttribute(" "); -->
<%Employee emply = (Employee)request.getSession().getAttribute("emplyEdition");%>


<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-7">
                        <div class="p-5">
                            <!--Emp_5.6.5  ceci est le forrmulaire  des infos à modifier par doPost en SvEditEmployee -->
                            <form class="user" action="SvEditEmployee" method="POST">

                                <div class="form-group "> 

                                <div class="form-group">
                                      <label for="InputCodeEmployee">ID de l'employee</label>
                                      <input type="text" class="form-control" id="emploNumberId" name="emploNumberName" aria-describedby="productlHelp" placeholder="" readonly="readonly" value="<%=emply.getEmployeeNumber()%>">
                                      <small id="productlHelp" class="form-text text-muted">Pensez à bien identifier ... .</small>
                                    </div>

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Nom de famille</label>
                                      <input type="text" class="form-control" id="emploLastNameId" name="empLastNameNmEd" placeholder="ie. Chanal" value="<%=emply.getLastName()%>">
                                    </div>   

                                     <div class="form-group">
                                      <label for="formGroupExampleInput2">Prenom de l'employee </label>
                                      <input type="text" class="form-control" id="empFirstNameId" name="empFirstNameNmEd" placeholder="ie. Lucy" value="<%=emply.getFirstName()%>">
                                    </div>    

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Extention</label>
                                      <input type="text" class="form-control" id="empExtentionId" name="empExtentionNmEd" placeholder="" value="<%=emply.getExtension()%>">
                                    </div>

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Adresse électronique @</label>
                                      <input type="text" class="form-control" id="empMailaddresslId" name="empMailaddresslNmEd" placeholder="nom@autofure.com" value="<%=emply.getEmail()%>">
                                    </div>       

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Poste</label>
                                      <input type="text" class="form-control" id="empPosteId" name="empPosteNmEd" placeholder="" value="<%=emply.getJobTitle()%>">
                                    </div>

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Agence</label>
                                      <input type="text" class="form-control" id=empOfficeCodeId" name="empOfficeCodeNmEd" placeholder="" value="<%=emply.getOfficeCode() %>">
                                    </div> 

                                    <div class="form-group">
                                      <label for="formGroupExampleInput2">Responsable</label>
                                      <input type="text" class="form-control" id="empReportsToId" name="empReportsToNmEd" placeholder="" value="<%=emply.getReportsTo()%>">
                                    </div> 

                                    <hr>
                                </div>

                                <!--ici on ajoute les liens avc les lines de produit et les listes de ordres-->

                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Enregistrer les modificatoins pour le Colaborateur
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