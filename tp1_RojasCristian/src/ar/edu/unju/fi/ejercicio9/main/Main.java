package ar.edu.unju.fi.ejercicio9.main;

import ar.edu.unju.fi.ejercicio9.model.Producto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < 3; i++) {
            Producto producto = new Producto();
            System.out.println("Ingrese los detalles del producto " + (i + 1));
            
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            producto.setNombre(nombre);
            System.out.print("Código: ");
            String codigo = scanner.nextLine();
            producto.setCodigo(codigo);
            System.out.print("Precio: ");
            double precio = scanner.nextDouble();
            scanner.nextLine();
            producto.setPrecio(precio);
            System.out.print("Descuento (0-50): ");
            int descuento = scanner.nextInt();
            scanner.nextLine();
            while (descuento < 0 || descuento > 50) {
                System.out.println("El descuento debe estar entre 0 y 50.");
                descuento = scanner.nextInt();
                scanner.nextLine();
            }
            producto.setDescuento(descuento);
            
            System.out.println("\nDatos del Producto " + (i + 1) + ":");
            System.out.println(producto);
            System.out.println("Precio con Descuento: $" + producto.calcularDescuento() + "\n");
        }
        
        scanner.close();
    }
}
