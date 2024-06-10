package grupoC;
import java.util.ArrayList;
import java.util.List;
public class GrupoC_Products extends GrupoC_User {
    List<Product> listProducts;
    public GrupoC_Products(String name, String lastName, String address, String gmail, String telf) {
        super(name, lastName, address, gmail, telf);
        listProducts = new ArrayList<>();
        initializeProducts();
    }
    private void initializeProducts() {
    	listProducts.add(new ProductGourmet("Cacao Fino de Aroma", 15.50, 5));
    	listProducts.add(new ProductGourmet("Café de Altura", 12.00, 5));
    	listProducts.add(new ProductGourmet("Queso de Hoja", 8.50, 5));
    	listProducts.add(new ProductGourmet("Chocolate Orgánico", 10.00, 5));
    	listProducts.add(new ProductGourmet("Miel de Abeja Pura", 7.25, 5));
    	listProducts.add(new ProductGourmet("Vino de Uva Isabella", 20.00, 5));
    	listProducts.add(new ProductGourmet("Aceite de Aguacate", 22.50, 5));
    	listProducts.add(new ProductGourmet("Mermelada de Mortiño", 6.75, 5));
    	listProducts.add(new ProductGourmet("Panela Granulada", 5.00, 5));
    	listProducts.add(new ProductGourmet("Chifles de Plátano", 3.50, 5));
    }
    public List<Product> getListProducts() {
        return listProducts;
    }
    public void showProducts() {
        for (Product product : listProducts) {
            product.showInfo();
        }
    }
}
abstract class Product {
    private String name;
    private double prize;
    private int stock;
    public Product (String name, double prize, int stock) {
        this.name = name;
        this.prize = prize;
        this.stock = stock;
    }
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }
    public double getprize() {
        return prize;
    }
    public void setprize(double prize) {
        this.prize = prize;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public abstract void showInfo();
}
class ProductGourmet extends Product {
    public ProductGourmet(String name, double prize, int stock) {
        super(name, prize, stock);
    }
    @Override
    public void showInfo() {
        System.out.println("Producto: " + getname() + ", Precio: $" + getprize() + ", Stock: " + getStock());
    }
}
