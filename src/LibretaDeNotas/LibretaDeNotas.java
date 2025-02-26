package LibretaDeNotas;

import java.util.*;

public class LibretaDeNotas {
    //TODO: + 1 Realizar ingreso de cantidad de alumnos y notas. Ingresar nombre de alumnos y sus notas.

    static Map<String, List<Double>> calificacionEstudiante = new HashMap<>();

    public static double ingresoNotas(Scanner sc) {
        double nota;
        do{
            System.out.println("Ingrese las notas del alumno: ");
            nota = sc.nextDouble();
        }while (nota < 1 || nota > 7);
        sc.nextLine();
        return nota;
    }

    public static int cantidad(String mensaje, Scanner sc) {
        int cantidad;
        do{
            System.out.println(mensaje);
            cantidad = sc.nextInt();
        } while (cantidad <= 0);
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

    //TODO: + 2 Realizar el calculo de las notas por alumno (Promedio).

    public static void promedioTodosAlumnos() {
        double sumaTotal = 0;
        int totalNotas = 0;
        for(List<Double> notas : calificacionEstudiante.values()) {
            for(Double nota : notas) {
                sumaTotal = sumaTotal + nota;
                totalNotas++;
            }
        }
        double promedio = totalNotas > 0 ? sumaTotal / totalNotas : 0;
        System.out.println("El promedio general del curso => " + promedio);
    }

    public static void promedioAlumno() {
        String alumnoMasAlto = "";
        String alumnoMasBajo = "";
        double promedioMasAlto = Double.MIN_VALUE;
        double promedioMasBajo = Double.MAX_VALUE;

        for(Map.Entry<String, List<Double>> e : calificacionEstudiante.entrySet()) {
            String alumno = e.getKey();
            List<Double> notas = e.getValue();

            double sumaNotas = 0;
            for(Double nota : notas) {
                sumaNotas = sumaNotas + nota;
            }
            double promedioAlumno = notas.size() > 0 ? sumaNotas / notas.size() : 0;
            System.out.println("El promedio de " + alumno + " es: " + promedioAlumno);

            if (promedioAlumno > promedioMasAlto) {
                promedioMasAlto = promedioAlumno;
                alumnoMasAlto = alumno;
            }
            if (promedioAlumno < promedioMasBajo) {
                promedioMasBajo = promedioAlumno;
                alumnoMasBajo = alumno;
            }
        }
        System.out.println("\nEl alumno con el promedio más alto es: " + alumnoMasAlto + " con un promedio de: " + promedioMasAlto);
        System.out.println("El alumno con el promedio más bajo es: " + alumnoMasBajo + " con un promedio de: " + promedioMasBajo);
    }

    //TODO: + 3 Mostrar el promedio, la nota mas alta y la nota mas baja.

    public static void notaMasAltaYMasBajaEnTodoElCurso() {
        // Variables para almacenar la nota más alta y la más baja
        double notaMasAlta = Double.MIN_VALUE;
        double notaMasBaja = Double.MAX_VALUE;

        // Recorrer cada lista de notas de cada alumno
        for (List<Double> notas : calificacionEstudiante.values()) {
            // Recorrer las notas de cada alumno
            for (Double nota : notas) {
                // Encontrar la nota más alta
                if (nota > notaMasAlta) {
                    notaMasAlta = nota;
                }
                // Encontrar la nota más baja
                if (nota < notaMasBaja) {
                    notaMasBaja = nota;
                }
            }
        }
        System.out.println("La nota más alta en todo el curso es: " + notaMasAlta);
        System.out.println("La nota más baja en todo el curso es: " + notaMasBaja);
    }

    //TODO: 4 Hacer un menu.
    //TODO: + 5 Validaciones: Cantidades de notas y/o alumnos deben ser un numero positivo.

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
        promedioAlumno();
        promedioTodosAlumnos();
        notaMasAltaYMasBajaEnTodoElCurso();


    }
}
