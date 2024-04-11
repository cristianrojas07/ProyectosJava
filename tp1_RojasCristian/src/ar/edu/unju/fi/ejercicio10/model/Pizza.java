package ar.edu.unju.fi.ejercicio10.model;

public class Pizza {
    private int diametro;
    private double precio;
    private double area;
    private boolean ingredientesEspeciales;
    private static final double ADICIONAL_ESPECIALES_20 = 500;
    private static final double ADICIONAL_ESPECIALES_30 = 750;
    private static final double ADICIONAL_ESPECIALES_40 = 1000;

    public Pizza() {}

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public double getPrecio() {
        return precio;
    }

    public double getArea() {
        return area;
    }

    public boolean isIngredientesEspeciales() {
        return ingredientesEspeciales;
    }

    public void setIngredientesEspeciales(boolean ingredientesEspeciales) {
        this.ingredientesEspeciales = ingredientesEspeciales;
    }

    // Métodos adicionales
    public void calcularPrecio() {
    	if (this.diametro == 20) 
    	{
    		this.precio = 4500 + (this.ingredientesEspeciales ? ADICIONAL_ESPECIALES_20 : 0);
    	}
    	else if (this.diametro == 30) 
    	{
    		this.precio = 4800 + (this.ingredientesEspeciales ? ADICIONAL_ESPECIALES_30 : 0);
    	}
    	else if (this.diametro == 40) 
    	{
    		this.precio = 5500 + (this.ingredientesEspeciales ? ADICIONAL_ESPECIALES_40 : 0);
    	}
    	else 
    	{
    		System.out.println("Diametro no válido. No se pudo calcular el precio.");
            this.precio = 0;
    	}
    }

    public void calcularArea() {
        this.area = Math.PI * Math.pow(this.diametro / 2, 2);
    }

	@Override
	public String toString() {
		String msj = "Diámetro = " + this.diametro + "\n";
		msj += "Ingredientes especiales = " + this.ingredientesEspeciales + "\n";
		msj += "Precio Pizza = " + this.precio + "$ \n";
		msj += "Área de la pizza = " + this.area;
		
		return msj;
	}
    
    
}
