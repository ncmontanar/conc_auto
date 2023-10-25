/*
*
 */
package servelets;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Controller;



@WebServlet(name = "SvCountEmployee", urlPatterns = {"/SvCountEmployee"})
public class SvCountEmployee extends HttpServlet {
    
            // appel à la classe controller
            Controller control = new Controller();  
       


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }

    /// 7 .creer une appel à la méthode getEmployee count
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
                
        //appel à la controller
        int employeeCount = control.getEmployeeCount();
        
         // travailler avec sessions : creation des instances avec http
        HttpSession misession = request.getSession();
        misession.setAttribute("count", employeeCount); 

       ///
       request.setAttribute("count", employeeCount);
       
       ///
       System.out.println("le nb  de empl en SvCountEmployee est " + employeeCount); 
             
       response.sendRedirect("index.jsp");
       
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
