package ar.edu.unju.fi.ejercicio4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Ejercicio 4
		Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce un número entre 0 y 10 para calcular su factorial:");
        int nro = sc.nextInt();
        
        if (nro >= 0 && nro <= 10) {
            int factorial = 1;
            int i = 1;
            while (i <= nro) {
                factorial *= i;
                i++;
            }
            System.out.println("El factorial de " + nro + " es: " + factorial);
        } else {
            System.out.println("El número introducido no está en el rango de 0 a 10.");
        }
        
        sc.close();
	}

}
