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

//
@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {
    
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

     //il va recevoir l_utilisateur et le MdP qui viennent du login.jsp :mediate una sesion : 
     //traer parametro ususario y parametro contrasena
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("EmailLog");
        String extension= request.getParameter("PasswordLog");
        
        // vérifier si l-utilisateur est bien loged
        boolean validationLog = false;
        validationLog = control.valideraccess(email,extension); // cette validation se fait dans le controller - dans la logique
        
        if(validationLog == true){
            HttpSession misession = request.getSession(true);       //getSession apporte la sesion de l_utilisateur actuel 
            misession.setAttribute("EmailLog", email);          //creamos una sesion y esta sesion corresponde a este usuario
            response.sendRedirect("SvIndicateurs");
        }
        else{
            response.sendRedirect("loginError.jsp");  ///loginError à completer en front !
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
