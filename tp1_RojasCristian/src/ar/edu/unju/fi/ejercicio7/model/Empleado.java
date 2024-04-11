package ar.edu.unju.fi.ejercicio7.model;

import java.text.DecimalFormat;

public class Empleado {
	private String nombre;
	private String legajo;
	private double salario;
	private final double salarioMinimo = 210000;
	private final double aumentoPorMerito = 20000;
	
	public Empleado(String nombre, String legajo, double salario) {
		this.nombre = nombre;
		this.legajo = legajo;
		
		if (salario >= this.salarioMinimo) {
			this.salario = salario;
		}else if (salario < this.salarioMinimo) {
			this.salario = this.salarioMinimo;
		}
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		var msj = "Nombre del empleado: " + this.nombre + "\n";
		msj += "Legajo: " + this.legajo + "\n";
		msj += "Salario $: " + df.format(this.salario);
		
		return msj;
	}
	
	public void darAumentoDeSalario() {
		this.salario += this.aumentoPorMerito;
	}
}
