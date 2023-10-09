/*
 *SvSuppOffice
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


@WebServlet(name = "SvSuppOffice", urlPatterns = {"/SvSuppOffice"})
public class SvSuppOffice extends HttpServlet {
    
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

    // Off_4.8 ce qu'on va effacer -- id à Supp: officeCode vient du parametre name="officeCode"  du supprimer de voirOffice.jsp
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String officeCode = request.getParameter("officeCode");
        // appel - la controller
        control.effacerOffice(officeCode);
        
         // renvoie vers SvOffice pour faire l'affichage apres modification (doGet)
        response.sendRedirect("SvOffice");

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
