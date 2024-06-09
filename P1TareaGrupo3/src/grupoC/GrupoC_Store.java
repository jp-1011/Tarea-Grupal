package grupoC;
import java.util.Scanner;
public class GrupoC_Store {
    Scanner cin = new Scanner(System.in);
    GrupoC_System sis = new GrupoC_System(" ", " ", " ", " ", " ");
    private int op;
    public GrupoC_Store (int op) {
        this.op = op;       
    }
    public void menuOptions() {
        do {
            System.out.println("1.- Ingreso de Datos");
            System.out.println("2.- Ver catálogo");
            System.out.println("3.- Ingreso de pedido");
            System.out.println("4.- Cancelación del pedido");
            System.out.println("5.- Factura");
            System.out.println("6.- Salir");
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
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opción no válida. Ingrese nuevamente");
            }
        } while (op != 6);
    }
}