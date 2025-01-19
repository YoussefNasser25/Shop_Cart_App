/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Online_Market;

/**
 *
 * @author youss
 */
import java.util.Scanner;

public class Shop_Cart_App {
    public static void main(String[] args) {
        ShopManager shopManager = new ShopManager();
        Cart shoppingCart = new Cart();
        Scanner scanner = new Scanner(System.in);

        // Sample products
        shopManager.addProduct(new Product(1, "Laptop", 1500.0, 10));
        shopManager.addProduct(new Product(2, "Phone", 800.0, 20));
        shopManager.addProduct(new Product(3, "Headphones", 150.0, 30));

        while (true) {
            System.out.println("\n--- Shopping Cart Menu ---");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Remove Product from Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(shopManager);
                    break;
                case 2:
                    System.out.print("Enter product ID: ");
                    int productId = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    Product product = shopManager.getProductById(productId);
                    if (product != null && product.getStock() >= quantity) {
                        shoppingCart.addItem(product, quantity);
                        product.setStock(product.getStock() - quantity);
                        System.out.println("Product added to cart.");
                    } else {
                        System.out.println("Invalid product or insufficient stock.");
                    }
                    break;
                case 3:
                    System.out.println(shoppingCart);
                    break;
                case 4:
                    System.out.print("Enter product ID to remove: ");
                    int removeId = scanner.nextInt();
                    shoppingCart.removeItem(removeId);
                    System.out.println("Product removed from cart.");
                    break;
                case 5:
                    System.out.println("Total: $" + shoppingCart.calculateTotal());
                    System.out.println("Thank you for shopping!");
                    return;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
