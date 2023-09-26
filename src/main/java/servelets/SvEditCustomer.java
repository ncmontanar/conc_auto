/*
* 
 */
package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
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
        
        System.out.println("le customer est" + cust.getCustomerName());  
        
        response.sendRedirect("editCustomer.jsp"); 
        
               
        
    }

        // il recoit les donnees nécessaires à éditer : customerName, contactLastName...
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // le parametre à passer est le name="" de customerName en editCustomer.jsp
        
        String customerNumber = request.getParameter("customerNumberId");
        String customerName = request.getParameter("customerNameId"); // customerName changé par customerNameId
        String contactLastName = request.getParameter("contactLastName");
        String contactFirstName =request.getParameter("contactFirstName");
        String phone= request.getParameter("phone");
        String addressLine1= request.getParameter("addressLine1");
        String addressLine2= request.getParameter("addressLine2");
        String city= request.getParameter("city");
        String state= request.getParameter("state");
        String postalCode= request.getParameter("postalCode");
        String country= request.getParameter("country");
        String creditLimit= request.getParameter("creditLimit");
        
        // custEdition vient de editCustomer.jsp (<%Customer cust=(Customer)request.getSession().getAttribute("custEdition"); %>)
        /// el atributo es el nom del usuario
        Customer cust = (Customer)request.getSession().getAttribute("custEdition");
                      
        cust.setCustomerNumber(0);      
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
        cust.setCreditLimit(0);
        //cust.setSalesRepEmployeeNumber(salesRepEmployeeNumber);

        control.editerCustomer(cust);
        
        response.sendRedirect("SvCustomer");  
        
        
        
        
        
        
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

//        String customerNumber = request.getParameter("customerNumberId"); 
//        String nomCust = request.getParameter("customerNameId");
//        String contctLstNme = request.getParameter("contactLastName");
//        String contctFrstNme = request.getParameter("contactFirstName");
//        String phn = request.getParameter("phone");
//        String addrssLn1 = request.getParameter("addressLine1");
//        String addrssLn2 = request.getParameter("addressLine2");
//        String cty = request.getParameter("city");
//        String stt = request.getParameter("state");
//        String pstlCd = request.getParameter("postalCode");
//        String cntry = request.getParameter("country");
//        String crdtLmt = request.getParameter("creditLimit");
//        
//        // custEdition vient de editCustomer.jsp (<%Customer cust=(Customer)request.getSession().getAttribute("custEdition"); %>)
//        /// el atributo es el nom del usuario
//        Customer cust = (Customer)request.getSession().getAttribute("custEdition");
//        
//        cust.setCustomerNumber(0); 
//        cust.setCustomerName(nomCust);
//        cust.setContactLastName(contctLstNme);
//        cust.setContactFirstName(contctFrstNme);
//        cust.setPhone(phn);
//        cust.setAddressLine1(addrssLn1);
//        cust.setAddressLine2(addrssLn2);
//        cust.setCity(cty);
//        cust.setState(stt);
//        cust.setPostalCode(pstlCd);
//        cust.setCountry(cntry);
//        cust.setCreditLimit(0);
//        
//        control.editerCustomer(cust);
//        
//        response.sendRedirect("SvCustomer");  





//----------------

//String customerNumber = request.getParameter("customerNumberId"); 
//        String customerName = request.getParameter("customerNameId");
//        String contactLastName = request.getParameter("contactLastName");
//        String contactFirstName = request.getParameter("contactFirstName");
//        String phone = request.getParameter("phone");
//        String addressLine1 = request.getParameter("addressLine1");
//        String addressLine2 = request.getParameter("addressLine2");
//        String city = request.getParameter("city");
//        String state = request.getParameter("state");
//        String postalCode = request.getParameter("postalCode");
//        String country = request.getParameter("country");
//        String creditLimit = request.getParameter("creditLimit");
//        
//        // custEdition vient de editCustomer.jsp (<%Customer cust=(Customer)request.getSession().getAttribute("custEdition"); %>)
//        /// el atributo es el nom del usuario
//        Customer cust = (Customer)request.getSession().getAttribute("custEdition");
//        
//        cust.setCustomerNumber(0); 
//        cust.setCustomerName(customerName);
//        cust.setContactLastName(contactLastName);
//        cust.setContactFirstName(contactFirstName);
//        cust.setPhone(phone);
//        cust.setAddressLine1(addressLine1);
//        cust.setAddressLine2(addressLine2);
//        cust.setCity(city);
//        cust.setState(state);
//        cust.setPostalCode(postalCode);
//        cust.setCountry(country);
//        cust.getCreditLimit();