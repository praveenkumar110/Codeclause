import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private List<Product> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    public void addItem(Product product) {
        cart.add(product);
    }

    public void removeItem(int productId) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getId() == productId) {
                cart.remove(i);
                break;
            }
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : cart) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public List<Product> getCart() {
        return cart;
    }

}

public class ECommerceSystem {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Product 1", 10.0));
        products.add(new Product(2, "Product 2", 20.0));
        products.add(new Product(3, "Product 3", 30.0));
        products.add(new Product(4, "Product 4", 40.0));
        products.add(new Product(5, "Product 5", 50.0));
        products.add(new Product(6, "Product 6", 60.0));
        products.add(new Product(7, "Product 7", 70.0));
        products.add(new Product(8, "Product 8", 80.0));
        products.add(new Product(9, "Product 9", 70.0));
        products.add(new Product(10, "Product 10", 100.0));

        ShoppingCart cart = new ShoppingCart();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. List products");
            System.out.println("2. Add product to cart");
            System.out.println("3. Remove product from cart");
            System.out.println("4. View cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Products:");
                    for (Product product : products) {
                        System.out.println(product.getId() + ". " + product.getName() + " - $" + product.getPrice());
                    }
                    break;
                case 2:
                    System.out.println("Enter product ID:");
                    int productId = scanner.nextInt();
                    for (Product product : products) {
                        if (product.getId() == productId) {
                            cart.addItem(product);
                            System.out.println("Product added to cart.");
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter product ID:");
                    productId = scanner.nextInt();
                    cart.removeItem(productId);
                    System.out.println("Product removed from cart.");
                    break;
                case 4:
                    System.out.println("Cart:");
                    for (Product product : cart.getCart()) {
                        System.out.println(product.getId() + ". " + product.getName() + " - $" + product.getPrice());
                    }
                    System.out.println("Total price: $" + cart.getTotalPrice());
                    break;
                case 5:
                    System.out.println("Checkout successful.");
                    System.exit(0);
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}