package grupoC;
import java.util.Scanner;
public class GrupoC_Store {
    Scanner cin = new Scanner(System.in);
    GrupoC_System sis = new GrupoC_System(" ", " ", " ", " ", " "," ");
    private int op;
    private String archivo;
    public GrupoC_Store (int op, String archivo) {
        this.op = op; 
        this.archivo = archivo;
    }
    public void menuOptions() {
        do {
            System.out.println("1.- Ingreso de Datos");
            System.out.println("2.- Ver catálogo");
            System.out.println("3.- Ingreso de pedido");
            System.out.println("4.- Cancelación del pedido");
            System.out.println("5.- Factura");
            System.out.println("6.- Guarda en CSV"); 
            System.out.println("7.- Guardar en JSON");
            System.out.println("8.- Leer Factura");
            System.out.println("9.- Salir");
            System.out.println("Ingrese una opción:");
            op = cin.nextInt();
            cin.nextLine();
            switch (op) {
                case 1:
                	sis.dataUser();
                    System.out.println("Datos del Usuario:");
                    sis.printdata();
                    break;
                case 2:
                    System.out.println("Catálogo de productos");
                    sis.showProducts();
                    break;
                case 3:
                    System.out.println("Pedido");
                    sis.makeOrder();
                    break;
                case 4:
                    System.out.println("Cancelación del pedido");
                    sis.cancelOrder();
                    break;
                case 5:
                    System.out.println("Factura");
                    sis.makeBill();
                    break;
                case 6:
                	System.out.println("Guarda en CSV");
                    sis.guardarFacturaEnCSV("factura.csv");
                    
                    menuOptions();
                    break;
                case 7:
                	System.out.println("Guardar en JSON");
                    sis.guardarFacturaEnJSON("archivos.json");
                    menuOptions();
                    break;
                case 8:
                	System.out.println("Leer Factura");
                	sis.leerFactura(archivo);
                    break;
                case 9:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opción no válida. Ingrese nuevamente");
            }
        } while (op != 6);
    }
}
