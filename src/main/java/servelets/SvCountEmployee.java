/*
*
 */
package servelets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Controller;



@WebServlet(name = "SvCountEmployee", urlPatterns = {"/SvIndicateurs"})
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
        int stockCount = control.getStockCount();
        float stockValue = control.getStockValue();
        float stockValueIn = control.getstockValueIn();
        int employeeCount = control.getEmployeeCount();
        int agenceCount = control.getAgenceCount();
        int clientsCount = control.getClientsCount();
        int clientsCountPlus = control.getClientsPlus();
       
         // travailler avec sessions : creation des instances avec http
        HttpSession misession = request.getSession();
        misession.setAttribute("countStock", stockCount);
        misession.setAttribute("value", stockValue);
        misession.setAttribute("valueStcIn",stockValueIn);
        misession.setAttribute("count", employeeCount);
        misession.setAttribute("countAgence", agenceCount);
        misession.setAttribute("countClient", clientsCount);
        misession.setAttribute("countClientPlus", clientsCountPlus);

      ///
        request.setAttribute("countStock",stockCount );
        request.setAttribute("value", stockValue);
        request.setAttribute("valueStcIn", stockValueIn);
        request.setAttribute("countAgence", agenceCount);
        request.setAttribute("countClient", clientsCount);
        request.setAttribute("countClientPlus", clientsCountPlus);
      
       ///
        System.out.println( "le nb  d_element en SvCount est " + stockCount);
        System.out.println("le nb  de empl en SvCountEmployee est " + employeeCount);
        System.out.println("la valeur du stock en SvProduitValue est " + stockValue); 
        System.out.println("la valeur du stockIn en SvProduitValueIN est " + stockValueIn); 
        System.out.println("la valeur du countAgence en SvProduitValueest " + agenceCount); 
        System.out.println("la valeur du countClientPlus en SvProduitValueest " + clientsCountPlus);
        

       
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
        return "Short description";
    }

}
