package co.com.gm.animal.negocio;

import java.util.ArrayList;
import java.util.List;

import co.com.gm.animal.datos.AccesoDatosImpl;
import co.com.gm.animal.datos.IAccesoDatos;
import co.com.gm.animal.domain.Animal;
import co.com.gm.animal.excepciones.AccesoDatosEx;
import co.com.gm.animal.excepciones.EscrituraDatosEx;
import co.com.gm.animal.excepciones.LecturaDatosEx;

public class AnimalNegocioImpl implements IAnimalNegocio {
	
	
	IAccesoDatos datos= new AccesoDatosImpl();

	@Override
	public void iniciarZoo(String nombreArchivo) {
		try {
			datos.crear(nombreArchivo);
		} catch (AccesoDatosEx e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void escribirAnimal(String nombreArchivo, Animal animal) {
		boolean anexar=false;
		try {
			anexar=datos.existe(nombreArchivo);
			datos.escribir(nombreArchivo, animal,anexar);
		} catch (EscrituraDatosEx e) {
			e.printStackTrace();
		}catch(AccesoDatosEx ex) {
			ex.printStackTrace();
		}	
	}

	@Override
	public void listarAnimal(String nombreArchivo) {
		List<Animal> listar= new ArrayList<Animal>();
		try {
			listar=datos.listar(nombreArchivo);
			for(Animal elementos:listar) {
				System.out.println(elementos.toString());
			}
		} catch (LecturaDatosEx e) {
			e.printStackTrace();
		}
	}

	@Override
	public void buscarAnimal(String nombreArchivo, String buscar) {
		String resultado=null;
		try {
			resultado=datos.buscar(nombreArchivo, buscar);
			System.out.println(resultado);
		} catch (LecturaDatosEx e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void borrarArchivo(String nombreArchivo) {
		datos.borrar(nombreArchivo);	
	}
}
