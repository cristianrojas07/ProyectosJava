package ar.edu.unju.fi.ejercicio12.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio12.model.Persona;

public class Main {

	public static void main(String[] args) {
		// Ejercicio 12
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Ingrese su nombre: ");
		String nombre = sc.nextLine();
		
		System.out.print("Ingrese fecha de nacimiento(dd/mm/yyyy): ");
		String fechaDeNacimientoString = sc.nextLine();
		sc.close();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Calendar fechaNacimiento = Calendar.getInstance();
		
		try {
			fechaNacimiento.setTime(formatter.parse(fechaDeNacimientoString));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Persona persona = new Persona();
		persona.setFechaNacimiento(fechaNacimiento);
		persona.setNombre(nombre);
		
		System.out.println(persona);
		System.out.println("Edad: " + persona.calcularEdad() + " años");
		System.out.println("Signo del zodiaco: " + persona.obtenerSignoZodiaco());
		System.out.println("Estación: " + persona.obtenerEstacion());
	}

}
