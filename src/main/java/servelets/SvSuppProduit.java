/*
*SvSuppProduit
 */
package servelets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Controller;


@WebServlet(name = "SvSuppProduit", urlPatterns = {"/SvSuppProduit"})
public class SvSuppProduit extends HttpServlet {

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
    
    //3.1 on va effacer une unité de l_inventaire -> pour aller à la controller
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int productCode = Integer.parseInt(request.getParameter("productCode"));
        
        control.effacerProduct(productCode);

        // renvoie vers
        response.sendRedirect("SvProduct");
                
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
