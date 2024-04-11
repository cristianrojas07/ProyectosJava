package ar.edu.unju.fi.ejercicio7.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio7.model.Empleado;

public class Main {

	public static void main(String[] args) {
		// Ejercicio 7
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese nombre del empleado: ");
		String nombre = sc.nextLine();
		System.out.print("Ingrese legajo del empleado: ");
		String legajo = sc.nextLine();
		System.out.print("Ingrese salario del empleado: ");
		double salario = sc.nextDouble();
		sc.close();
		Empleado empleado = new Empleado(nombre, legajo, salario);
		System.out.println("");
		System.out.println(empleado);
		
		empleado.darAumentoDeSalario();
		System.out.println("");
		System.out.println("Empleado con salario aumentado: ");
		System.out.println(empleado);
	}

}
