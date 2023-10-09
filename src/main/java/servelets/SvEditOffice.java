/*
*SvEditOffice
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
import models.Office;


@WebServlet(name = "SvEditOffice", urlPatterns = {"/SvEditOffice"})
public class SvEditOffice extends HttpServlet {
    
        // appel à la classe controller
    Controller control = new Controller();  

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // Off_4.11 :ce Get reçoit l_id que on va eliminer et qui vient de voirOffice.jsp
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String officeCode = request.getParameter("codeAgenceIdMod"); // vient de name="codeAgenceNameNnMod" du editOffice.jsp // testé avec codeAgenceIdMod /villeAgenceNameNnMod
        Office offic = control.emenerOffice(officeCode);
        
        //Off_4.16 obtener la sesion de la request emenerOffice
        HttpSession misession = request.getSession();
        misession.setAttribute("officEdition", offic);
        
        System.out.println("l_Officine en SvEditOff est " + offic.getOfficeCode());
        
        //renvoie 
        response.sendRedirect("editOffice.jsp");
        
    }

    ///Off_4.15  il recoit les donnees nécessaires à éditer : 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // le parametre à passer est le name="" de chaque input en editOffice.jsp
        String officeCodeMod = request.getParameter("codeAgenceNameNnMod");  //  request.getParameter("codeAgenceNameNnMod") changé par  request.getParameter("codeAgenceIdMod");
        String cityMod = request.getParameter("villeAgenceNameNnMod");
        String phoneMod = request.getParameter("telAgenceNnMod");
        String addressLine1Mod = request.getParameter("addresAgenceNnMod");
        String addressLine2Mod = request.getParameter("addresCompAgenceNnMod");
        String stateEdiMod = request.getParameter("depAgenceNnMod");
        String countryEdiMod = request.getParameter("paysAgenceNnMod");
        String postalCodeEdiMod = request.getParameter("cpAgenceNnMod");
        String territoryEdiMod = request.getParameter("regAgenceNnMod");
        
        //Off_4.18  aporter la session de la requete : (vient de editOffice : (Office)request.getSession().getAttribute("officEdition");%>
        Office offic = (Office)request.getSession().getAttribute("officEdition");
        
        
        offic.setOfficeCode(officeCodeMod);
        offic.setCity(cityMod);
        offic.setPhone(phoneMod);
        offic.setAddressLine1(addressLine1Mod);
        offic.setAddressLine2(addressLine2Mod);
        offic.setState(stateEdiMod);
        offic.setCountry(countryEdiMod);
        offic.setPostalCode(postalCodeEdiMod);
        offic.setTerritory(territoryEdiMod);
        
        System.out.println("le get office Num (en SvEditOffice) est " + offic.getOfficeCode());
        System.out.println("le get office ville (en SvEditOffice) est " + offic.getCity());
        
        //Off_4.19 appel à la controller pour creer la mtd editerOffice
        control.editerOffice(offic);
        
        //OFf_4.22 retour à index
        response.sendRedirect("SvOffice");  
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
