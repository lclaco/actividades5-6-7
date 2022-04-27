/**
 * 
 */
package catalogoProductos;



/**
 * @author Infoseg
 *
 */
public class Detalle {
	private int cantidad;
	private Producto producto;
			
	/**
	 * 
	 */
	public Detalle() {
	}

	
	/**
	 * @param cantidad
	 * @param producto
	 */
	public Detalle(int cantidad, Producto producto) {
		this.cantidad = cantidad;
		this.producto = producto;
	}


	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}


	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}


	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	
	
	@Override
	public String toString() {
		return "Detalle [cantidad=" + cantidad + ", producto=" + producto + "]";
	}


	/**
	 * 
	 * @return el subtotal de la compra
	 */
	
	public int calcularSubTotal() {
		return cantidad * producto.getPrecio();
	}
}
