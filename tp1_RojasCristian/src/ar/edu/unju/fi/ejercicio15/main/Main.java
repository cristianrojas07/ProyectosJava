package ar.edu.unju.fi.ejercicio15.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Ejericicio 15
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese un nro entero entre [5, 10]: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		String[] arrayString = new String[n];
		
		for (int i = 0; i < arrayString.length; i++) {
			System.out.print("Por favor ingrese el nombre de una persona: ");
			arrayString[i] = sc.nextLine();
		}
		
		sc.close();
		System.out.println("\nFor creciente");
		for (int i = 0; i < arrayString.length; i++) {
			System.out.println("Posición: " + (i+1) + " - Valor: " + arrayString[i]);
		}
		
		System.out.println("\nFor decreciente");
		for (int i = arrayString.length; i > 0; i--) {
			System.out.println("Posición: " + i + " - Valor: " + arrayString[i-1]);
		}
	}

}
