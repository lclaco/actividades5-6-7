/**
 * 
 */
package main;


import java.util.ArrayList; //import de la clase ArrayList
import java.util.Scanner; //import de la clase Scanner

import catalogoProductos.Detalle; //import de la clase Detalle
import catalogoProductos.Producto; //import de la clase Producto
import catalogoProductos.Venta;//import de la clase Venta



/**
 * @author Infoseg
 *
 */
public class Main {

	/**
	 * Creo una coleccion de Producto
	 */
	private static ArrayList<Producto> productos = new ArrayList<>();
	/**
	 * Creo una coleccion de Venta
	 */
	
	private static ArrayList<Venta> ventas = new ArrayList<Venta>();
	
	/**
	 * Declarar el objeto  Scanner e inicializar
     * 
	 */	
	static Scanner scanner = new Scanner(System.in);
	
	
	/**
	 * Inicializar el menu
	 */
	public final static int OPCION_MENU_CREAR = 1;
	public final static int OPCION_MENU_PRODUCTOS = 2;
	public final static int OPCION_MENU_ELIMINAR = 3;
	public final static int OPCION_MENU_ACTUALIZAR = 4;
	public final static int OPCION_MENU_CARRO = 5;
	public final static int OPCION_MENU_IMPRIMIR = 6;	
	public final static int OPCION_MENU_SALIR = 7;
	
	
	/**
	 * @param args
	 * llamado al metodo menu
	 */
	public static void main(String[] args) {
		menu();

	}


	/**
	 * metodo menu crea un menu para el catalogo de productos
	 */
	private static void menu() {
		int opcion = 1;
		do {
			System.out.println("  Catalogo de Productos  ");
			System.out.println("*************************");
			System.out.println("1. Crear producto");			
			System.out.println("2. Ver lista de productos");			
			System.out.println("3. Eliminar Producto");
			System.out.println("4. Actualizar Producto");
			System.out.println("5. Comprar Productos");
			System.out.println("6. Emitir Boleta");
			System.out.println("7. Salir");			
			System.out.println("*************************");
			opcion = scanner.nextInt();
			
			switch(opcion) {
			case OPCION_MENU_CREAR:
				crearProductos();
				break;
			case OPCION_MENU_PRODUCTOS:
				verProductos();
				break;
			case OPCION_MENU_ELIMINAR:
				eliminarProductos();
				break;
			case OPCION_MENU_ACTUALIZAR:
				actualizarProductos();
				break;
			case OPCION_MENU_CARRO:
				agregarProductoAlCarro();
				break;
			case OPCION_MENU_IMPRIMIR:
				imprimirVentas();
				break;
			}
			
		}while(opcion != OPCION_MENU_SALIR);
		
	}

