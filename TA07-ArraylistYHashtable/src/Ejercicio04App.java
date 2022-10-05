import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ejercicio04App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String, double[]> stock = new Hashtable<String, double[]>();
		stock.put("pan", new double[] {0.33, 22});
		stock.put("jamon", new double[] {5, 9});
		stock.put("queso", new double[] {2.99, 12});
		stock.put("arroz", new double[] {0.50, 35});
		stock.put("leche", new double[] {1, 30});
		stock.put("azucar", new double[] {0.80, 20});
		stock.put("aceite", new double[] {12, 4});
		stock.put("macarrones", new double[] {0.99, 7});
		stock.put("tomate", new double[] {0.99, 15});
		stock.put("lechuga", new double[] {1.20, 5});
		Hashtable<String, double[]> carrito = new Hashtable<String, double[]>();
		
		mostrarMenu(stock, carrito);
		double total = mostrarCarrito(carrito);
		pagarCuenta(total);
	}
	
	public static Hashtable<String, double[]> mostrarMenu(Hashtable<String, double[]> stock, Hashtable<String, double[]> carrito) {
		boolean continuar = true;
		String key;
		double precio;
		double cantidad;
		System.out.println("1-Mostrar todos los productos");
		System.out.println("2-Mostrar un producto");
		System.out.println("3-Añadir un producto");
		System.out.println("4-Añadir artículo al carrito");
		System.out.println("5-Salir");
		
		while(continuar) {
			switch(Integer.parseInt(JOptionPane.showInputDialog("Elige una opción"))) {
			case 1:
				//consultar todos productos del hashmap
				verProductos(stock);
				break;
			case 2:
				//consultar un producto en concreto  a través de su key
				key = JOptionPane.showInputDialog("Introduce el nombre del producto");
				verProducto(stock, key);
				break;
			case 3:
				//pido los datos al usuario para añadir un producto al hashtable
				String nombre = JOptionPane.showInputDialog("Introduce el nombre del producto");
				precio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del producto"));
				cantidad = Double.parseDouble(JOptionPane.showInputDialog("Introduce el stock disponible"));
				stock.put(nombre, new double[] {precio, cantidad});
				break;
			case 4:
				//pido al usuario el artículo que quiere comprar y qué cantidad
				key = JOptionPane.showInputDialog("Introduce el nombre del producto");
				cantidad = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad que quieres comprar"));
				//busco el artículo en el array que controla el stock, consulto su precio y actualizo su stock
				double[] atributos = (double[]) stock.get(key);
				precio = atributos[0];
				atributos[1] = atributos[1]-cantidad;
				stock.put(key, atributos);
				//asigno el precio recuperado del listado de stock y la cantidad que el cliente quiere comprar al carrito
				carrito.put(key, new double[] {precio, cantidad});
				break;
			case 5:
				//si el usuario introduce el 4 continuar pasa a true y sale del bucle
				continuar=false;
				break;
			default:
				//si no introduce cualquier de las otras opciones, se vuelve a mostrar el diálogo para elegir una opción
				System.out.println("Opción no reconocida, vuelva a intentarlo");
				break;
			}
		}
		return carrito;
	}
	
	//paso por parámetros el hashtable y la recorro con un foreach para mostrar los datos del producto
	public static void verProductos(Hashtable<String, double[]> stock) {
		stock.forEach((key, value) -> {
			System.out.println(key+": precio = "+value[0]+", cantidad = "+value[1]);
		});	
	}
	
	//muestro un producto del hashtable buscándolo a partir de su key y muestro los datos
	public static void verProducto(Hashtable<String, double[]> stock, String key) {
		double[] atributos = stock.get(key);
		System.out.println(key+": precio = "+atributos[0]+", cantidad = "+atributos[1]);
	}
	
	//Muestra los elementos del carrito y calcula el total a pagar
	public static double mostrarCarrito(Hashtable<String, double[]> stock) {
		double total = 0.00;
		Enumeration<String> llaves = stock.keys();
		System.out.println("Su carrito: ");
		while(llaves.hasMoreElements()) {
			String key = llaves.nextElement();
			double[] atributos = (double[]) stock.get(key);
			double precio =  atributos[0];
			double cantidad = atributos[1];
			total = total+(precio*cantidad);
			System.out.println(key+": precio = "+precio+", cantidad = "+cantidad);
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
