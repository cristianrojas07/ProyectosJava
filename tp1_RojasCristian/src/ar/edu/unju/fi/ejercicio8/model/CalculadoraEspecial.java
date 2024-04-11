package ar.edu.unju.fi.ejercicio8.model;

public class CalculadoraEspecial {
	private int n;

	public CalculadoraEspecial() {
		// TODO Auto-generated constructor stub
	}
	
	public int calcularSumatoria() {
		int sumatoria = 0;
		for (int i = 1; i <= this.n; i++) {
			sumatoria += Math.pow((i*(i+1)/2), 2);
		}
		return sumatoria;
	}
	
	public int calcularProductoria() {
		int productoria = 1;
		for (int i = 1; i <= this.n; i++) {
			productoria *= i*(i+4);
		}
		return productoria;
	}
	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	
}
