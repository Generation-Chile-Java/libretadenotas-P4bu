package LibretaDeNotas;

import java.util.*;

public class LibretaDeNotas {
    static Map<String, List<Double>> calificacionEstudiante = new HashMap<>();

    public static double ingresoNotas(Scanner sc) {
        System.out.println("Ingrese las notas del alumno: ");
        double nota = sc.nextDouble();
        sc.nextLine();
        return nota;
    }

    public static int cantidad(String mensaje, Scanner sc) {
        System.out.println(mensaje);
        int cantidad = sc.nextInt();
        sc.nextLine();
        return cantidad;
    }

    public static String nombreAlumno(Scanner sc) {
        String nombre = "";
        boolean nombreValido = false;
        while(!nombreValido) {
            System.out.println("Ingrese nombre del alumno: ");
            nombre = sc.nextLine();
            nombreValido = true;

            for(int i = 0; i < nombre.length(); i++){
                if(!Character.isLetter(nombre.charAt(i))) {
                    nombreValido = false;
                    System.out.println("ERROR: Ingrese un nombre valido ");
                    break;
                }
            }
        }
        return nombre;
    }

    public static void mostrarDiccionario() {
        for(String alumno : calificacionEstudiante.keySet()) {
            System.out.println("++ " + alumno + " Notas => " + calificacionEstudiante.get(alumno));
        }
    }

    //TODO: 2 Realizar el calculo de las notas por alumno (Promedio).
    //TODO: 3 Mostrar el promedio, la nota mas alta y la nota mas baja.
    //TODO: 4 Hacer un menu.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Nombre,  Lista Notas
        // Map<String, List<Double>> calificacionEstudiante = new HashMap<>();

        int cantidadDeNotas = cantidad("Cuantas notas desea ingresar", sc);
        int cantidadDeAlumnos = cantidad("Cuantos alumnos desea ingresar", sc);

        // Llenar la Lista con las notas -> llamando a la funcion ingresar notas
        //System.out.println("notas = " + notas);

        // Ingresar los nombres de los alumnos y declarar la lista de notas
        for (int i = 0; i < cantidadDeAlumnos ; i++) {
            String nombre = nombreAlumno(sc);
            List<Double> notas = new ArrayList<>();

            // Se llena la lista de notas para cada alumno
            for (int j = 0; j < cantidadDeNotas; j++) {
                    notas.add(ingresoNotas(sc));
            }
            calificacionEstudiante.put(nombre, notas);
        }
        sc.close();

        mostrarDiccionario();


























    }
}
