/*
 */
package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Controller;


@WebServlet(name = "SvProduitValueIn", urlPatterns = {"/SvProduitValueIn"})
public class SvProduitValueIn extends HttpServlet {

    // appel à la classe controller
    Controller control = new Controller();  
            
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        float stockValueIn = control.getstockValueIn();
        
        // travailler avec sessions : creation des instances avec http
        HttpSession misession = request.getSession();
        misession.setAttribute("valueStcIn",stockValueIn);
        
        //
        System.out.println("la valeur du stockIn en SvProduitValueIN est " + stockValueIn); 
        
        //
        response.sendRedirect("index.jsp"); 
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description containing servlet description";
    }

}
