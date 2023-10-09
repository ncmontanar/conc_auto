<%-- 
    Document   : voirProduit
    Created on : 7 oct. 2023, 17:46:36
    Author     : a895279
--%>

<%@page import="models.Product"%>
<%@page import="models.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@include file="components/header.jsp" %>
<%@include file="components/bodypremierepart.jsp" %>

        <!-- Begin Page Content -->
        <div class="container-fluid">  

            <!-- Page Heading -->                 
            <p class="mb-4">Etat de l'invéntaire disponible. Si vous souhaitez charger une nouvelle unité, alllez au <a target="_blank"
                    href="chargeVoiture.jsp">Charger unité</a>.</p>

            <!-- DataTales Example (notre table Stock)-->
            <div class="card shadow mb-13">

                <div class="card-header py-3">
                   <h6 class="m-0 font-weight-bold text-primary">DataBase</h6>
                </div>

                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0"> <!--attentionà l_id de la table-->
                            <thead>
                                <tr>
                                    <th>Code Prod</th>                                            
                                    <th>Nom unité</th> 
                                    <th>Ligne</th>
                                    <th>Taille</th>
                                    <th>Fournisseur</th>
                                    <th>Description produit</th>
                                    <th>Stock disponible</th>
                                    <th>Prix_achat</th>
                                    <th>Prixvente</th>
                                    <th style="width: 210px">Action</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>Code Prod</th>                                            
                                    <th>Nom unité</th> 
                                    <th>Ligne</th>
                                    <th>Taille</th>
                                    <th>Fournisseur</th>
                                    <th>Description produit</th>
                                    <th>Stock disponible</th>
                                    <th>Prix_achat</th>
                                    <th>Prixvente</th>
                                    <th style="width: 210px">Action</th>
                                </tr>
                             </tfoot>
                             <!--/// Ajouter les champs de la table Produit par lien java in tbody-->
                             <!--/// que viennent de SvProduct (list) et de SvEditProduct  -->
                             <%
                              List <Product> listProducts = (List)request.getSession().getAttribute("listProducts");
                             %>
                             <tbody>
                                 <% for (Product pdrt : listProducts){%>
                                <tr>
                                    <td><%=pdrt.getProductCode()%></td>
                                    <td><%=pdrt.getProductName()%></td>
                                    <td><%=pdrt.getProductLine()%></td>
                                    <td><%=pdrt.getProductScale()%></td>
                                    <td><%=pdrt.getProductVendor()%></td>
                                    <td><%=pdrt.getProductDescription()%></td>
                                    <td><%=pdrt.getQuantityInStock()%></td>
                                    <td><%=pdrt.getBuyPrice()%></td>
                                    <td><%=pdrt.getMSRP()%> </td>
                                    <!--boton elim (formu_1) + boton add (form_2)-->
                                    <td style="display:flex;width:230px;">


                                       <!--name="productCode" vient de SvSuppProduit-->
                                        <form name="Supprimer" action="SvSuppProduit" method="POST"> <!--Esto es para enviar codigo al Sevelet-->
                                            <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right:5px;">
                                                <i class="fas fa-solid fa-trash-alt"></i> Supprimer  
                                            </button>
                                            <input type="hidden" name="productCode" value="<%=pdrt.getProductCode()%>"> <!-- esto es para mandar el codigo al servelet -->
                                        </form>

                                       <!--name="productNameNameEd" vient de editCustommer-->
                                        <form name="Editer" action="SvEditProduit" method="GET"> <!-- Esto es para enviar codigo al Sevelet -->
                                            <button type="submit" class="btn btn-primary btn-user btn-block"; style="margin-left: 5px;">
                                                <i class="fas fa-solid fa-pencil-alt"></i> Editer
                                            </button>
                                        <input type="hidden" name="productNameNameEd" value="<%=pdrt.getProductCode() %>"> <!-- esto es para mandar el codigo al servelet ** name="id" fue cambiado por name="customerNumber" -->
                                        
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