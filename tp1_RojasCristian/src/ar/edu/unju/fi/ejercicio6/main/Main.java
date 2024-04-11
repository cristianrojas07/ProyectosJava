package ar.edu.unju.fi.ejercicio6.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio6.model.Persona;

public class Main {

	public static void main(String[] args) {
		// Ejercicio 6
		
		// Persona 1
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese los datos para la persona 1:");
		System.out.print("Ingrese dni: ");
		String dni = sc.nextLine();
		System.out.print("Ingrese nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Ingrese fecha nacimiento (dd/mm/yyyy): ");
		String fechaNacString = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(fechaNacString, formatter);
		System.out.print("Ingrese provincia: ");
		String provincia = sc.nextLine();
		
		Persona persona = new Persona();
		persona.setDni(dni);
		persona.setNombre(nombre);
		persona.setFechaNacimiento(fechaNac);
		persona.setProvincia(provincia);
		
		System.out.println(persona.mostrarDatos());
		
		// Persona 2
		System.out.println("");
		System.out.println("Ingrese los datos para la persona 2:");
		System.out.print("Ingrese dni: ");
		dni = sc.nextLine();
		System.out.print("Ingrese nombre: ");
		nombre = sc.nextLine();
		System.out.print("Ingrese fecha nacimiento (dd/mm/yyyy): ");
		fechaNacString = sc.nextLine();
		fechaNac = LocalDate.parse(fechaNacString, formatter);
		System.out.print("Ingrese provincia: ");
		provincia = sc.nextLine();
		
		Persona persona2 = new Persona(dni, nombre, fechaNac, provincia);
		System.out.println(persona2.mostrarDatos());
		
		// Persona 3
		System.out.println("");
		System.out.println("Ingrese los datos para la persona 3:");
		System.out.print("Ingrese dni: ");
		dni = sc.nextLine();
		System.out.print("Ingrese nombre: ");
		nombre = sc.nextLine();
		System.out.print("Ingrese fecha nacimiento (dd/mm/yyyy): ");
		fechaNacString = sc.nextLine();
		fechaNac = LocalDate.parse(fechaNacString, formatter);
		
		Persona persona3 = new Persona(dni, nombre, fechaNac);
		System.out.println(persona3.mostrarDatos());
	}

}
