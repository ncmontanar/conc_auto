/*
*SvProduct
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
import models.Product;


@WebServlet(name = "SvProduct", urlPatterns = {"/SvProduct"})
public class SvProduct extends HttpServlet {

    // appel à la classe controller
    Controller control = new Controller();   
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
    }

     //ce doGET fait l_affichage des données de voirProduit.jsp
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //creer la metode qui va creer la liste de produits dans la bdd
        List <Product> listProducts = new ArrayList<Product>();
        listProducts = control.getProducts();
        
        //
        HttpSession misession = request.getSession();
        misession.setAttribute("listProducts",listProducts); // on crée listProducts
        //
         System.out.println("les Produits modifié: "+ listProducts.get(0));
        //
         response.sendRedirect("voirProduit.jsp"); 
    }

    //2.1 ce doPost fait la recuperation des données de chargeVoiture.jsp
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //le parametre est le meme id utilisé dans le formulaire chargeVoiture.jsp
         
        //String productCode = request.getParameter("productCodeId");
        String productName = request.getParameter("productNameName"); 
        String productLine = request.getParameter("productLineName");
        String productScale = request.getParameter("productScale");
        String productVendor = request.getParameter("productVendor");
        String productDescription = request.getParameter("productDescription");
        String quantityInStock = request.getParameter("quantityInStock");
        float buyPrice = Float.parseFloat(request.getParameter("buyPrice")); 
        float MSRP = Float.parseFloat(request.getParameter("MSRP"));            
        

        System.out.println("el nombre del producto es "+productName);
        System.out.println("el MSRP del producto es "+MSRP);
        
        ///creation de creerProduit en Controller
        control.creerProduit(productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP);
        

        //redicretion vers index apres insert dans la BDD
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
