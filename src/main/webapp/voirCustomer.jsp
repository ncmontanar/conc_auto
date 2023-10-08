<%-- 
    Document   : voirCustomer
    Created on : 23 sept. 2023, 18:29:14
    Author     : a895279
--%>

<%@page import="models.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@include file="components/header.jsp" %>
<%@include file="components/bodypremierepart.jsp" %>

                <!-- Begin Page Content -->
                <div class="container-fluid">  

                    <!-- Page Heading -->                 
                    <p class="mb-4">Liste des clients actifs dans le Systeme. Si vous souhaitez charger un nouveau client, alllez au <a target="_blank"
                            href="chargeCustomer.jsp">Charger Client</a>.</p>

                    <!-- DataTales Example (notre table clients)-->
                    <div class="card shadow mb-13">
                        
                        <div class="card-header py-3">
                           <h6 class="m-0 font-weight-bold text-primary">DataBase</h6>
                        </div>
                        
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0"> <!--attentionà l_id de la table-->
                                    <thead>
                                        <tr>
                                            <th>ID Client</th>                                            
                                            <th>Nom Contact</th> 
                                            <th>Prenom</th>
                                            <th>Nom</th>
                                            <th>Téléphone</th>
                                            <th>Adresse</th>
                                            <th>Adresse (comp)</th>
                                            <th>Ville</th>
                                            <th>Département</th>
                                            <th>Code Postale</th>
                                            <th>Pays</th>
                                            <th>Plafond Credit</th>
                                            <th>Responsable</th>
                                            <th style="width: 210px">Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>ID Client</th>   
                                            <th>Nom Contact</th> 
                                            <th>Prenom</th>
                                            <th>Nom</th>
                                            <th>Téléphone</th>
                                            <th>Adresse 1</th>
                                            <th>Adresse (comp)</th>
                                            <th>Ville</th>
                                            <th>Département</th>
                                            <th>Code Postale</th>
                                            <th>Pays</th>
                                            <th>Plafond Credit</th>
                                            <th>Responsable</th>
                                            <th style="width: 210px">Accion</th>
                                        </tr>
                                    </tfoot>
                                    <!--/// Ajouter les champs de la table Customer par lien java in tbody que vi-->
                                    <!--/// que viennent de  SvEditCustomer -->
                                   <%
                                   List<Customer> listeCustomers = (List)request.getSession().getAttribute("listeCustomers");
                                   %>
                                    <tbody>
                                        <% for (Customer cust : listeCustomers){%>
                                        <tr>
                                            <td><%=cust.getCustomerNumber() %> </td>
                                            <td><%=cust.getCustomerName()%> </td>
                                            <td><%=cust.getContactLastName()%></td>
                                            <td><%=cust.getContactFirstName()%></td>
                                            <td><%=cust.getPhone()%> </td>
                                            <td><%=cust.getAddressLine1()%></td>
                                            <td><%=cust.getAddressLine2()%></td>
                                            <td><%=cust.getCity()%></td>
                                            <td><%=cust.getState()%></td>
                                            <td><%=cust.getPostalCode()%></td>
                                            <td><%=cust.getCountry()%></td>
                                            <td><%=cust.getCreditLimit()%></td>
                                            <td><%=cust.getSalesRepEmployeeNumber()%></td>
                                            
                                            <!-boton elim (formu_1) + boton add (form_2)-->
                                            <td style="display:flex;width:230px;">
                                                
                                                <form name="Supprimer" action="SvSuppCustomer" method="POST"> <!--Esto es para enviar codigo al Sevelet-->
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right:5px;">
                                                        <i class="fas fa-solid fa-trash-alt"></i> Supprimer  
                                                    </button>
                                                    <input type="hidden" name="customerNumber" value="<%=cust.getCustomerNumber()%>"> <!-- esto es para mandar el codigo al servelet -->
                                                </form>
                                                
                                               
                                                <form name="Editer" action="SvEditCustomer" method="GET"> <!-- Esto es para enviar codigo al Sevelet -->
                                                    <button type="submit" class="btn btn-primary btn-user btn-block"; style="margin-left: 5px;">
                                                        <i class="fas fa-solid fa-pencil-alt"></i> Editer
                                                    </button>
                                                <input type="hidden" name="customerNameIdEdit" value="<%=cust.getCustomerNumber()%>"> <!-- esto es para mandar el codigo al servelet ** name="id" fue cambiado por name="customerNumber" -->
                                                <!-- este name="id" le cambiamos el nombre  name="customerNameIdEdit" -->
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