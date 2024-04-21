package ar.edu.unju.fi.ejercicio17.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio17.constantes.Posicion;
import ar.edu.unju.fi.ejercicio17.model.Jugador;
import ar.edu.unju.fi.ejercicio18.model.DestinoTuristico;

public class Main {

	public static void main(String[] args) {
		// Ejercicio 17
		byte op = 0;
		ArrayList<Jugador> listJugadores = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Elija una de las opciones del menu.");
			System.out.println("0 - Agregar 4 jugadores por defecto.");
			System.out.println("1 - Alta de jugador");
			System.out.println("2 - Mostrar los datos del jugador");
			System.out.println("3 - Mostrar todos los jugadores ordenados por apellido");
			System.out.println("4 - Modificar los datos de un jugador");
			System.out.println("5 - Eliminar un jugador");
			System.out.println("6 - Mostrar la cantidad total de jugadores");
			System.out.println("7 - Mostrar la cantidad de jugadores que pertenecen a una nacionalidad");
			System.out.println("8 - Salir");
			
			boolean opcionValida = false;
			while(!opcionValida) {
				try {
					System.out.print("Elejir opción: ");
					op = sc.nextByte();
					opcionValida = true;
				}catch (Exception ex){
					System.out.println("Elija una opción válida. Solo se permiten valores enteros.");
					sc.nextLine();
				}
			}
			
			sc.nextLine();
			switch (op) {
				case 0:
					Calendar calendar = Calendar.getInstance();
					calendar.set(1996, 5, 7);
					Jugador jugador1 = new Jugador("Cristian", "Rojas", calendar, "Argentino", 1.8, 55, Posicion.Arquero);
					Jugador jugador2 = new Jugador("Maria", "Orosco", calendar, "Argentino", 1.8, 55, Posicion.Defensa);
					Jugador jugador3 = new Jugador("Karen", "Navarro", calendar, "Argentino", 1.8, 55, Posicion.Delantero);
					Jugador jugador4 = new Jugador("Gael", "Mendoza", calendar, "Argentino", 1.8, 55, Posicion.Medio);
					listJugadores.add(jugador1);
					listJugadores.add(jugador2);
					listJugadores.add(jugador3);
					listJugadores.add(jugador4);
					break;
				case 1:
					System.out.print("Ingrese nombre del jugador: ");
					String nombre = sc.nextLine();
					System.out.print("Ingrese apellido del jugador: ");
					String apellido = sc.nextLine();
					System.out.print("Ingrese fecha de nacimiento del jugador (dd/mm/yyyy): ");
					String fechaNacimientoString = sc.nextLine();
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Calendar fechaNacimiento = Calendar.getInstance();
					
					boolean fechaValida = false;
					do {
						try {
							fechaNacimiento.setTime(formatter.parse(fechaNacimientoString));
							fechaValida = true;
						} catch (ParseException e) {
							System.out.print("Por favor ingrese una fecha válida (dd/MM/yyyy): ");
							fechaNacimientoString = sc.nextLine();
							fechaValida = false;
						}
					}while(!fechaValida);
					
					System.out.print("Ingrese nacionalidad del jugador: ");
					String nacionalidad = sc.nextLine();
					System.out.print("Ingrese estatura del jugador (ej. 1.8): ");
					
					double estatura = 0;
					boolean estaturaValida = false;
					while(!estaturaValida) {
						String estaturaString = sc.nextLine();
						try {
							estatura = Double.parseDouble(estaturaString);
							
							if (estatura > 0) { 
								estaturaValida = true;
							}else {
								System.out.print("Por favor ingrese una estatura válida (ej. 1.8): ");
							}
						} catch (NumberFormatException e) {
							System.out.print("Por favor ingrese una estatura válida (ej. 1.8): ");
						}
					}
					
					
					System.out.print("Ingrese peso del jugador (ej. 80.4): ");
					double peso = 0;
					boolean pesoValido = false;
					while(!pesoValido) {
						String pesoString = sc.nextLine();
						try {
							peso = Double.parseDouble(pesoString);
							
							if (peso > 0) { 
								pesoValido = true;
							}else {
								System.out.print("Por favor ingrese una peso válido (ej. 80.4): ");
							}
						} catch (NumberFormatException e) {
							System.out.print("Por favor ingrese una peso válido (ej. 80.4): ");
						}
					}
					
					byte posicionByte = 0;
					System.out.print("Ingrese posicion del jugador (1-Delantero, 2-Medio, 3-Defensa, 4-Arquero): ");
					do {
						try {
							posicionByte = sc.nextByte();
							if (posicionByte < 0 || posicionByte > 4) {
								System.out.print("Ingrese una posicion valida, entre [1-4]: ");
							}
						}catch(Exception ex){
							System.out.print("Ingrese una posicion valida, entre [1-4]: ");
						}
					}while(posicionByte < 0 || posicionByte > 4);
					
					
					Posicion posicion = Posicion.values()[posicionByte-1];
					Jugador nuevoJugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
					listJugadores.add(nuevoJugador);
					break;
				case 2:
					if(!ListaTieneElementos(listJugadores)) break;
					
					boolean encontro = false;
					System.out.print("\nIngrese nombre del jugador a buscar: ");
					nombre = sc.nextLine();
					System.out.print("Ingrese apellido del jugador a buscar: ");
					apellido = sc.nextLine();
					for (Jugador jugador : listJugadores) {
						if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)){
							System.out.println("\n" + jugador);
							encontro = true;
							break;
						}
					}
					
