package org.colegiolatinoamericano.servicios;

import org.colegiolatinoamericano.modelos.Alumno;
import org.colegiolatinoamericano.modelos.Materia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

public class ArchivosServicio {
    private List<Alumno> alumnosACargar; //No entiendo cómo darle un uso a esto. Considero innecesario
    private PromedioServicioImp promediosServicioImp = new PromedioServicioImp();

    public void exportarDatos(Map<String, Alumno> alumnos, String rutaArchivoExportacion) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivoExportacion));
            for (Alumno alumno : alumnos.values()) {
                writer.write(alumno.toString());
                writer.newLine();
                for (Materia materia : alumno.getListMaterias()){
                    float promedio = promediosServicioImp.calcularPromedio(materia.getListNotasMateriaAlumno());
                    writer.write("\tMateria: " + materia.getNombre() + " - Promedio: " + promedio);
                    writer.newLine();

                }
                writer.newLine();
            }
            System.out.println("Datos exportados correctamente.");
            writer.close();
        }catch (Exception e){
            System.out.println("Error al exportar el archivo: " + e.getMessage());
        }
    }
}
