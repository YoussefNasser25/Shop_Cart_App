/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Online_Market;

/**
 *
 * @author youss
 */
import java.util.HashMap;
import java.util.Map;

public class ShopManager {
    private Map<Integer, Product> productCatalog;

    public ShopManager() {
        this.productCatalog = new HashMap<>();
    }

    public void addProduct(Product product) {
        productCatalog.put(product.getId(), product);
    }

    public Product getProductById(int productId) {
        return productCatalog.get(productId);
    }

    public Map<Integer, Product> getProductCatalog() {
        return productCatalog;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Product Catalog:\n");
        for (Product product : productCatalog.values()) {
            sb.append(product.toString()).append("\n");
        }
        return sb.toString();
    }
}
