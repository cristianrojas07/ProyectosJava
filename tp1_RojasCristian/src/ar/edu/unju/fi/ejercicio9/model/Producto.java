package ar.edu.unju.fi.ejercicio9.model;

public class Producto {
	private String nombre;
	private String codigo;
	private double precio;
	private int descuento;
	
	public Producto() { }
	
	public double calcularDescuento() {
        return precio - (precio * descuento / 100.0);
    }
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		if (descuento >= 0 && descuento <= 50) {
            this.descuento = descuento;
        } else {
            System.out.println("El descuento debe estar entre 0 y 50.");
        }
	}

	@Override
	public String toString() {
		String msj = "Nombre: " + this.nombre + "\n";
		msj += "Código: " + this.codigo + "\n";
		msj += "Precio: $" + this.precio + "\n";
		msj += "Descuento: " + this.descuento + "%";
		
		return msj;
	}
	
	
	
}
