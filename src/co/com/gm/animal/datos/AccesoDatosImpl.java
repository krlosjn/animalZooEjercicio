package co.com.gm.animal.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import co.com.gm.animal.domain.Animal;
import co.com.gm.animal.excepciones.EscrituraDatosEx;

public class AccesoDatosImpl implements IAccesoDatos{

	@Override
	public void crear(String nombreArchivo) {
		
		File archivo= new File(nombreArchivo);	
		try {
			PrintWriter salida= new PrintWriter(archivo);
			System.out.println("Se ha creado el archivo con éxito");
			salida.close();
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public boolean existe(String nombreArchivo) {
		File archivo= new File(nombreArchivo);
		return archivo.exists();
	}
	
	@Override
	public void escribir(String nombreArchivo, Animal animal, boolean anexar) throws EscrituraDatosEx {
		File archivo= new File(nombreArchivo);
		try {
			PrintWriter salida= new PrintWriter(new FileWriter(archivo,anexar));
			salida.println(animal.toString());
			System.out.println("Se ha escrito información en el archivo ");
			salida.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}



	@Override
	public List<Animal> listar(String nombreArchivo) {
		File archivo= new File(nombreArchivo);
		List<Animal> listarAnimal= new ArrayList<Animal>();
		int indice=1;
		String lineas=null;
		try {
			BufferedReader memoria= new BufferedReader(new FileReader(archivo));
			lineas=memoria.readLine();
			while(lineas!=null) {
				Animal animal= new Animal(lineas,null,null,null);
				listarAnimal.add(animal);
				lineas=memoria.readLine();
				indice++;
			}			
			memoria.close();
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return listarAnimal;
	}

	@Override
	public String buscar(String nombreArchivo, String buscar) {
		File archivo= new File(nombreArchivo);
		String lineas=null;	
		String resultado=null;
		int indice=1;
		try {
			BufferedReader memoria= new BufferedReader(new FileReader(archivo));
			lineas=memoria.readLine();
			while(lineas!=null) {
				if(lineas.contains(buscar)) {
					//System.out.println("Se ha encontrado el animal " + buscar + "en el índice ");
					resultado=lineas;
				}	
				lineas=memoria.readLine();
				indice++;
			}
			memoria.close();		
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}	
		return resultado;
	}

	@Override
	public void borrar(String nombreArchivo) {
		File archivo= new File(nombreArchivo);	
		if(archivo.exists()==true) {
			archivo.delete();
			System.out.println("Archivo borrado con éxito");
		}else {
			System.out.println("No hay archivo que eliminar");	
		}
	}

	
	
}
