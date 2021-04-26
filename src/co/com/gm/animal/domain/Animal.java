package co.com.gm.animal.domain;

public class Animal {
	private String nombre;
	private String especie;
	private String caracteristicas;
	private String gusto;
	
	public Animal() {};
	
	public Animal(String nombre, String especie, String caracteristicas, String gusto) {
		this.nombre=nombre;
		this.especie=especie;
		this.caracteristicas=caracteristicas;
		this.gusto=gusto;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setEspecie(String especie) {
		this.especie=especie;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas=caracteristicas;
	}
	
	public String getCaracteristicas() {
		return caracteristicas;
	}
	
	public void setGusto(String gusto) {
		this.gusto=gusto;
	}
	
	public String getGusto() {
		return gusto;
	}

	@Override
	public String toString() {
		
		String resultado=null;
		
		if(especie==null && caracteristicas==null && gusto==null) {
			resultado=nombre;
		}else {
			resultado="Animal " + nombre + " especie " + especie + " caracteristicas " + caracteristicas + "  gusto "
					+ gusto;
		}
		
		return  resultado;
	}

	
}
