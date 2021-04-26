package co.com.gm.animal.negocio;

import co.com.gm.animal.domain.Animal;

public interface IAnimalNegocio {
	
	public abstract void iniciarZoo(String nombreArchivo);
	public abstract void escribirAnimal(String nombreArchivo,Animal animal);
	public abstract void listarAnimal(String nombreArchivo);
	public abstract void buscarAnimal(String nombreArchivo, String buscar);
	public abstract void borrarArchivo(String nombreArchivo);
}
