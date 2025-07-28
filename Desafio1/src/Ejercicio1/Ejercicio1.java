package Ejercicio1;// src/Main.java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio1 {
    private static final HashMap<String, Estudiante> estudiantes = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

// Método principal
    public static void main(String[] args) {
        // Datos de ejemplo para iniciar el programa
        estudiantes.put("AV123456", new Estudiante("Ana Valencia", 20, "Ingeniería en Ciencias de la Computación", "POO"));
        estudiantes.put("LG234567", new Estudiante("Luis Guerra", 22, "Técnico en Ciencias de la Computación", "MBD"));
        estudiantes.put("LR345678", new Estudiante("Lucas Rivera", 21, "Ingenieria en Ciencias de la Computación", "PRE"));

        int opcion;
        do {
            mostrarMenu(); //Llamar el private static void mostrarMenu()
            opcion = leerEntero("Elija una opción: ");
            // Menú de opciones con Switch Case
            switch (opcion) {
                case 1: ingresarEstudiante(); break;
                case 2: verEstudiantes(); break;
                case 3: buscarEstudiante(); break;
                case 4: System.out.println(""); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }
    private static void mostrarMenu() {
        System.out.println("\n-----------------------------");
        System.out.println("   MENÚ DE ESTUDIANTES   ");
        System.out.println("-----------------------------");
        System.out.println("1. Ingresar estudiante");
        System.out.println("2. Ver estudiantes");
        System.out.println("3. Buscar estudiante");
        System.out.println("4. Salir");
        System.out.println("-----------------------------");
    }
// Parte 1: Ingresar estudiante
    private static void ingresarEstudiante() {
        try {
            System.out.print("Ingrese número de carnet (Ej: AB12345): ");
            String carnet = scanner.nextLine().trim().toUpperCase();
            // Validación del carnet usando !Character.isLetter() y Character.isDigit() donde pedimos 2 letras y 6 números
            if (carnet.length() != 8 ||
                    !Character.isLetter(carnet.charAt(0)) ||
                    !Character.isLetter(carnet.charAt(1)) ||
                    !Character.isDigit(carnet.charAt(2)) ||
                    !Character.isDigit(carnet.charAt(3)) ||
                    !Character.isDigit(carnet.charAt(4)) ||
                    !Character.isDigit(carnet.charAt(5)) ||
                    !Character.isDigit(carnet.charAt(6)) ||
                    !Character.isDigit(carnet.charAt(7))) {
                System.out.println("Carnet inválido. Debe tener 2 letras y 6 números.");
                return;
            }
            if (estudiantes.containsKey(carnet)) {
                System.out.println("Ese carnet ya existe.");
                return;
            }
            // Pedir los datos del estudiante
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine().trim();
            int edad = leerEntero("Edad: ");
            System.out.print("Carrera: ");
            String carrera = scanner.nextLine().trim();
            System.out.print("Materia: ");
            String materia = scanner.nextLine().trim();

            estudiantes.put(carnet, new Estudiante(nombre, edad, carrera, materia));
            System.out.println("Estudiante agregado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al ingresar estudiante.");
        }
    }
    // Parte 2: Ver el estudiante
    private static void verEstudiantes() {
        System.out.println("\n--- LISTA DE ESTUDIANTES ---");
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes.");
        } else {
            for (Map.Entry<String, Estudiante> entry : estudiantes.entrySet()) {
                System.out.println("Carnet: " + entry.getKey());
                System.out.println(entry.getValue());
                System.out.println("---------------------------");
            }
        }
    }
    //Parte 3: Buscar estudiante por medio del carnet
    private static void buscarEstudiante() {
        System.out.print("Ingrese el carnet a buscar: ");
        String carnet = scanner.nextLine().trim().toUpperCase();
        if (estudiantes.containsKey(carnet)) {
            System.out.println("Estudiante encontrado:");
            System.out.println(estudiantes.get(carnet));
        } else {
            System.out.println("No se encontró ese carnet.");
        }
    }
    private static int leerEntero(String mensaje) {
        // Metodo para corroborar que el número ingresado sea un entero positivo
        int valor = -1;
        while (true) {
            try {
                System.out.print(mensaje);
                valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor < 0) {
                    System.out.println("Debe ser un número positivo.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
        return valor;
    }

    // Clase Estudiante internar para almacenar los datos de los estudiantes
    static class Estudiante {
        private final String nombre;
        private final int edad;
        private final String carrera;
        private final String materia;

        public Estudiante(String nombre, int edad, String carrera, String materia) {
            this.nombre = nombre;
            this.edad = edad;
            this.carrera = carrera;
            this.materia = materia;
        }
        public String toString() {
            return nombre + ", " + edad + " años, " + carrera + ", " + materia;
        }
    }
}
