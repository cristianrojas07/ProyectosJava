package ar.edu.unju.fi.ejercicio11.main;

public class Main {

	public static void main(String[] args) {
		// Ejercicio 11
		
        int i, j, numero = 80;
        String secuencia = "";
        
        for(i = 2, j = 40; j > 0; i++, j--) {
        	secuencia += Integer.toString(numero) + " ";
        	numero += (j-i-1);
        }
        
        System.out.println(secuencia);
    }

}
