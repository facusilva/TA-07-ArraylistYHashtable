import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ejercicio03App {

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
		
		mostrarMenu(stock);
	}
	
	public static void mostrarMenu(Hashtable<String, double[]> stock) {
		boolean continuar = true;
		System.out.println("1-Mostrar todos los productos");
		System.out.println("2-Mostrar un producto");
		System.out.println("3-Añadir un producto");
		System.out.println("4-Salir");
		while(continuar) {
			switch(Integer.parseInt(JOptionPane.showInputDialog("Elige una opción"))) {
			case 1:
				//consultar todos productos del hashmap
				verProductos(stock);
				break;
			case 2:
				//consultar un producto en concreto  a través de su key
				String key = JOptionPane.showInputDialog("Introduce el nombre del producto");
				verProducto(stock, key);
				break;
			case 3:
				//pido los datos al usuario para añadir un producto al hashtable
				String nombre = JOptionPane.showInputDialog("Introduce el nombre del producto");
				double precio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del producto"));
				double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Introduce el stock disponible"));
				stock.put(nombre, new double[] {precio, cantidad});
				break;
			case 4:
				//si el usuario introduce el 4 continuar pasa a true y sale del bucle
				continuar=false;
				break;
			default:
				//si no introduce cualquier de las otras opciones, se vuelve a mostrar el diálogo para elegir una opción
				System.out.println("Opción no reconocida, vuelva a intentarlo");
				break;
			}
		}
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

}
