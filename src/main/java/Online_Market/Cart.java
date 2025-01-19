/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Online_Market;

/**
 *
 * @author youss
 */
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        // Check if the product is already in the cart
        for (CartItem item : cartItems) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cartItems.add(new CartItem(product, quantity));
    }

    public void removeItem(int productId) {
        cartItems.removeIf(item -> item.getProduct().getId() == productId);
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getQuantity() * item.getProduct().getPrice();
        }
        return total;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cart Items:\n");
        for (CartItem item : cartItems) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }
}
