package interfazUsuario;

import javax.swing.JOptionPane;

import co.com.gm.animal.domain.Animal;
import co.com.gm.animal.negocio.AnimalNegocioImpl;
import co.com.gm.animal.negocio.IAnimalNegocio;



public class Interfaz {
	
	public static void main(String [] args) {
		int opcion=-1;
		String nombre=null;
		String especie=null;
		String caracteristicas=null;
		String gusto=null;
		String buscar=null;
		String nombreArchivo="C:\\javaEclipseEjercicios\\animalZoo.txt";
		IAnimalNegocio negocio= new AnimalNegocioImpl();
		
		while(opcion!=0) {
			System.out.println("Ingrese una opción"
					+ "\n1 Iniciar el programa"
					+ "\n2 Ingresar un animal"
					+ "\n3 Listar animales"
					+ "\n4 Buscar animal"
					+ "\n0 salir de programa");
			
			opcion=Integer.parseInt(JOptionPane.showInputDialog("Ingresar Opción"));
			
			switch(opcion) {
			
			case 1:
				negocio.iniciarZoo(nombreArchivo);
				break;
			case 2:
				nombre=JOptionPane.showInputDialog("Ingrese el nombre del animal");
				especie=JOptionPane.showInputDialog("Ingrese la especie del animal");
				caracteristicas=JOptionPane.showInputDialog("Ingrese las carácteristcicas del animal");
				gusto=JOptionPane.showInputDialog("Ingrese lo que más le gustó del animal");
				
				Animal animal= new Animal(nombre,especie,caracteristicas, gusto);
				negocio.escribirAnimal(nombreArchivo, animal);
				break;
			case 3:
				negocio.listarAnimal(nombreArchivo);
				break;
			case 4:
				buscar=JOptionPane.showInputDialog("Ingrese el nombre del animal que desea buscar");
				negocio.buscarAnimal(nombreArchivo, buscar);
				break;
			case 0:
					System.out.println("Has salido del programa, hasta pronto");
				break;
			default:
				System.out.println("No has escogido una opción válida");		
			}	
		}
		
	}

}
