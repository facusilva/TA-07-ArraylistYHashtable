import java.util.*;

import javax.swing.JOptionPane;

public class Ejercicio01App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String, Integer> alumnos = new Hashtable<String, Integer>();
		double notamedia = asignarNotas(alumnos);
		mostrarNotas(alumnos, notamedia);
	}
	
	//pido al usuario el nombre y la nota del alumno para añadirlo al hashtable
	public static double asignarNotas(Hashtable alumnos) {
		int media = 0;
		for(int i = 0; i<4;i++) {
			String alumno = JOptionPane.showInputDialog("Nombre del alumno: ");
			int nota = Integer.parseInt(JOptionPane.showInputDialog("Nota del alumno: "));
			media = media+nota;
			alumnos.put(alumno, nota);
		}
		return media/(double)alumnos.size();
	}

	//recorro el hashtable con un enumerador y muestro la nota de cada alumno, finalmente muestro la nota media.
	public static void mostrarNotas(Hashtable alumnos, double notamedia ) {
		Enumeration<String> llaves = alumnos.keys();
		while(llaves.hasMoreElements()) {
			String key = llaves.nextElement();
			System.out.println("El alumno "+key+" nota "+alumnos.get(key));
		}
		System.out.println("La nota media de los alumnos és: "+notamedia);
	}
}
