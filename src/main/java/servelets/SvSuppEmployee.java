/*
*SvSuppEmployee
 */
package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.enterprise.context.RequestScoped;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Controller;


@WebServlet(name = "SvSuppEmployee", urlPatterns = {"/SvSuppEmployee"})
public class SvSuppEmployee extends HttpServlet {

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

    /// Off_5.4.1 on efface un collaborateur - il vient de voirEmployee.jsp   Methode GET
    /// et va le renvoyer à la controller
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        int employeeNumber = Integer.parseInt(request.getParameter("employeeNumber"));
        
        control.effacerEmployee(employeeNumber);
        
       // 5.4.6 renvoie vers mon servelet
        response.sendRedirect("SvEmployee");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
