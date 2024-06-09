package grupoC;
import java.util.Scanner;
public class GrupoC_User {
	Scanner cin = new Scanner(System.in);
	public String name;
	public String lastName;
	public String address;
	public String gmail;
	public String telf;
	public GrupoC_User (String name, String lastName, String address, String gmail, String telf) {
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.gmail = gmail;
		this.telf = telf;
	}
	public void dataUser() {
		System.out.println("Ingrese su nombre:");
		name = cin.nextLine();
		System.out.println("Ingrese su apellido:");
		lastName = cin.nextLine();
		System.out.println("Ingrese su direccion:");
		address = cin.nextLine();
		System.out.println("Ingrese su correo:");
		gmail = cin.nextLine();
		System.out.println("Ingrese su telefono:");
		telf = cin.nextLine();
	}
	public void printdata() {	
		System.out.println("Su nombre es:" + name);
		System.out.println("Su apellido es:" + lastName);
		System.out.println("Su direccion es:" + address);
		System.out.println("Su correo es:" + gmail);
		System.out.println("Su telefono es:" + telf);
		}
}