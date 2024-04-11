package ar.edu.unju.fi.ejercicio8.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio8.model.CalculadoraEspecial;

public class Main {

	public static void main(String[] args) {
		// Ejercicio 8
		Scanner sc = new Scanner(System.in);
		
		CalculadoraEspecial calculadora = new CalculadoraEspecial();
		System.out.print("Escriba el valor de N: ");
		int n = sc.nextInt();
		sc.close();
		
		calculadora.setN(n);
		System.out.println("La sumatoria para N: " + n + " es: " + calculadora.calcularSumatoria());
		System.out.println("La productoria para N: " + n + " es: " + calculadora.calcularProductoria());
	}

}
