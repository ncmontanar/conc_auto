/*
 * SvSuppCustomer
 */
package servelets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Controller;


@WebServlet(name = "SvSuppCustomer", urlPatterns = {"/SvSuppCustomer"})
public class SvSuppCustomer extends HttpServlet {
    
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
    
    ///mothode crée dans controller
    // 1er pas : ce qu'on va effacer -- idSupp//customerNumber vient du parametre  name="idSupp" ou name="customerNumber"  du supprimer de voirCustomer.jsp
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
        
        control.effacerCustomer(customerNumber);
        
        // renvoie vers 
        response.sendRedirect("SvCustomer");
   
      
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
