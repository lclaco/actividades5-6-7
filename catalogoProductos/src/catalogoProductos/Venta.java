/**
 * 
 */
package catalogoProductos;

import java.util.ArrayList;
import java.util.Calendar;




/**
 * @author Infoseg
 *
 */
public class Venta {

		private Calendar fecha = Calendar.getInstance();
		private ArrayList<Detalle> Detalles = new ArrayList<>();
				
		/**
		 * 
		 */
		public Venta() {
		}

		/**
		 * @param fecha
		 * @param detalles
		 */
		public Venta(Calendar fecha, ArrayList<Detalle> detalles) {
			this.fecha = fecha;
			Detalles = detalles;
		}

		/**
		 * @return the fecha
		 */
		public Calendar getFecha() {
			return fecha;
		}

		/**
		 * @param fecha the fecha to set
		 */
		public void setFecha(Calendar fecha) {
			this.fecha = fecha;
		}

		/**
		 * @return the detalles
		 */
		public ArrayList<Detalle> getDetalles() {
			return Detalles;
		}

		/**
		 * @param detalles the detalles to set
		 */
		public void setDetalles(ArrayList<Detalle> detalles) {
			Detalles = detalles;
		}
		
		@Override
		public String toString() {
			return "Venta [fecha=" + fecha + ", Detalles=" + Detalles + "]";
		}

		/**
		 * 
		 * @return calculo total de la Venta
		 */
		public int calcularTotal() {
			int total =0;
			for (Detalle DetalleTotal : Detalles) {
				total = total + DetalleTotal.calcularSubTotal();
			}
			return total;			
		}
		
		public void agregarDetalle(Detalle Detalles) {
			this.Detalles.add(Detalles);
		}
}
