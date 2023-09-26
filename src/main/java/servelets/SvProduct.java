/*
*SvProduct
 */
package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Controller;


@WebServlet(name = "SvProduct", urlPatterns = {"/SvProduct"})
public class SvProduct extends HttpServlet {

    // appel à la classe controller
    Controller control = new Controller();   
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //le parametre est le meme id utilisé dans le formulaire chargeVoiture.jsp
        String productCode = request.getParameter("productCodeId");
        String productName = request.getParameter("productNameId");
        String productScale = request.getParameter("productScale");
        String productVendor = request.getParameter("productVendor");
        String productDescription = request.getParameter("productDescription");
        String quantityInStock = request.getParameter("quantityInStock");
        String buyPrice = request.getParameter("buyPrice");
        String MSRP = request.getParameter("MSRP");
        
        System.out.println("el nombre del producto es "+productName);
        
        ///creation de creerProduit en Controller
        control.creerProduit(productName, productScale, productVendor, productDescription, quantityInStock, 0, 0);
        

//redicretion vers index apres insert dans la BDD
        response.sendRedirect("chargeVoiture.jsp");
  
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