	/**
	 * se crea un nuevo producto a la lista con
	 * los atributos: categoria,descripcion,nombre,precio 
	 */
	private static void crearProductos() {
		scanner.nextLine();
		
		System.out.println("Por favor ingrese la categoria del producto");
		String categoria = scanner.nextLine();
		
		System.out.println("Por favor ingrese la descripcion del producto");
		String descripcion = scanner.nextLine();
		
		System.out.println("Por favor ingrese el nombre del producto");
		String nombre = scanner.nextLine();
		
		System.out.println("Por favor ingrese el precio del producto");
		try {
		int precio= scanner.nextInt();
		scanner.nextLine();
		
		
		Producto productoNuevo = new Producto(categoria,descripcion,nombre,precio);
		productos.add(productoNuevo);
		
		
		System.out.printf("%nSe añadio el producto '%s' de la categoria '%s' con un precio de '%d' . Su descripcion es '%s'.%n%n",
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
			System.out.printf("\n**************************\n Nombre producto: %s %n Categoria producto: %s %n Descripcion producto: %s %n Precio producto: %d %n",
					producto.getNombre(),
					producto.getCategoria(),
					producto.getDescripcion(),
					producto.getPrecio());
			System.out.println("");
		}
		
	}
	
	/**
	 * se a genera un carro de compra con
	 * los atributos: categoria,descripcion,nombre,precio 
	 * se genera la venta con el total comprado
	 */
	private static void agregarProductoAlCarro() {
		Venta venta = new Venta();
		boolean seguirAgregandoProductos = true;
		
		do {
		verProductos();
		
		System.out.println("\n\ningrese la categoria del producto que quiere comprar");
		Scanner scanner = new Scanner(System.in);
		String categoria = scanner.nextLine();
		Producto producto = buscarProducto(categoria);
		
		
		System.out.println("ingrese la cantidad quiere comprar");
		try {
			int cantidad = scanner.nextInt();
			Detalle Detalles = new Detalle(cantidad,producto);
			venta.agregarDetalle(Detalles);
		} catch (java.util.InputMismatchException ime) {
			System.out.println("\n Solo se permiten números para la cantidad \n");
		}
		System.out.println("Desea Agregar mas productos al carro: [si/no]");
		String seguirAgregandoProductosStr = scanner.next();
		
		seguirAgregandoProductos = seguirAgregandoProductosStr.equalsIgnoreCase("SI")?true:false;
		}while(seguirAgregandoProductos);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("¿La venta fue pagada? SI/NO");
		boolean ventaPagada = scanner.nextLine().equalsIgnoreCase("SI")?true:false;
		
		if (ventaPagada) {
			ventas.add(venta);
		}
		
	}
	
	/**
	 * se elimina un producto de la Lista con
	 * los atributos: categoria,descripcion,nombre,precio 
	 * se busca mediante la categoria del producto
	 */
		
	private static void eliminarProductos() {
	
			System.out.println("ingrese la categoria del producto");
			Scanner scanner = new Scanner(System.in);
			String categoria = scanner.nextLine();
			/*
			 * for(Producto p : productos) { if ( p.getCategoria().equalsIgnoreCase(categoria)) {
			 * productos.remove(p); System.out.printf("Se elimino el producto %s",
			 * p.getNombre()); }
			 */
			for (int i = 0; i < productos.size(); i++) {
                Producto get = productos.get(i);
                
                if (categoria.equals(get.getCategoria())){
                    productos.remove(i);
                    break;
                }
			
		}
	}
	
	/**
	 * 
	 * @param categoria  se busca los productos mediante su categoria
	 * @return pruducto o null
	 */
	
	
	private static Producto	buscarProducto(String categoria) {
		for(Producto producto: productos) {
			if (producto.getCategoria().equalsIgnoreCase(categoria)) {
				return producto;
			}
		}
		
		return null;
		
	}
	
	/**
	 * se actualiza un producto de la Lista con
	 * los atributos: categoria,descripcion,nombre,precio 
	 * se busca mediante la categoria del producto
	 */	
	
	private static void actualizarProductos() {
		boolean seguirModificandoProductos = true;
		
		do {
			System.out.println("ingrese la categoria del producto");
			Scanner scanner = new Scanner(System.in);
			String categoria = scanner.nextLine();
			Producto producto = buscarProducto(categoria);			
			
			System.out.println("Por favor ingrese el nuevo nombre para su producto");
			String nombreProducto = scanner.nextLine();
			producto.setNombre(nombreProducto);	
			
			System.out.println("Por favor ingrese la nueva categoria para su producto");
			String categoriaProducto = scanner.nextLine();
			producto.setCategoria(categoriaProducto);
			
			System.out.println("Por favor ingrese la nueva descripcion para su producto");
			String descripcionProducto = scanner.nextLine();
			producto.setDescripcion(descripcionProducto);
			
			try{
				System.out.println("Por favor ingrese el nuevo precio para su producto");
				int precioProducto = scanner.nextInt();
				producto.setPrecio(precioProducto);	
				
			} catch (java.util.InputMismatchException ime) {
				System.out.println("\n Solo se permiten números para la cantidad \n");
			}
			
			System.out.println("Desea modificar mas productos al carro: [si/no]");
			String seguirModificandoProductosStr = scanner.next();
			
			seguirModificandoProductos = seguirModificandoProductosStr.equalsIgnoreCase("SI")?true:false;
		
		}while(seguirModificandoProductos);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("¿Term? SI/NO");
		boolean productoActualizado = scanner.nextLine().equalsIgnoreCase("SI")?true:false;
		
		
	}
	
	/**
	 * se imprime por pantalla una boleta con
	 * la fecha/hora y cantidad vendida 	 
	 */	
	
	private static void imprimirVentas() {
		System.out.println("\n***********VENTAS***********\n");
		
		System.out.println("Fecha \t\t Monto");
		for(Venta venta: ventas) {
			System.out.printf("%td %tB %tY %tH:%tM \t $ %d %n"
			,venta.getFecha()
			,venta.getFecha()
			,venta.getFecha()
			,venta.getFecha()
			,venta.getFecha()
			,venta.calcularTotal());
			System.out.println("=============================\n");
		}
		System.out.printf("%n%n");
		
	}
	
}	
