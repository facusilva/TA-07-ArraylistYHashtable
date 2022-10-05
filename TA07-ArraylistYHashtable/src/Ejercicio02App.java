import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ejercicio02App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String, double[]> carrito = new Hashtable<String, double[]>();
		agregarAlCarrito(carrito);
		double total = mostrarProductos(carrito);
		pagarCuenta(total);

	}
	
	//pide al usuario que escriba el nombre y los atributos de un producto hasta que el usuario 
	public static void agregarAlCarrito( Hashtable carrito) {
		boolean continuar = true;
		String nombre;
		do {
			nombre = JOptionPane.showInputDialog("Escribe el nombre del producto o escribe cancelar para terminar");
			if(!nombre.equalsIgnoreCase("cancelar")) {
				double[] atributos = new double[4];
				atributos[0] = Double.parseDouble(JOptionPane.showInputDialog("Indica el precio bruto "));
				atributos[1] = Double.parseDouble(JOptionPane.showInputDialog("Indica el IVA "));
				atributos[2] = Double.parseDouble(JOptionPane.showInputDialog("Indica la cantidad "));
				atributos[3] = atributos[0] + (atributos[0]*atributos[1]);
				carrito.put(nombre, atributos);
			}else {
				continuar=false;
			}
		}while(continuar);
	}
	
	//Muestra los elementos del carrito y calcula el total a pagar
	public static double mostrarProductos( Hashtable carrito ) {
		Enumeration<String> llaves = carrito.keys();
		System.out.println("Lista de productos: ");
		double total = 0.0;
		while(llaves.hasMoreElements()) {
			String key = llaves.nextElement();
			double[] atributos = (double[]) carrito.get(key);
			double preciobruto = atributos[0];
			double IVA = atributos[1];
			double cantidad = atributos[2];
			double precio =  atributos[3];
			total = total+(precio*cantidad);
			System.out.println(key+": precio bruto = "+preciobruto+", IVA = "+IVA+", precio+IVA = "+precio+", cantidad = "+cantidad);
		}
		return total;
	}
	
	//teniendo en cuenta el total acumulado por los artículos del carrito, se le pide al usuario que introduzca dinero hasta que haya
	//igualado o superado el total a pagar, luego se le muestra el cambio
	public static void pagarCuenta( double total ) {
		double pagado = 0.00;
		while(pagado<total) {
			System.out.println("A pagar: "+(total-pagado));
			pagado = pagado + Double.parseDouble(JOptionPane.showInputDialog("Introduce el dinero "));
		}
		System.out.println("Cambio: "+Math.round((pagado-total)*100.0)/100.0);
	}
	
	

}
