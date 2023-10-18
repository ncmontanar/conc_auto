<%-- 
    Document   : voirEmployee.jsp
    Created on : 10 oct. 2023, 15:45:32
    Author     : a895279
--%>


<%@page import="models.Employee"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<title>Liste Employees</title>


<%@include file="components/header.jsp" %>
<%@include file="components/bodypremierepart.jsp" %>
                
                <!-- Emp_5.3.1 Creation du voirEmployee.jsp -->
                <!-- Begin Page Content -->
                <div class="container-fluid">
                    
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800"></h1>
<!--                    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p>-->

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Collaborateurs Actifs :</h6>
                        </div>
                        
                        <div class="card-body" id="loadContent">
                            <div class="table-responsive-xl table-responsive-lg table-responsive-md table-responsive-sm table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0"> <!--attentionà l_id de la table-->
                                    <thead>
                                        <tr>
                                            <th>ID Collaborateur</th>                                            
                                            <th>Nom Collaborateur</th> 
                                            <th>Prenom</th>
                                            <th>Extension</th>
                                            <th>Adresse Electronique</th>
                                            <th>Poste</th>
                                            <th>Agence</th>
                                            <th>Responsable</th>
                                            <th style="width: 210px">Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>ID Collaborateur</th>                                            
                                            <th>Nom Collaborateur</th> 
                                            <th>Prenom</th>
                                            <th>Extension</th>
                                            <th>Adresse Electronique</th>
                                            <th>Poste</th>
                                            <th>Agence</th>
                                            <th>Responsable</th>
                                            <th style="width: 210px">Accion</th>
                                        </tr>
                                    </tfoot>
                                    <!--/// 5.3.5 Ajouter les champs de la table Customer par lien java in tbody que vi-->
                                    <!--/// que viennent de  SvEmployee et SvEditEmployee -->
                                    
                                    <%
                                    List <Employee> listEmployeesAff = (List)request.getSession().getAttribute("listEmployeesAff");
                                    %>
                                    <tbody>
                                        <% for (Employee emply : listEmployeesAff){%>
                                        <tr>
                                            <td><%=emply.getEmployeeNumber()%></td>
                                            <td><%=emply.getLastName()%> </td>
                                            <td><%=emply.getFirstName() %> </td>
                                            <td><%=emply.getExtension() %> </td>
                                            <td><%=emply.getEmail() %> </td>
                                            <td><%=emply.getJobTitle()%> </td>
                                            <td><%=emply.getOfficeCode() %> </td>
                                            <td><%=emply.getReportsTo()%></td> 
                                            <!--boton elim (formu_1) + boton add (form_2)-->
                                            <td style="display:flex;width:230px;"> 
                                                
                                                 <!-- Empl_5.4.5. name="customerNameIdEdit" vient de editEmployee-->
                                                <form name="Editer" action="SvEditEmployee" method="GET"> <!-- Esto es para enviar codigo al Sevelet SvEditCustomer -->
                                                    <button type="submit" class="btn btn-primary btn-user btn-block"; style="margin-rigth: 5px;">
                                                        <i class="fas fa-solid fa-pencil-alt"></i> Editer
                                                    </button>
                                                <input type="hidden" name="emploNumberName" value="<%=emply.getEmployeeNumber()%>"> <!-- esto es para mandar el codigo al servelet ** name="id" fue cambiado por name="customerNumber" -->
                                                <!-- este name="id" le cambiamos el nombre  name="customerNameIdEdit" -->
                                                </form>       
                                                <!--name="employeeNumber" vient de SvSuppEmployee-->
                                                <!--Supprimer // name="blabla"  vient de SvSuppEmployee-->
                                                <form name="Supprimer" action="SvSuppEmployee" method="POST"> <!--Esto es para enviar codigo al Sevelet-->
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-left:5px;">
                                                        <i class="fas fa-solid fa-trash-alt"></i> Supprimer  
                                                    </button>
                                                    <input type="hidden" name="employeeNumber" value="<%=emply.getEmployeeNumber()%>"> <!-- esto es para mandar el codigo al servelet -->
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