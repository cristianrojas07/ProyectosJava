package ar.edu.unju.fi.ejercicio16.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Ejercicio 16
		String[] arrayString = new String[5];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arrayString.length; i++) {
			System.out.print("Ingrese el nombre de una persona: ");
			arrayString[i] = sc.nextLine();
		}
		
		
		System.out.println("\nValores del array:");
		int i = 0;
		while (i < arrayString.length) { 
			System.out.print(" | " + arrayString[i] + " | ");
			i++;
		}
		
		System.out.println("\n\nTamaño del array: " + arrayString.length);
		byte indice;
        do {
            System.out.println("\nIngrese el índice del elemento a eliminar (0-" + (arrayString.length - 1) + ").");
            System.out.print("Si ingresa un valor fuera del rango, se termina la ejecución: ");
            indice = sc.nextByte();
            
            if (indice < 0 || indice >= arrayString.length) break;
            
            // realizar el desplazamiento
            for (byte j = indice; j < arrayString.length - 1; j++) {
            	arrayString[j] = arrayString[j + 1];
            }
            
            // al ultimo valor asigno espacio en blanco
            arrayString[arrayString.length - 1] = "";
            
            System.out.println("\nNuevo arreglo: ");
            for (int k = 0; k < arrayString.length; k++) {
            	System.out.print(" | " + arrayString[k] + " | ");
			}
        
            System.out.println("");
        } while (indice >= 0 && indice < arrayString.length);
        
        sc.close();
        
        System.out.println("Se terminó la ejecución del programa.");
	}

}

