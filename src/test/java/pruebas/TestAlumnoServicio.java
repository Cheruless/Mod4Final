package pruebas;

import org.colegiolatinoamericano.modelos.Alumno;
import org.colegiolatinoamericano.modelos.Materia;
import org.colegiolatinoamericano.modelos.MateriaEnum;
import org.colegiolatinoamericano.servicios.AlumnoServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/*
*   Tuve muchos problemas en esta sección y me retrasé.
*   Era porque usaba la versión más actualizada de JAVA 23 y Mockito no soporta esta versión aun.
*   Tuve que cambiar a JAVA 17 para que funcione
*/

@DisplayName("Test para AlumnoServicio")
public class TestAlumnoServicio {
    AlumnoServicio alumnoServicio;
    AlumnoServicio alumnoServicioMock;
    Materia matematicas;
    Materia lenguaje;
    Alumno mapu;

    @BeforeEach
    void setUp() {
        alumnoServicio = new AlumnoServicio();
        alumnoServicioMock = mock(AlumnoServicio.class);
        matematicas = new Materia();
        matematicas.setNombre(MateriaEnum.MATEMATICAS);
        lenguaje = new Materia();
        lenguaje.setNombre(MateriaEnum.LENGUAJE);

        mapu = new Alumno();
        mapu.setRut("11.111.111-1");
        mapu.setNombre("Mapu");
        mapu.setApellido("Perez");
        mapu.setDireccion("AV 123");
    }

    @Test
    @DisplayName("Test: crearAlumno()")
    void crearAlumnoTest() {
        alumnoServicio.crearAlumno(mapu);
        Map<String, Alumno> alumno = alumnoServicio.listarAlumnos();
        assertNotNull(alumno, "La lista de alumnos no debe ser NULL.");
        assertEquals(1, alumno.size(), "Debería haber 1 alumno en la lista.");
        assertTrue(alumno.containsKey("11.111.111-1"), "El KEY debería ser 11.111.111-1.");
        assertEquals("Mapu", alumno.get("11.111.111-1").getNombre(), "El nombre del alumno debería ser Mapu.");
    }

    @Test
    @DisplayName("Test: agregarMateria()")
    void agregarMateriaTest() {
        alumnoServicio.crearAlumno(mapu);
        alumnoServicio.agregarMateria("11.111.111-1", matematicas);

        List<Materia> materiaAlumno =  alumnoServicio.materiasPorAlumno("11.111.111-1");

        assertNotNull(materiaAlumno, "No debería ser NULO, debería tener materias.");
        assertEquals(1, materiaAlumno.size(), "Debería tener 1 sola materia.");
        assertEquals(MateriaEnum.MATEMATICAS, materiaAlumno.get(0).getNombre(), "La materia debería ser MATEMATICAS.");
    }

    @Test
    @DisplayName("Test: materiasPorAlumno()")
    void materiasPorAlumnoTest() {
        //Al existir instancia y recibir la lista de parametros, retornarle lista con matematica y lenguaje
        when(alumnoServicioMock.materiasPorAlumno("11.111.111-1")).thenReturn(List.of(matematicas, lenguaje));


        List<Materia> materiasAlumno = alumnoServicioMock.materiasPorAlumno("11.111.111-1");

        assertNotNull(materiasAlumno, "No debería ser NULO, debería tener materias.");
        assertEquals(2, materiasAlumno.size(), "Debería tener 2 materias.");
        assertEquals(MateriaEnum.MATEMATICAS, materiasAlumno.get(0).getNombre(), "Debería ser materia matematicas.");
        assertEquals(MateriaEnum.LENGUAJE, materiasAlumno.get(1).getNombre(), "Debería ser materia lenguaje.");

        verify(alumnoServicioMock, times(1)).materiasPorAlumno("11.111.111-1");
    }

    @Test
    @DisplayName("Test: listarAlumnos()")
    void listarAlumnosTest() {
        //Al llamar a listarAlumnos debemos retornarle un Map con su key y alumno
        when(alumnoServicioMock.listarAlumnos()).thenReturn(Map.of(mapu.getRut(), mapu));

        Map<String, Alumno> alumnos = alumnoServicioMock.listarAlumnos();

        assertNotNull(alumnos, "No debería ser nulo, debería tener alumnos");
        assertEquals(1, alumnos.size(), "Debería haber 1 alumno");
        assertEquals("Mapu", alumnos.get("11.111.111-1").getNombre(), "El nombre debería ser Mapu");

        verify(alumnoServicioMock, times(1)).listarAlumnos();
    }
}
