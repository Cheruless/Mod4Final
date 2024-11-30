package org.colegiolatinoamericano.servicios;

import org.colegiolatinoamericano.modelos.Alumno;
import org.colegiolatinoamericano.modelos.Materia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlumnoServicio {
    private Map<String, Alumno> listaAlumnos = new HashMap<>();

    public void crearAlumno(Alumno alumno) {
        listaAlumnos.put(alumno.getRut(), alumno);
    }

    public void agregarMateria(String rut, Materia currentMateria) {
        if (listaAlumnos != null && listaAlumnos.containsKey(rut))
            listaAlumnos.get(rut).setListMaterias(currentMateria);
    }

    public List<Materia> materiasPorAlumno(String rutAlumno) {
        if (listaAlumnos != null && listaAlumnos.containsKey(rutAlumno))
            return listaAlumnos.get(rutAlumno).getListMaterias();
        return null;
    }

    public Map<String, Alumno> listarAlumnos() {
        return listaAlumnos;
    }
}
