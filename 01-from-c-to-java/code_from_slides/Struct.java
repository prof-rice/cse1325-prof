class Product { // struct
  String name;
  double price;
}

public class Struct {
    public static void main(String[] args) {
        Product product = new Product();
        product.name = "Broccoli";
        product.price = 1.39;
        System.out.println(product.name + 
                    " $" + product.price);
    }
}
