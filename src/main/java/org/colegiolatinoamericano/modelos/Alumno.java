package org.colegiolatinoamericano.modelos;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String rut;
    private String nombre;
    private String apellido;
    private String direccion;
    private List<Materia> listMaterias = new ArrayList<>();  //SE PUEDE USAR SET O LIST... ESTUDIAR MEJOR CASO | CAMBIAR A MATERIAS
    
    public String getRut() {
        return rut;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getDireccion() {
        return direccion;
    }
    public List<Materia> getListMaterias() {
        return listMaterias;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setListMaterias(Materia materia) {
        this.listMaterias.add(materia);
    }

    @Override
    public String toString() {
        return "Alumno: " +
                "rut='" + rut + '\'' +
                " - " + nombre + '\'' +
                "[listMaterias=" + listMaterias +
                ']';
    }
}
