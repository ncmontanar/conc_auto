/*SvEmployee 
*10/10/23
 */
package servelets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Controller;
import models.Employee;


@WebServlet(name = "SvEmployee", urlPatterns = {"/SvEmployee"})
public class SvEmployee extends HttpServlet {

    // appel à la classe controller
    Controller control = new Controller();   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    ///Emp_5.3.2 ce doGet fait l'affichage  des données de voirEmployee.jsp et du 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List <Employee> listEmployeesAff = new ArrayList<Employee>();
        listEmployeesAff = control.getEmployeesAff();
        
        // 5.3.5 travailler avec sessions : creation des instances avec http
        HttpSession misession = request.getSession();
        misession.setAttribute("listEmployeesAff", listEmployeesAff);
        
        // 5.3.5 control de registro en consola
        System.out.println("liste employess en SvEmplo : "+listEmployeesAff.get(0));
        
        /// 5.3.5 retur  à la console
        response.sendRedirect("voirEmployee.jsp");   

    }

    //Emp_5.2.1 ce doPost fait la recuperation des données de chargeEmployee.jsp
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        int employeeNumber = 0;
//        String eployeNumberString = request.getParameter("emploNumberName");
//        if (eployeNumberString != null && !"".equals(eployeNumberString)) {
//            employeeNumber = Integer.parseInt(eployeNumberString);
//        }
       
        String lastName = request.getParameter("empLastNameNm");
        String firstName = request.getParameter("empFirstNameNm");
        String extension = request.getParameter("empExtentionNm");
        String email = request.getParameter("empMailaddresslNm");
        String jobTitle = request.getParameter("empPosteNm");
        int reportsTo = Integer.parseInt(request.getParameter("empReportsToNm"));
        String officeCode = request.getParameter("empOfficeCodeNm");
        
        ///
        //System.out.println("code de l employe en SvEmp "+ employeeNumber);
        System.out.println("nom de l empl es en SvEmp "+lastName);
        System.out.println("extension de l empl en SvEmp "+extension);
        System.out.println(email);
        System.out.println(jobTitle);
        System.out.println(reportsTo);
        System.out.println(officeCode);
        
         //Empl 5.2.2 la methode creerEmployee crée en controller  
         control.creerEmployee(lastName, firstName, extension, email, jobTitle, reportsTo, officeCode);
    
         ///Emp_5.2.5_ redicretion vers index apres insert dans la BDD
         response.sendRedirect("index.jsp");
    }
    
    
    


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
