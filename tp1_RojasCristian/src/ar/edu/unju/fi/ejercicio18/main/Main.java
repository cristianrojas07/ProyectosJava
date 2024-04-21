package ar.edu.unju.fi.ejercicio18.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio18.model.*;

public class Main {
	
    public static void main(String[] args) {
    	// Ejercicio 18
    	
    	ArrayList<Pais> paises = new ArrayList<>();
        ArrayList<DestinoTuristico> destinos = new ArrayList<>();

        paises.add(new Pais("AR", "Argentina"));
        paises.add(new Pais("BR", "Brasil"));
        paises.add(new Pais("CH", "Chile"));
        paises.add(new Pais("PE", "Perú"));
        paises.add(new Pais("PA", "Paraguay"));

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("0 - Insertar 5 Destinos turisticos de prueba");
            System.out.println("1 - Alta de destino turístico");
            System.out.println("2 - Mostrar todos los destinos turísticos");
            System.out.println("3 - Modificar el país de un destino turístico");
            System.out.println("4 - Limpiar el ArrayList de destinos turísticos");
            System.out.println("5 - Eliminar un destino turístico");
            System.out.println("6 - Mostrar los destinos turísticos ordenados por nombre");
            System.out.println("7 - Mostrar todos los países");
            System.out.println("8 - Mostrar los destinos turísticos de un país");
            System.out.println("9 - Salir");
            System.out.print("Elejir opcion: ");
            try {
                opcion = scanner.nextByte();
                scanner.nextLine();

                switch (opcion) {
                	case 0:
                		destinos.add(new DestinoTuristico("Destino1", "Tucuman", 700, paises.get(0), 8));
	                    destinos.add(new DestinoTuristico("Destino1", "Salta", 500, paises.get(0), 7));
	                    destinos.add(new DestinoTuristico("Destino2", "Camboriu", 800, paises.get(1), 5));
	                    destinos.add(new DestinoTuristico("Destino3", "Calama", 1000, paises.get(2), 4));
	                    destinos.add(new DestinoTuristico("Destino4", "Lima", 700, paises.get(3), 6));
	                    break;
                    case 1:
                        System.out.println("Ingrese los detalles del nuevo destino turístico:");
                        System.out.print("Código Destino: ");
                        String codigoDestino = scanner.nextLine();
                        System.out.print("Nombre Destino: ");
                        String nombreDestino = scanner.nextLine();
                        System.out.print("Precio Destino (ej. 700.5): ");
                        double precioDestino = 0;
    					boolean precioValido = false;
    					while(!precioValido) {
    						String precioDestinoString = scanner.nextLine();
    						try {
    							precioDestino = Double.parseDouble(precioDestinoString);
    							
    							if (precioDestino > 0) { 
    								precioValido = true;
    							}else {
    								System.out.print("Por favor ingrese un precio valido (ej. 700.5): ");
    							}
    						} catch (NumberFormatException e) {
    							System.out.print("Por favor ingrese un precio valido (ej. 700.5): ");
    						}
    					}
                        System.out.println("Países disponibles:");
                        for (Pais pais : paises) {
                            System.out.println(pais.getCodigo() + " - " + pais.getNombre());
                        }

                        String codigoPais;
                        Pais paisDestino;
                        do {
                            System.out.print("Ingrese el código del país para el nuevo destino turístico: ");
                            codigoPais = scanner.nextLine();
                            paisDestino = null;
                            for (Pais pais : paises) {
                                if (pais.getCodigo().equalsIgnoreCase(codigoPais)) {
                                    paisDestino = pais;
                                    break;
                                }
                            }
                            if (paisDestino == null) {
                                System.out.println("El código de país ingresado no es válido. Por favor, ingrese un código válido.");
                            }
                        } while (paisDestino == null);
                        
                        System.out.print("Cantidad de días: ");
                        int cantidadDias = scanner.nextInt();
                        DestinoTuristico nuevoDestino = new DestinoTuristico(codigoDestino, nombreDestino, precioDestino, paisDestino, cantidadDias);
                        destinos.add(nuevoDestino);
                        System.out.println("Destino turístico agregado correctamente.");
                        break;
                    case 2:
                    	if(!ListaTieneElementos(destinos)) break;
                    	
                    	System.out.println("\nDestinos turísticos:");
                        for (DestinoTuristico destino : destinos) {
                            System.out.println(destino);
                        }
                        
                        break;
                    case 3:
                    	if(!ListaTieneElementos(destinos)) break;
                    	System.out.print("Ingrese el código del destino turístico que desea modificar: ");
                        String codigoDestinoModificar = scanner.nextLine();

                        DestinoTuristico destinoModificar = null;
                        boolean encontrado = false;
                        for (DestinoTuristico destino : destinos) {
                            if (destino.getCodigo().equalsIgnoreCase(codigoDestinoModificar)) {
                                destinoModificar = destino;
                                encontrado = true;
                                break;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("No se encontró ningún destino turístico con el código especificado.");
                            break;
                        }
                        
                        System.out.println("Países disponibles:");
                        for (Pais pais : paises) {
                            System.out.println(pais.getCodigo() + " - " + pais.getNombre());
                        }

                        String nuevoCodigoPais;
                        Pais nuevoPais;
                        do {
                            System.out.print("Ingrese el nuevo código de país para el destino turístico: ");
                            nuevoCodigoPais = scanner.nextLine();
                            nuevoPais = null;
                            for (Pais pais : paises) {
                                if (pais.getCodigo().equalsIgnoreCase(nuevoCodigoPais)) {
                                    nuevoPais = pais;
                                    break;
                                }
                            }

                            if (nuevoPais == null) {
                                System.out.println("El código de país ingresado no es válido. Por favor, Por favor, ingrese un código válido.");
                            }
                        } while (nuevoPais == null);

                        destinoModificar.setPais(nuevoPais);
                        System.out.println("El país del destino turístico se ha modificado correctamente.");
                        break;
                    case 4:
                    	if(!ListaTieneElementos(destinos)) break;
                    	
                        destinos.clear();
                        System.out.println("ArrayList de destinos turísticos limpiado.");
                        break;
                    case 5:
                    	if(!ListaTieneElementos(destinos)) break;
                        System.out.print("Ingrese el código del destino turístico que desea eliminar: ");
                        codigoDestino = scanner.nextLine();

                        Iterator<DestinoTuristico> iterator = destinos.iterator();
                        encontrado = false;
                        while (iterator.hasNext()) {
                            DestinoTuristico destino = iterator.next();
                            if (destino.getCodigo().equalsIgnoreCase(codigoDestino)) {
                                iterator.remove();
                                System.out.println("El destino turístico ha sido eliminado correctamente.");
                                encontrado = true;
                                break;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("No se encontró ningún destino turístico con el código especificado.");
                        }
                        break;
                    case 6:
                    	if(!ListaTieneElementos(destinos)) break;
                    	
                        destinos.sort(Comparator.comparing(DestinoTuristico::getNombre));
    					System.out.println("");
    					for (DestinoTuristico destino : destinos) {
    						System.out.println(destino);
    					}
    					break;
                    case 7:
                		if(!ListaTieneElementos(paises)) break;
                    	
                    	System.out.println("\nPaíses:");
                        for (Pais pais : paises) {
                            System.out.println(pais.getCodigo() + " - " + pais.getNombre());
                        }
                        break;
                    case 8:
                    	if(!ListaTieneElementos(paises)) break;
                    	
                        System.out.print("Ingrese el código del país para ver los destinos turísticos: ");
                        codigoPais = scanner.nextLine();

                        Pais paisSeleccionado = null;
                        encontrado = false;
                        for (Pais pais : paises) {
                            if (pais.getCodigo().equalsIgnoreCase(codigoPais)) {
                                paisSeleccionado = pais;
                                encontrado = true;
                                break;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("\nNo se encontró ningún país con el código especificado.");
                            break;
                        }
                        
                        if(!ListaTieneElementos(destinos)) break;
                        
                        System.out.println("\nDestinos turísticos en " + paisSeleccionado.getNombre() + ":");
                        encontrado = false;
                        for (DestinoTuristico destino : destinos) {
                            if (destino.getPais().equals(paisSeleccionado)) {
                                System.out.println(destino.getNombre());
                                encontrado = true;
                            }
                        }
                        
                        if (!encontrado) {
                            System.out.println("No hay destinos turísticos registrados para este país.");
                        }
                        
                        break;
                    case 9:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor introduzca un número entero.");
                scanner.nextLine();
                opcion = 0;
            } finally {
                System.out.println();
            }

        } while (opcion != 9);

        scanner.close();
    }
    
    private static <T> boolean ListaTieneElementos(ArrayList<T> lista) {
    	if(lista.size() == 0) {
    		System.out.println("\nNo existen elementos en la lista. Por favor, agregué elementos.");
			return false;
		}
    	
    	return true;
    }
}