					if(!encontro) System.out.println("No se encontró el jugador: " + nombre + " " + apellido);
					break;
				case 3:
					if(!ListaTieneElementos(listJugadores)) break;
					
					listJugadores.sort(Comparator.comparing(Jugador::getApellido));
					System.out.println("");
					for (Jugador jugador : listJugadores) {
						System.out.println(jugador);
					}
					break;
				case 4:
					if(!ListaTieneElementos(listJugadores)) break;
					
					encontro = false;
					System.out.print("\nIngrese nombre del jugador a buscar: ");
					nombre = sc.nextLine();
					System.out.print("Ingrese apellido del jugador a buscar: ");
					apellido = sc.nextLine();
					
					Jugador jugadorEncontrado = new Jugador();
					
					for (Jugador jugador : listJugadores) {
						if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)){
							jugadorEncontrado = jugador;
							encontro = true;
							break;
						}
					}
					
					if(encontro) {
						System.out.println("\nSe encontró el jugador " + nombre + " " + apellido);
						System.out.print("\nIngrese el nombre nuevo del jugador: ");
						nombre = sc.nextLine();
						System.out.print("Ingrese el apellido nuevo del jugador: ");
						apellido = sc.nextLine();
						System.out.print("Ingrese fecha de nacimiento nueva del jugador (dd/mm/yyyy): ");
						fechaNacimientoString = sc.nextLine();
						formatter = new SimpleDateFormat("dd/MM/yyyy");
						fechaNacimiento = Calendar.getInstance();
						
						fechaValida = false;
						do {
							try {
								fechaNacimiento.setTime(formatter.parse(fechaNacimientoString));
								fechaValida = true;
							} catch (ParseException e) {
								System.out.print("Por favor ingrese una fecha válida (dd/MM/yyyy): ");
								fechaNacimientoString = sc.nextLine();
								fechaValida = false;
							}
						}while(!fechaValida);
						
						System.out.print("Ingrese nacionalidad del jugador: ");
						nacionalidad = sc.nextLine();
						System.out.print("Ingrese estatura del jugador (ej. 1.8): ");
						
						estatura = 0;
						estaturaValida = false;
						while(!estaturaValida) {
							String estaturaString = sc.nextLine();
							try {
								estatura = Double.parseDouble(estaturaString);
								
								if (estatura > 0) { 
									estaturaValida = true;
								}else {
									System.out.print("Por favor ingrese una estatura válida (ej. 1.8): ");
								}
							} catch (NumberFormatException e) {
								System.out.print("Por favor ingrese una estatura válida (ej. 1.8): ");
							}
						}
						
						
						System.out.print("Ingrese peso del jugador (ej. 80.4): ");
						peso = 0;
						pesoValido = false;
						while(!pesoValido) {
							String pesoString = sc.nextLine();
							try {
								peso = Double.parseDouble(pesoString);
								
								if (peso > 0) { 
									pesoValido = true;
								}else {
									System.out.print("Por favor ingrese una peso válido (ej. 80.4): ");
								}
							} catch (NumberFormatException e) {
								System.out.print("Por favor ingrese una peso válido (ej. 80.4): ");
							}
						}
						
						posicionByte = 0;
						System.out.print("Ingrese posicion del jugador (1-Delantero, 2-Medio, 3-Defensa, 4-Arquero): ");
						do {
							try {
								posicionByte = sc.nextByte();
								if (posicionByte < 0 || posicionByte > 4) {
									System.out.print("Ingrese una posicion valida, entre [1-4]: ");
								}
							}catch(Exception ex){
								System.out.print("Ingrese una posicion valida, entre [1-4]: ");
							}
						}while(posicionByte < 0 || posicionByte > 4);
						posicion = Posicion.values()[posicionByte-1];
						
						jugadorEncontrado.setNombre(nombre);
						jugadorEncontrado.setApellido(apellido);
						jugadorEncontrado.setFechaNacimiento(fechaNacimiento);
						jugadorEncontrado.setNacionalidad(nacionalidad);
						jugadorEncontrado.setEstatura(estatura);
						jugadorEncontrado.setPeso(peso);
						jugadorEncontrado.setPosicion(posicion);
						
						System.out.println("\nDatos del jugador modificado: ");
						System.out.println(jugadorEncontrado);
					}else {
						System.out.println("\nNo se encontró el jugador: " + nombre + " " + apellido);
					}
					
					break;
				case 5:
					if(!ListaTieneElementos(listJugadores)) break;
					
					encontro = false;
					System.out.print("\nIngrese nombre del jugador a eliminar: ");
					nombre = sc.nextLine();
					System.out.print("Ingrese apellido del jugador a eliminar: ");
					apellido = sc.nextLine();
					
					Iterator<Jugador> iterator = listJugadores.iterator();
					while(iterator.hasNext()) {
						Jugador jugador = (Jugador)iterator.next();
						if(jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
							System.out.println("\nSe va a eliminar al jugador: " + nombre + " " + apellido);
							iterator.remove();
							encontro = true;
							System.out.println("Jugador eliminado.");
							break;
						}
					}
					
					if (!encontro) System.out.println("\nNo se encontró el jugador: " + nombre + " " + apellido);
					break;
				case 6:
					System.out.println("\nCantidad total de jugadores: " + listJugadores.size());
					break;
				case 7:
					if(!ListaTieneElementos(listJugadores)) break;
					
					System.out.print("\nIngrese la nacionalidad a buscar: ");
					nacionalidad = sc.nextLine();
					int suma = 0;
					for (int i = 0; i < listJugadores.size(); i++) {
						if (listJugadores.get(i).getNacionalidad().equals(nacionalidad)) {
							suma++;
						}
					}
					
					System.out.println("Cantidad de jugadores de nacionalidad: " + nacionalidad + " - Total: " + suma);
					break;
				case 8:
					System.out.println("Saliendo del programa...");
                    break;
				default:
					System.out.println("\nElija una opción entre [1-8]");
					break;
			};
			System.out.println("");
		}while(op != 8);
		
		sc.close();
	}
	
	private static boolean ListaTieneElementos(ArrayList<Jugador> jugadores) {
    	if(jugadores.size() == 0) {
    		System.out.println("\nNo existen jugadores agregados. Por favor dé de alta un jugador");
			return false;
		}
    	
    	return true;
    }
}
