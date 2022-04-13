/**
 * 
 */
package main;


import java.util.ArrayList; //import de la clase ArrayList
import java.util.Scanner; //import de la clase Scanner
import catalogoProductos.Producto; //import de la clase Producto

/**
 * @author Infoseg
 *
 */
public class Main {

	/**
	 * Creo una coleccion de Producto
	 */
	static ArrayList<Producto> productos = new ArrayList<>();
	
	/**
	 * Declarar el objeto  Scanner e inicializar
     * 
	 */	
	static Scanner scanner = new Scanner(System.in);
	
	
	/**
	 * Inicializar el menu
	 */
	private static final int MENU_AGREGAR_PRODUCTO = 1;
	private static final int MENU_VER_PRODUCTO = 2;
	private static final int MENU_SALIR = 3;
	
	
	
	/**
	 * @param args
	 * llamado al metodo menu
	 */
	public static void main(String[] args) {
		menu();

	}


	/**
	 * metodo menu crea un menu para el catalogo de productis
	 */
	private static void menu() {
		int opcion = 1;
		do {
			System.out.println("  Catalogo de Productos  ");
			System.out.println("*************************");
			System.out.println("1. Agregar producto");			
			System.out.println("2. Ver lista de productos");
			System.out.println("3. Salir");			
			System.out.println("*************************");
			opcion = scanner.nextInt();
			
			switch(opcion) {
				case MENU_AGREGAR_PRODUCTO:
					agregarProductos();
					break;
				case MENU_VER_PRODUCTO:
					verProductos();
					break;
				case MENU_SALIR:
					break;
			}
			
		}while(opcion != MENU_SALIR);
		
	}

	/**
	 * se agrega un nuevo producto a la lista con
	 * los atributos: categoria,descripcion,nombre,precio 
	 */
	private static void agregarProductos() {
		scanner.nextLine();
		
		System.out.println("Ingrese la categoria del producto");
		String categoria = scanner.nextLine();
		
		System.out.println("Ingrese la descripcion del producto");
		String descripcion = scanner.nextLine();
		
		System.out.println("Ingrese el nombre del producto");
		String nombre = scanner.nextLine();
		
		System.out.println("Ingrese el precio del producto");
		try {
		int precio= scanner.nextInt();
		scanner.nextLine();
		
		
		Producto productoNuevo = new Producto(categoria,descripcion,nombre,precio);
		productos.add(productoNuevo);
		
		
		System.out.printf("Se añadio el producto '%s' de la categoria '%s' con un precio de '%d' . Su descripcion es '%s' %n.",
				productoNuevo.getNombre(),
				productoNuevo.getCategoria(),
				productoNuevo.getPrecio(),
				productoNuevo.getDescripcion());
		} catch (java.util.InputMismatchException ime) {
			System.out.println("\n El precio debe ser en números \n");
		}
	}

	/**
	 * se a llaman a los productos de la lista con
	 * los atributos: categoria,descripcion,nombre,precio 
	 */
	private static void verProductos() {
		System.out.println("    Lista de productos    ");
		System.out.println("**************************");
		for(Producto producto : productos) {
			System.out.printf(" Nombre producto: %s %n Categoria producto: %s %n Descripcion producto: %s %n Precio producto: %d %n",
					producto.getNombre(),
					producto.getCategoria(),
					producto.getDescripcion(),
					producto.getPrecio());
		}
		
	}
	
}	
