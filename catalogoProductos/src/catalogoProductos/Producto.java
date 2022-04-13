/**
 * 
 */
package catalogoProductos;

/**
 * @author Infoseg
 *
 */
public class Producto {	

		
	
		private String categoria,nombre,descripcion;
		private int precio;
		
		/**
		 *constructor con parámetros de la clase Producto
		 * @param categoria categoria del producto
		 * @param nombre	nombre del producto
		 * @param descripcion descripcion del producto
		 * @param precio precio del producto
		 */
		public Producto(String categoria, String nombre, String descripcion, int precio) {
			this.categoria = categoria;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.precio = precio;
		}
		/**
		 * constructor sin parámetros de la clase Producto
		 */
		Producto() {
		}
		
		/**
		 * Accesador de la categoria del producto
		 * @return categoria del producto
		 */
		public String getCategoria() {
			return categoria;
		}
		/**
		 * mutador de la categoria del producto
		 * @param categoria del producto
		 */
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
		/**
		 * Accesador del nombre del producto
		 * @return nombre del producto
		 */
		public String getNombre() {
			return nombre;
		}
		/**
		 * mutador del nombre del producto
		 * @param nombre del producto
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		/**
		 * Accesador de la descripcion del producto
		 * @return descripcion del producto
		 */
		public String getDescripcion() {
			return descripcion;
		}
		/**
		 * mutador de la descripcion del producto
		 * @param descripcion del producto
		 */
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		/**
		 * Accesador del precio del producto
		 * @return precio del producto
		 */
		public int getPrecio() {
			return precio;
		}
		/**
		 * mutador del precio del producto
		 * @param precio del producto
		 */
		public void setPrecio(int precio) {
			this.precio = precio;
		}
		
		/**
		 * Representacion en String de un objeto de la clase Producto
		 * @return String con la representacion de un objeto de la clase Producto
		 */		
		@Override
		public String toString() {
			return "Producto [categoria=" + categoria + ", nombre=" + nombre + ", descripcion=" + descripcion
					+ ", precio=" + precio + "]";
		}
		
		
		
		
}
	
