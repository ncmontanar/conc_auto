/*SvCustomer
**comme une API : c'est une interface entre la part graphique (jsp) et la logique du businnes (models) 
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





@WebServlet(name = "SvCustomer", urlPatterns = {"/SvCustomer"})
public class SvCustomer extends HttpServlet {
    
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


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //le parametre est le meme id utilisé dans le formulaire chargeCustomer.jsp
        String  customerNumber = request.getParameter("customerNumberId");
        String customerName = request.getParameter("customerName");
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
        
        System.out.println("el numero de customer es "+customerNumber);
         
        control.creerCustomer(customerNumber, customerName,contactLastName, contactFirstName,phone,addressLine1,addressLine2, city, state, postalCode, country, creditLimit);
        
                
        //  control.crearUsuario(nombreUsuario, contrasenia, rol);
        response.sendRedirect("index.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
