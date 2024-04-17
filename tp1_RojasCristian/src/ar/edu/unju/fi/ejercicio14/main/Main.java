package ar.edu.unju.fi.ejercicio14.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Ejericicio 14
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese un nro entero entre [3, 10]: ");
		int n = sc.nextInt();
		
		int[] arrayInt = new int[n];
		
		for (int i = 0; i < arrayInt.length; i++) {
			System.out.print("Por favor ingrese un nro entero: ");
			arrayInt[i] = sc.nextInt();
		}
		
		System.out.println("");
		int suma = 0;
		for (int i = 0; i < arrayInt.length; i++) {
			int valor = arrayInt[i];
			System.out.println("Posición: " + (i+1) + " - Valor: " + valor);
			suma += valor;
		}
		
		sc.close();
		System.out.println("La suma de los numeros del array es: " + suma);
	}

}
