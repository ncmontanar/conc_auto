/*
* SvEditCustomer
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
import models.Customer;


@WebServlet(name = "SvEditCustomer", urlPatterns = {"/SvEditCustomer"})
public class SvEditCustomer extends HttpServlet {
    
    // appel à la classe controller
    Controller control = new Controller();  


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /// 1er pas :ce Get reçoit l_id que on va eliminer qui vient de voirCustomer.jsp (idem que suppCustomer)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int customerNumber = Integer.parseInt(request.getParameter("customerNameIdEdit")); //request.getParameter("customerNumber")) changé par request.getParameter("id"))
        Customer cust = control.emenerCustomer(customerNumber);                                     //parametre à ajouter : customerNumber 
        
        //obtener la sesion de la request    
        HttpSession misession = request.getSession();
        misession.setAttribute("custEdition", cust);
        
        System.out.println("le customer en SvEditCust est " + cust.getCustomerName());  
        
        response.sendRedirect("editCustomer.jsp"); 
        
               
        
    }

     // il recoit les donnees nécessaires à éditer : customerName, contactLastName...
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // le parametre à passer est le name="" de de chaque input en editCustomer.jsp
        
        int customerNumber = Integer.parseInt(request.getParameter("customerNumberMod"));
        String customerName = request.getParameter("customerNameIdEdit"); // customerName changé par customerNameId
        String contactLastName = request.getParameter("contactLastNameEdit");
        String contactFirstName =request.getParameter("contactFirstNameEdit");
        String phone= request.getParameter("phoneEdit");
        String addressLine1= request.getParameter("addressLine1Edit");
        String addressLine2= request.getParameter("addressLine2Edit");
        String city= request.getParameter("cityEdit");
        String state= request.getParameter("stateEdit");
        String postalCode= request.getParameter("postalCodeEdit");
        String country= request.getParameter("countryEdit");
        float creditLimit= Float.parseFloat(request.getParameter("creditLimitEdit"));
        int salesRepEmployeeNumber = Integer.parseInt(request.getParameter("salesRepEmployeeNumberEdit"));
        
        
        
        
        // aporter la sesion : misession.setAttribute("custEdition", cust);
        // custEdition vient de la sesion et de editCustomer.jsp (<%Customer cust=(Customer)request.getSession().getAttribute("custEdition"); %>)
        /// el atributo es el nom del usuario
        Customer cust = (Customer)request.getSession().getAttribute("custEdition");
                      
        cust.setCustomerNumber(customerNumber);      
        cust.setCustomerName(customerName);
        cust.setContactLastName(contactLastName);
        cust.setContactFirstName(contactFirstName);
        cust.setPhone(phone);
        cust.setAddressLine1(addressLine1);
        cust.setAddressLine2(addressLine2);
        cust.setCity(city);
        cust.setState(state);
        cust.setPostalCode(postalCode);
        cust.setCountry(country);
        cust.setCreditLimit(creditLimit);
        //cust.setSalesRepEmployeeNumber(salesRepEmployeeNumber);  //Comment la caster  to Employee?? 
        

        System.out.println("le get customer Num est " + cust.getCustomerNumber());                                                                                  
        System.out.println("le get customer nom est " + cust.getCustomerName());

        // 
        control.editerCustomer(cust);
        ///
        response.sendRedirect("SvCustomer");  
    
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}