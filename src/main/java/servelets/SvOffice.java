/*
*SvOffice
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
import models.Office;


@WebServlet(name = "SvOffice", urlPatterns = {"/SvOffice"})
public class SvOffice extends HttpServlet {
    
     // appel à la classe controller
    Controller control = new Controller();   


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    //Off_4.1 ce doGET fait l_affichage des la liste d'agences de voirOffice.jsp
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //ce mtd cree une liste agences dans la bdd
        List<Office> listoffices = new ArrayList<Office>();
        
        //4.3 creation d'une mtd pour l'avoir dans la bdd
        listoffices = control.getOffices();
                
        //4.5.2 creer la sesion http from  PersistenceController
        HttpSession misession = request.getSession();
        misession.setAttribute("listoffices", listoffices);
        
        //4.6 retour de la bdd from  PersistenceController
        //control de registro en consola
        System.out.println("liste offic en SvOff: "+listoffices.get(0));

        
        //puis revenir à la page d_accueil
        response.sendRedirect("voirOffice.jsp"); 

    }

    
    //Off_2.1 ce doPost recupère les infos du formulaire chargeOffice.jsp
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //le parametre est le meme name utilisé dans le formulaire 
        String officeCodeCh = request.getParameter("codeAgenceNameNn");
        String cityCh  = request.getParameter("villeAgenceNameNn");
        String phoneCh  = request.getParameter("telAgenceNn");
        String addressLine1Ch  = request.getParameter("addresAgenceNn");
        String addressLine2Ch  = request.getParameter("addresCompAgenceNn");
        String stateCh = request.getParameter("depAgenceNn");
        String countryCh = request.getParameter("paysAgenceNn");
        String postalCodeCh = request.getParameter("cpAgenceNn");
        String territoryCh = request.getParameter("regAgenceNn");
        
        System.out.println("code de l agence es en SvOffice "+officeCodeCh);
        System.out.println("city de l agence es en SvOffice "+cityCh);
        System.out.println("teleph de l agence es en SvOffice "+phoneCh);
        System.out.println(addressLine1Ch);
        System.out.println(addressLine2Ch);
        System.out.println(countryCh);
        
        
        //Off_2.2 appel la controller pour y deployer la mtde creerOffice 
        control.creerOffice(officeCodeCh,cityCh, phoneCh, addressLine1Ch, addressLine2Ch, stateCh, countryCh, postalCodeCh, territoryCh);

       //Off_ redicretion vers index apres insert dans la BDD
        response.sendRedirect("index.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
