/*
*SvEditProduit
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
import models.Product;


@WebServlet(name = "SvEditProduit", urlPatterns = {"/SvEditProduit"})
public class SvEditProduit extends HttpServlet {
    
    // appel à la classe controller
    Controller control = new Controller();  


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /// 1er pas :ce Get reçoit l_id que on va eliminer qui vient de voirPrduit.jsp (idem que suppProduit)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int productCode = Integer.parseInt(request.getParameter("productNameNameEd"));  //request.getParameter("productCode") par request.getParameter("productNameNameEd") 
        Product pdrt = control.emenerProduit(productCode);
        
        //obtener la sesion de la request emenerProduit(proctCode)
        HttpSession misession = request.getSession();
        misession.setAttribute("prodEdition", pdrt);

        System.out.println("le produit est " + pdrt.getProductName());
        
        response.sendRedirect("editProduct.jsp"); 

    }

    // il recoit les caracteristiques pdt à éditer : productCode, productName...
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                // le parametre à passer est le name="" de productName en editProduct.jsp
         int productCode = Integer.parseInt(request.getParameter("productCodeName"));
         String productName = request.getParameter("productNameNameEd") ;
         String productScale = request.getParameter("productScaleEd");
         String productVendor = request.getParameter("productVendorNameEd");  
         String productDescription = request.getParameter("productDescriptionNameEd");
         String quantityInStock= request.getParameter("quantityInStockNameEd");
         float buyPrice = Float.parseFloat(request.getParameter("buyPriceNameEd"));
         float MSRP =  Float.parseFloat(request.getParameter("MSRPNameEd"));
       
         //aporter la sesion : misession.setAttribute("prodEdition", pdrt);
         //
         /// el atributo es el nom del 
         Product pdrt = (Product)request.getSession().getAttribute("prodEdition");
         
         pdrt.setProductCode(productCode);
         pdrt.setProductName(productName);
         pdrt.setProductScale(productScale);
         pdrt.setProductVendor(productVendor);
         pdrt.setProductDescription(productDescription);
         pdrt.setQuantityInStock(quantityInStock);
         pdrt.setBuyPrice(buyPrice);
         pdrt.setMSRP(MSRP);
         
        System.out.println("le get prd Num est " + pdrt.getProductCode());                                                                                  
        System.out.println("le get prd nom est " + pdrt.getProductName());
         
        control.editerProduit(pdrt);
        
        //retour 
        response.sendRedirect("SvProduct");  

         
         
         
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
