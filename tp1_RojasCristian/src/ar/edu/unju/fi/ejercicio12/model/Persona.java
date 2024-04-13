package ar.edu.unju.fi.ejercicio12.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Persona {
	private String nombre;
	private Calendar fechaNacimiento;
	
	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return "Nombre: " + this.nombre + "\nFecha nacimiento: " + formatter.format(this.fechaNacimiento.getTime());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int calcularEdad() {
	    Calendar ahora = Calendar.getInstance();
	    int edad = ahora.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
	    int diaNacimiento = fechaNacimiento.get(Calendar.DAY_OF_YEAR);
	    int diaActual = ahora.get(Calendar.DAY_OF_YEAR);

	    if (diaActual < diaNacimiento) {
	        edad--;
	    }

	    return edad;
	}
	
	public String obtenerSignoZodiaco() {
	    int mes = fechaNacimiento.get(Calendar.MONTH) + 1;
	    int dia = fechaNacimiento.get(Calendar.DAY_OF_MONTH);
	    String signo = "";

	    if ((mes == 3 && dia >= 21) || (mes == 4 && dia <= 19)) signo = "Aries";
	    else if ((mes == 4 && dia >= 20) || (mes == 5 && dia <= 20)) signo = "Tauro";
	    else if ((mes == 5 && dia >= 21) || (mes == 6 && dia <= 20)) signo = "Géminis";
	    else if ((mes == 6 && dia >= 21) || (mes == 7 && dia <= 22)) signo = "Cáncer";
	    else if ((mes == 7 && dia >= 23) || (mes == 8 && dia <= 22)) signo = "Leo";
	    else if ((mes == 8 && dia >= 23) || (mes == 9 && dia <= 22)) signo = "Virgo";
	    else if ((mes == 9 && dia >= 23) || (mes == 10 && dia <= 22)) signo = "Libra";
	    else if ((mes == 10 && dia >= 23) || (mes == 11 && dia <= 21)) signo = "Escorpio";
	    else if ((mes == 11 && dia >= 22) || (mes == 12 && dia <= 21)) signo = "Sagitario";
	    else if ((mes == 12 && dia >= 22) || (mes == 1 && dia <= 19)) signo = "Capricornio";
	    else if ((mes == 1 && dia >= 20) || (mes == 2 && dia <= 18)) signo = "Acuario";
	    else if ((mes == 2 && dia >= 19) || (mes == 3 && dia <= 20)) signo = "Piscis";

	    return signo;
	}

	
	public String obtenerEstacion() {
	    int mes = fechaNacimiento.get(Calendar.MONTH) + 1;
	    int dia = fechaNacimiento.get(Calendar.DAY_OF_MONTH);
	    String estacion = "";

	    switch (mes) {
	        case 1: case 2: case 12:
	            estacion = "Invierno";
	            break;
	        case 3:
	            estacion = (dia < 21) ? "Invierno" : "Primavera";
	            break;
	        case 4: case 5:
	            estacion = "Primavera";
	            break;
	        case 6:
	            estacion = (dia < 21) ? "Primavera" : "Verano";
	            break;
	        case 7: case 8:
	            estacion = "Verano";
	            break;
	        case 9:
	            estacion = (dia < 21) ? "Verano" : "Otoño";
	            break;
	        case 10: case 11:
	            estacion = "Otoño";
	            break;
	    }

	    return estacion;
	}

}
