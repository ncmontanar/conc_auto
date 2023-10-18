<%-- 
    Document   : voirOffice.jsp : fait les tables à afficher
    Created on : 8 oct. 2023, 13:48:32
    Author     : a895279
--%>

<%@page import="models.Office"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title>Liste Agences</title>


<%@include file="components/header.jsp" %>
<%@include file="components/bodypremierepart.jsp" %>

                <!-- Begin Page Content -->
<!--                <div class="container-fluid">  -->

                    <!-- Page Heading -->                 
                    <p class="mb-4"> Réseau des agences Autofuture</p>

                    <!-- DataTales (notre table agences)-->
                    <div class="card shadow mb-13">
                        
                        <div class="card-header py-6"> <!-- div class="card-header py-3"> -->
                            <h6 class="m-2 font-weight-bold text-primary">DataTables</h6>
                        </div>
                        <div class="card-body" id="loadContent">
                            <div class="table-responsive-xl table-responsive-lg table-responsive-md table-responsive-sm table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Code</th>                                            
                                            <th>Ville</th> 
                                            <th>Téléphone</th>
                                            <th>Adresse</th>
                                            <th>Adresse_Com</th>
                                            <th>Département</th>
                                            <th>Pays</th>
                                            <th>Code Postale</th>
                                            <th>Région</th>
                                            <th style="width: 210px">Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Code</th>                                     
                                            <th>Ville</th> 
                                            <th>Téléphone</th>
                                            <th>Adresse</th>
                                            <th>Adresse_Com</th>
                                            <th>Département</th>
                                            <th>Pays</th>
                                            <th>Code Postale</th>
                                            <th>Région</th>
                                           <th style="width: 210px">Action</th>
                                        </tr>
                                    </tfoot>
                                    <!--///Ajouter les champs de la table Office par lien java in tbody que-->
                                    <!--///Off_4.7 que viennent de SvOffice et SvEditOffice-->
                                    <%
                                     List<Office> listoffices = (List)request.getSession().getAttribute("listoffices");
                                    %>
                                    <tbody>
                                        <% for (Office offic : listoffices){%>
                                        <tr>
                                            <td><%=offic.getOfficeCode()%></td> 
                                            <td><%=offic.getCity()%></td>
                                            <td><%=offic.getPhone()%></td>
                                            <td><%=offic.getAddressLine1()%></td>
                                            <td><%=offic.getAddressLine2()%></td>
                                            <td><%=offic.getState()%></td>
                                            <td><%=offic.getCountry()%></td>
                                            <td><%=offic.getPostalCode()%></td>
                                            <td><%=offic.getTerritory()%></td>
                                            <td style="display:flex;width:230px;">

                                            <form name="Editer" action="SvEditOffice" method="GET"> <!-- Esto es para enviar codigo al Sevelet SvEditOffice-->
                                                <button type="submit" class="btn btn-primary btn-user btn-block"; style="margin-rigth: 1px;">
                                                    <i class="fas fa-solid fa-pencil-alt"></i> Editer
                                                </button>
                                            <input type="hidden" name="codeAgenceIdMod" value="<%=offic.getOfficeCode()%>"> <!-- esto es para mandar el codigo al servelet ** name="id" fue cambiado por name="customerNumber" -->
                                            <!--name="codeAgenceIdMod" vient de editOffice.jsp-->
                                            <!-- este name="id" le cambiamos el nombre  name="customerNameIdEdit" codeAgenceNameNnMod-->
                                            </form>   

                                            <!--Bt Supprimer -->
                                            <form name="Supprimer" action="SvSuppOffice" method="POST"> <!--Esto es para enviar codigo al Sevelet-->
                                                <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-left:1px;">
                                                    <i class="fas fa-solid fa-trash-alt"></i> Supprimer  
                                                </button>
                                                <input type="hidden" name="officeCode" value="<%=offic.getOfficeCode()%>"> <!-- esto es para mandar el codigo al servelet -->
                                            </form>

                                            </td> 
                                        </tr>

                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
            
<%@include file="components/piedfinale.jsp" %>