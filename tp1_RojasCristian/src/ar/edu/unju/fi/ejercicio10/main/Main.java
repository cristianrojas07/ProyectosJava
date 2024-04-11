package ar.edu.unju.fi.ejercicio10.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio10.model.Pizza;

public class Main {

	public static void main(String[] args) {
		// Ejercicio 10
		Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
        	Pizza pizza = new Pizza();
        	
            System.out.println("Ingrese los detalles para la pizza " + (i + 1));
            System.out.print("Diametro (20, 30, 40): ");
            int diametro = scanner.nextInt();
            while (diametro != 20 && diametro != 30 && diametro != 40) {
                System.out.print("Valor no válido. Por favor ingrese 20, 30, o 40. : ");
                diametro = scanner.nextInt();
            }
            
            pizza.setDiametro(diametro);

            System.out.print("¿Tiene ingredientes especiales? (true/false): ");
            boolean ingredientesEspeciales = scanner.nextBoolean();
            pizza.setIngredientesEspeciales(ingredientesEspeciales);

            pizza.calcularPrecio();
            pizza.calcularArea();

            System.out.println("\n**Pizza " + (i + 1) + "**");
            System.out.println(pizza + "\n");
        }

        scanner.close();
	}

}
