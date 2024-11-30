package org.colegiolatinoamericano.servicios;

import java.util.List;

public class PromedioServicioImp {
    public float calcularPromedio(List<Float> valores) {
        if (!valores.isEmpty()) {
            float prom = 0;
            for (float valor : valores)
                prom += valor;
            return (prom / valores.size());
        }
        return 0;
    }
}
