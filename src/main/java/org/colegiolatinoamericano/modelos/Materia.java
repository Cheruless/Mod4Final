package org.colegiolatinoamericano.modelos;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private MateriaEnum nombre;
    private List<Float> notas = new ArrayList<>();

    public MateriaEnum getNombre() {
        return nombre;
    }
    public List<Float> getListNotasMateriaAlumno() {
        return notas;
    }

    public void setNombre(MateriaEnum nombre) {
        this.nombre = nombre;
    }
    public void setNotas(float nota) {
        this.notas.add(nota);
    }

    @Override
    public String toString() {
        return "[" +
                "nombre=" + nombre +
                ", notas=" + notas +
                ']';
    }
}
