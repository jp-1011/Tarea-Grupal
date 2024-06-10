package grupoC;
import java.util.Scanner;
public class GrupoC_User {
	Scanner cin = new Scanner(System.in);
	public String name;
	public String lastName;
	public String address;
	protected String gmail;
	protected String telf;
	public GrupoC_User (String name, String lastName, String address, String gmail, String telf) {
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.gmail = gmail;
		this.telf = telf;
	}
	public void dataUser() {
        do {
            System.out.println("Ingrese su nombre:");
            name = cin.nextLine();
            if (!isValidName(name)) {
                System.out.println("Nombre inválido. Solo se permiten letras y espacios.");
            }
        } while (!isValidName(name));
        do {
            System.out.println("Ingrese su apellido:");
            lastName = cin.nextLine();
            if (!isValidName(lastName)) {
                System.out.println("Apellido inválido. Solo se permiten letras y espacios.");
            }
        } while (!isValidName(lastName));
        do {
            System.out.println("Ingrese su direccion:");
            address = cin.nextLine();
            if (address.isEmpty()) {
                System.out.println("La dirección no puede estar vacía.");
            }
        } while (address.isEmpty());
        do {
            System.out.println("Ingrese su correo:");
            gmail = cin.nextLine();
            if (!isValidEmail(gmail)) {
                System.out.println("Correo inválido. Por favor ingrese un correo válido.");
            }
        } while (!isValidEmail(gmail));
        do {
            System.out.println("Ingrese su telefono:");
            telf = cin.nextLine();
            if (!isValidPhone(telf)) {
                System.out.println("Teléfono inválido. Por favor ingrese un número de teléfono válido.");
            }
        } while (!isValidPhone(telf));
    }
    private boolean isValidName(String name) {
        return name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }
    private boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }
	
	public void printdata() {	
		System.out.println("Su nombre es:" + name);
		System.out.println("Su apellido es:" + lastName);
		System.out.println("Su direccion es:" + address);
		System.out.println("Su correo es:" + gmail);
		System.out.println("Su telefono es:" + telf);
		}
}
