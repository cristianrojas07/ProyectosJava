package ar.edu.unju.fi.ejercicio13.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Ejercicio 13
		
		int[] arrayInt = new int[8];
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < arrayInt.length; i++) {
			System.out.print("Ingrese un valor, para el índice " + i + ": ");
			arrayInt[i] = sc.nextInt();
		}

		System.out.println("");
		System.out.println("-- Contenido del array --");
		for (int i = 0; i < arrayInt.length; i++) {
			System.out.println("Índice: " + i + " - Valor: " + arrayInt[i]);
		}
	}
}
