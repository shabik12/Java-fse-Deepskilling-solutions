import java.util.*;

public class SearchDemo {

    // Linear Search
    public static Product linearSearch(Product[] products, int id) {
        for (Product p : products) {
            if (p.productId == id) {
                return p;
            }
        }
        return null;
    }

    // Binary Search (assumes sorted by productId)
    public static Product binarySearch(Product[] products, int id) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].productId == id)
                return products[mid];
            if (products[mid].productId < id)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(205, "Shoes", "Fashion"),
            new Product(150, "Watch", "Accessories"),
            new Product(110, "Phone", "Electronics"),
            new Product(180, "T-Shirt", "Fashion")
        };

        // For Binary Search: Sort by productId
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        System.out.println("Products List (Sorted for Binary Search):");
        for (Product p : products)
            System.out.println(p);

        // Linear Search Test
        System.out.println("\nLinear Search: Searching for productId = 150");
        Product found1 = linearSearch(products, 150);
        System.out.println(found1 != null ? "Found: " + found1 : "Not Found");

        // Binary Search Test
        System.out.println("\nBinary Search: Searching for productId = 150");
        Product found2 = binarySearch(products, 150);
        System.out.println(found2 != null ? "Found: " + found2 : "Not Found");
    }
}
