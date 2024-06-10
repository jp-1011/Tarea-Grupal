package grupoC;
import java.util.ArrayList;
import java.io.*;
import java.util.List;
import java.util.Scanner;
public class GrupoC_System extends GrupoC_Products {
    List<Product> car;
    private String linea;
    Scanner scanner = new Scanner (System.in);
    public GrupoC_System(String name, String lastName, String address, String gmail, String telf,String linea) {
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
    public void guardarFacturaEnCSV(String archivo) {
    	 try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
    	        writer.println("Nombre,Apellido,Direccion,Correo,Telefono,Producto,Precio,Stock");
    	        double totalPrecio = 0; // Variable para almacenar el precio total
    	        for (Product product : car) {
    	            writer.println(name + "," + lastName + "," + address + "," + gmail + "," + telf + "," + 
    	                           product.getname() + "," + product.getprize() + "," + product.getStock());
    	            totalPrecio += product.getprize(); 
    	        }
    	        writer.println("Total:" + totalPrecio);
    	        System.out.println("Factura guardada en " + archivo);
    	    } catch (IOException e) {
    	        System.out.println("Error al guardar la factura en CSV: " + e.getMessage());
    	    }
    }
    public void guardarFacturaEnJSON(String archivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            writer.println("{");
            writer.println("  \"nombre\": \"" + name + "\",");
            writer.println("  \"apellido\": \"" + lastName + "\",");
            writer.println("  \"direccion\": \"" + address + "\",");
            writer.println("  \"correo\": \"" + gmail + "\",");
            writer.println("  \"telefono\": \"" + telf + "\",");
            writer.println("  \"totalPrecio\": " + calcularTotalPrecio() + ",");
            writer.println("  \"productos\": ");
            int size = car.size();
            int count = 0;
            for (Product product : car) {
                writer.println("    {");
                writer.println("      \"nombreProducto\": \"" + product.getname() + "\",");
                writer.println("      \"precio\": " + product.getprize() + ",");
                writer.println("      \"stock\": " + product.getStock());
                writer.println("    }" + (++count < size ? "," : ""));
            }
            writer.println("}");
            System.out.println("Factura guardada en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar la factura en JSON: " + e.getMessage());
        }
    }

    private double calcularTotalPrecio() {
        double totalPrecio = 0;
        for (Product product : car) {
            totalPrecio += product.getprize(); 
        }
        return totalPrecio;
    }
    public void leerFactura(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    
}
