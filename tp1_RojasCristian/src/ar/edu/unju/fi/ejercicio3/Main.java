package ar.edu.unju.fi.ejercicio3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Ejercicio 3
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese un número entero: ");
		int nro = sc.nextInt();
		
		if (nro % 2 != 0) {
			System.out.println("El número ingresado es impar. El doble del nro es: " + nro * 2);
		}else {
			System.out.println("El número ingresado es par. El triple del nro es: " + nro * 3);
		}
	}

}
