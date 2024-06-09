package grupoC;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class GrupoC_System extends GrupoC_Products {
    private List<Product> car;
    Scanner scanner = new Scanner (System.in);
    public GrupoC_System(String name, String lastName, String address, String gmail, String telf) {
        super(name, lastName, address, gmail, telf);
        car = new ArrayList<>();  
    }
    public void makeOrder() {
        System.out.println("Seleccione el producto que desea agregar al carrito (Ingrese el número):");
        List<Product> products = getListProducts();
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getname() + " - Precio: $" + products.get(i).getprize() + " - Stock: " + products.get(i).getStock());
        }
        int option = scanner.nextInt();
        if (option >= 1 && option <= products.size()) {
            Product selectedProduct = products.get(option - 1);
            if (selectedProduct.getStock() > 0) {
                car.add(selectedProduct);
                selectedProduct.setStock(selectedProduct.getStock() - 1);
                System.out.println("Producto agregado al carrito.");
            } else {
                System.out.println("El producto seleccionado no tiene stock disponible.");
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }
    public void cancelOrder() {
        for (Product product : car) {
            product.setStock(product.getStock() + 1);
        }
        car.clear();
        System.out.println("Pedido cancelado.");
    }
    public void makeBill() {
        System.out.println("Factura:");
        printdata();
        double total = 0;
        for (Product product : car) {
            product.showInfo();
            total += product.getprize();
        }
        System.out.println("Total a pagar: $" + total);
    }
}