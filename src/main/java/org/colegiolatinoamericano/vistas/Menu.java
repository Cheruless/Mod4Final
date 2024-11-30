package org.colegiolatinoamericano.vistas;

import org.colegiolatinoamericano.modelos.Alumno;
import org.colegiolatinoamericano.modelos.Materia;
import org.colegiolatinoamericano.modelos.MateriaEnum;
import org.colegiolatinoamericano.servicios.AlumnoServicio;
import org.colegiolatinoamericano.servicios.ArchivosServicio;


public class Menu extends MenuTemplate {
    AlumnoServicio alumnoServicio = new AlumnoServicio();
    ArchivosServicio archivosServicio = new ArchivosServicio();

    @Override
    public void exportarDatos() {
        System.out.println("--- Exportar Datos ---");
        System.out.println("Ingresa la ruta en donde se encuentra o encontrará el archivo promedios.txt");
        String ruta = sc.nextLine();

        if (ruta.trim().isEmpty()) {
            ruta = "promedios.txt";
        } else if (!ruta.endsWith(".txt")) {
            //Si la ruta no termina con .txt se le agrega
            if (!ruta.endsWith("/") && !ruta.endsWith("\\")) {
                //Si la ruta no termina con / y tampoco con \\ entonces se añade separador a la ruta
                ruta += System.getProperty("file.separator");
            }
            ruta += "promedios.txt";
        }

        archivosServicio.exportarDatos(alumnoServicio.listarAlumnos(), ruta);
    }

    @Override
    public void crearAlumno() {
        System.out.println("--- Crear Alumno ---");
        Alumno alumnoCreado = new Alumno();

        System.out.println("Ingresa RUT");
        String rut = sc.nextLine();
        System.out.println("Ingresa nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingresa apellido: ");
        String apellido = sc.nextLine();
        System.out.println("Ingresa dirección: ");
        String direccion = sc.nextLine();

        alumnoCreado.setRut(rut);
        alumnoCreado.setNombre(nombre);
        alumnoCreado.setApellido(apellido);
        alumnoCreado.setDireccion(direccion);

        alumnoServicio.crearAlumno(alumnoCreado);

        System.out.println("--- ¡Alumno Agregado! ---");
    }

    @Override
    public void agregarMateria() {
        //MUESTRA MENU PARA ASIGNARLE MATERIA A UN ALUMNO
        System.out.println("--- Agregar Materia ---");
        System.out.print("Ingresa rut del Alumno: ");
        String rut = sc.nextLine();

        int cont = 1;
        for (MateriaEnum materias : MateriaEnum.values()) {
            System.out.println(cont + ". " + materias);
            cont++;
        }

        System.out.print("Selecciona una Materia: ");
        switch (sc.nextInt()) {
            case 1 -> {
                Materia materia = new Materia();
                materia.setNombre(MateriaEnum.MATEMATICAS);
                alumnoServicio.agregarMateria(rut, materia);
            }
            case 2 -> {
                Materia materia = new Materia();
                materia.setNombre(MateriaEnum.LENGUAJE);
                alumnoServicio.agregarMateria(rut, materia);
            }
            case 3 -> {
                Materia materia = new Materia();
                materia.setNombre(MateriaEnum.CIENCIA);
                alumnoServicio.agregarMateria(rut, materia);
            }
            case 4 -> {
                Materia materia = new Materia();
                materia.setNombre(MateriaEnum.HISTORIA);
                alumnoServicio.agregarMateria(rut, materia);
            }
            default -> System.out.println("Opcion no valida");
        }
        if (alumnoServicio.materiasPorAlumno(rut) != null) {
            System.out.println("--- ¡Materia Agregada! ---");
        }
    }

    @Override
    public void agregarNotaPasoUno() {
        //MUESTRA MENU PARA ASIGNAR NOTA A UN ALUMNO
        System.out.println("--- Agregar Nota ---");
        System.out.print("Ingresa rut del Alumno: ");
        String rut = sc.nextLine();

        try {
            if (alumnoServicio.materiasPorAlumno(rut) == null || alumnoServicio.materiasPorAlumno(rut).isEmpty())
                throw new Exception("El alumno no tiene materias registradas.");

            int cont = 1;
            System.out.println("Alumno tiene las siguientes materias agregadas:");

            for (Materia materia : alumnoServicio.materiasPorAlumno(rut)) {
                System.out.println(cont + ". " + materia.getNombre());
                cont++;
            }

            System.out.print("Seleccionar materia: ");
            int opc = sc.nextInt() - 1;
            sc.nextLine();
            Materia materiaDeAlumno = alumnoServicio.materiasPorAlumno(rut).get(opc);
            if (materiaDeAlumno == null)
                throw new Exception("No se encontró materia de alumno indicada.");

            System.out.print("Ingresar nota: ");
            float nota = sc.nextFloat();
            sc.nextLine();
            if (nota < 0.0 || nota > 7.0)
                throw new Exception("La nota no es válida. Debe ser entre 0,0 y 7,0");

            materiaDeAlumno.setNotas(nota);
            System.out.printf("--- ¡Nota agregada a %s ---\n", materiaDeAlumno.getNombre());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }


    @Override
    public void listarAlumnos() {
        System.out.println("--- Listar Alumnos ---");
        alumnoServicio.listarAlumnos().forEach(
                (rut, alumno) -> {
                    System.out.println("Datos alumno");
                    System.out.println("\tRUT: " + alumno.getRut());
                    System.out.println("\tNombre: " + alumno.getNombre());
                    System.out.println("\tApellido: " + alumno.getApellido());
                    System.out.println("\tDireccion: " + alumno.getDireccion());
                    System.out.println();
                    System.out.println("\tMaterias");
                    for (Materia materia : alumno.getListMaterias()) {
                        System.out.println("\t\t" + materia.getNombre());
                        System.out.println("\t\t\tNotas:");
                        for (Float nota : materia.getListNotasMateriaAlumno()) {
                            System.out.println("\t\t\t[" + nota + "]");
                        }
                    }
                }
        );
    }

    @Override
    public void terminarPrograma() {
        System.out.println("--- Terminar Programa ---");
        System.out.println("¡Hasta pronto!");
    }
}
