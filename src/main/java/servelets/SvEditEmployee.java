/*
*SvEditEmployee
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
import models.Employee;

/**
 *
 * @author a895279
 */
@WebServlet(name = "SvEditEmployee", urlPatterns = {"/SvEditEmployee"})
public class SvEditEmployee extends HttpServlet {
    
    // appel à la classe controller
    Controller control = new Controller();  



    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }

    ///Emmp_5.6.1 ce doGet recoit l-id qu'on va eliminer
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int employeeNumber = Integer.parseInt(request.getParameter("emploNumberName")); /// parametre vient de editEmployee.jsp / ...NameEd
        Employee emply = control.emenerEmployee(employeeNumber);
        
         //obtener la sesion de la request   : creation de emplyEdition
        HttpSession misession = request.getSession();
        misession.setAttribute("emplyEdition",emply);
        
        System.out.println("le emple en SvEditEmployee est " + emply.getLastName());  
        System.out.println("le ID emple en SvEditEmployee est " + emply.getEmployeeNumber());  
        
        response.sendRedirect("editEmployee.jsp"); 

        
    }

    ///Empl_5.6.6 il recoit les caracteristiques Employee à éditer de editEmployee.jsp
    // le parametre à passer est le name="" de chaque class en editEmployee.jsp
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int employeeNumber = Integer.parseInt(request.getParameter("emploNumberName"));
        String lastName =  request.getParameter("empLastNameNmEd");
        String firstName = request.getParameter("empFirstNameNmEd");
        String extension = request.getParameter("empExtentionNmEd");
        String email = request.getParameter("empMailaddresslNmEd");
        String jobTitle = request.getParameter("empPosteNmEd"); 
        String officeCode = request.getParameter("empOfficeCodeNmEd");
        int reportsTo = Integer.parseInt(request.getParameter("empReportsToNmEd"));
        
        // 5.6.6 aporter la sesion : misession.setAttribute("emplyEdition",emply);
        // emplyEdition vient de la sesion et de editProduit.jsp (<%Employee emply = (Employee)request.getSession().getAttribute("emplyEdition");%> %>)
        /// el atributo es el nom del employee
        
        Employee emply = (Employee)request.getSession().getAttribute("emplyEdition");
        
        emply.setEmployeeNumber(employeeNumber);
        emply.setLastName(lastName);
        emply.setFirstName(firstName);
        emply.setExtension(extension);
        emply.setEmail(email);
        emply.setJobTitle(jobTitle);
        //emply.setOfficeCode(officeCode);
        emply.setReportsTo(emply);
        
        System.out.println("le get emply ID en SVEditEmployee est " +emply.getEmployeeNumber());                                                                                  
        System.out.println("le get emply nom en SVEditEmployee est " +emply.getLastName());
        
        //appeller à la controller
        control.editerEmployee(emply);
        
        //5.8.9 retour de JPA pour revonyer svEmployee
        response.sendRedirect("SvEmployee");  
        

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
