package ar.edu.unju.fi.ejercicio5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        // Ejercicio 5
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese un número entre 1 y 9:");
        int nro = sc.nextInt();
        
        if (nro >= 1 && nro <= 9) {
            System.out.println("Tabla de multiplicar del " + nro + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println(nro + " x " + i + " = " + (nro * i));
            }
        } else {
            System.out.println("El número ingresado no está en el rango de 1 a 9.");
        }
        
        // Cerrar el scanner
        sc.close();
    }

}
