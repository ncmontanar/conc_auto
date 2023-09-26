/*SvCustomer
**comme une API : c'est une interface entre la part graphique (jsp) et la logique du businnes (models) 
 */
package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Controller;
import models.Customer;





@WebServlet(name = "SvCustomer", urlPatterns = {"/SvCustomer"})
public class SvCustomer extends HttpServlet {
    
    // appel à la classe controller
    Controller control = new Controller();   


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    //ce doGET fait l_affichage des données de voirCustomer.jsp
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//creer un metode : devolver la lista de ususarios en la bdd
        List<Customer> listeCustomers = new ArrayList<Customer>();
        listeCustomers = control.getCustomers();
        
        // travailler avec sessions : creation des instances avec http
        HttpSession misession = request.getSession();
        misession.setAttribute("listeCustomers", listeCustomers);
        
        //control de registro en consola
        System.out.println("customer: "+listeCustomers.get(0));
        
        
        response.sendRedirect("voirCustomer.jsp");    
    }

    //ce doPost fait la recuperation des données de chargeCustomer.jsp
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //le parametre est le meme id utilisé dans le formulaire chargeCustomer.jsp
  
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
        
        System.out.println("el nombre de customer es "+customerName);
        //il est crée en controller  - creerCustomer
        control.creerCustomer(customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, 0);
                
        //  control.crearUsuario(nombreUsuario, contrasenia, rol);
        response.sendRedirect("index.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}