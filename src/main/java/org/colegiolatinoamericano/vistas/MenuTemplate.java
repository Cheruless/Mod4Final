package org.colegiolatinoamericano.vistas;

import java.util.Scanner;

public abstract class MenuTemplate {
    protected Scanner sc = new Scanner(System.in);

    public abstract void crearAlumno();

    public abstract void exportarDatos();

    public abstract void agregarMateria();

    public abstract void agregarNotaPasoUno();

    public abstract void listarAlumnos();

    public abstract void terminarPrograma();

    public final void iniciarMenu() {
        int exit = 0;
        do {

            System.out.println("1. Crear alumnos");
            System.out.println("2. Listar Alumnos");
            System.out.println("3. Agregar Materias");
            System.out.println("4. Agregar Notas");
            System.out.println("5. Salir");
            System.out.println("6. exportarDatos");
            System.out.print("Selección: ");

            switch (sc.nextInt()) {
                case 1 -> {
                    sc.nextLine();
                    crearAlumno();
                }
                case 2 -> listarAlumnos();

                case 3 -> {
                    sc.nextLine();
                    agregarMateria();
                }
                case 4 -> {
                    sc.nextLine();
                    agregarNotaPasoUno();
                }
                case 5 -> {
                    terminarPrograma();
                    exit = 1;
                }

                case 6 -> {
                    sc.nextLine();
                    exportarDatos();
                }
                default -> System.out.println("Opcion no valida");
            }
        } while (exit == 0);
        System.exit(exit);
    }
}
