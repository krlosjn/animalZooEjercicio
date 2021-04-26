package co.com.gm.animal.datos;

import java.util.List;

import co.com.gm.animal.domain.Animal;
import co.com.gm.animal.excepciones.*;

public interface IAccesoDatos {
	public abstract void crear(String nombreArchivo) throws AccesoDatosEx;
	public abstract  boolean existe(String nombreArchivo) throws AccesoDatosEx;
	public abstract void escribir(String nombreArchivo, Animal animal, boolean anexar) throws EscrituraDatosEx;
	public abstract  List<Animal> listar(String nombreArchivo) throws LecturaDatosEx;
	public abstract String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
	public abstract void borrar(String nombreArchivo);
}
