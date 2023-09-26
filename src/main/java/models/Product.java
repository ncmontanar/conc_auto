/*
 * 04/09/2023
 * Product :
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUITS")
public class Product implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productCode;
    private String productName;
    private String productScale;
    private String productVendor;  
    private String productDescription;
    private String quantityInStock;
    private float buyPrice;
    private float MSRP;
    
    /// !!! les noms de joins_colonms doivent être differentes de ma clé principale
    
    //Product to PdtLine Nto1
    @ManyToOne
    @JoinColumn(name ="productLine", referencedColumnName = "productLine")
    private ProductLine productLine;
    
    //order to products 1toN
    @OneToMany(mappedBy = "products")
    private List<OrderDetail> orderDetailList;
    

    
    // const

    public Product() {
    }

    public Product(int productCode, String productName, String productScale, String productVendor, String productDescription, String quantityInStock, float buyPrice, float MSRP, ProductLine productLine, List<OrderDetail> orderDetailList) {
        this.productCode = productCode;
        this.productName = productName;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.MSRP = MSRP;
        this.productLine = productLine;
        this.orderDetailList = orderDetailList;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(String quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public float getMSRP() {
        return MSRP;
    }

    public void setMSRP(float MSRP) {
        this.MSRP = MSRP;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
    
    

}
