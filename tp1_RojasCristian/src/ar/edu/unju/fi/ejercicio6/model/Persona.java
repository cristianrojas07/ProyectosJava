package ar.edu.unju.fi.ejercicio6.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Persona {
	private String dni;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String provincia;

	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	public Persona(String dni, String nombre, LocalDate fechaNacimiento, String provincia) {
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.provincia = provincia;
	}
	
	public Persona(String dni, String nombre, LocalDate fechaNacimiento) {
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.provincia = "Jujuy";
	}

	public int calcularEdad() {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(this.fechaNacimiento, fechaActual);
        return periodo.getYears();
	}
	
	public boolean esMayorDeEdad() {
		return this.calcularEdad() >= 18;
	}
	
	public String mostrarDatos() {
		var msj = this.toString() + "\n";
		msj += "La edad es: " + this.calcularEdad() + "\n";
		
		if (this.esMayorDeEdad()) {
			msj += "La persona es mayor de edad";
		}else {
			msj += "La persona es menor de edad";
		}
		
		return msj;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", fechaNacimiento=" + formatter.format(fechaNacimiento) + ", provincia=" + provincia + "]";
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	
}
