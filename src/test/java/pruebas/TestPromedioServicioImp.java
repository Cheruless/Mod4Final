package pruebas;

import org.colegiolatinoamericano.servicios.PromedioServicioImp;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test para PromedioServicioImp")
public class TestPromedioServicioImp {

    PromedioServicioImp promedioTest;

    @BeforeEach
    void setUp() {
        promedioTest = new PromedioServicioImp();
    }

    @Test
    @DisplayName("Caso 1: Lista con notas normales")
    void testCalcularPromedioNotasNormales() {
        List<Float> valores = List.of(5.0f, 6.0f, 7.0f);
        float resultado = promedioTest.calcularPromedio(valores);
        assertEquals(6.0f, resultado, "El promedio de 5, 6 y 7 debería ser 6");
    }

    @Test
    @DisplayName("Caso 2: Lista vacía")
    void testCalcularPromedioListaVacia() {
        List<Float> valores = List.of();
        float resultado = promedioTest.calcularPromedio(valores);
        assertEquals(0.0f, resultado, "El promedio de una lista vacía debería ser 0");
    }

    @Test
    @DisplayName("Caso 3: Lista con una sola nota")
    void testCalcularPromedioUnaNota() {
        List<Float> valores = List.of(4.5f);
        float resultado = promedioTest.calcularPromedio(valores);
        assertEquals(4.5f, resultado, "El promedio de una lista con una nota debería ser esa misma nota");
    }

    @Test
    @DisplayName("Caso 4: Lista con todas las notas en el límite inferior")
    void testCalcularPromedioNotasLimiteInferior() {
        List<Float> valores = List.of(0.0f, 0.0f, 0.0f);
        float resultado = promedioTest.calcularPromedio(valores);
        assertEquals(0.0f, resultado, "El promedio de todas las notas 0 debería ser 0");
    }

    @Test
    @DisplayName("Caso 5: Lista con todas las notas en el límite superior")
    void testCalcularPromedioNotasLimiteSuperior() {
        List<Float> valores = List.of(7.0f, 7.0f, 7.0f);
        float resultado = promedioTest.calcularPromedio(valores);
        assertEquals(7.0f, resultado, "El promedio de todas las notas 7 debería ser 7");
    }

    @Test
    @DisplayName("Caso 6: Lista con valores mixtos dentro del rango")
    void testCalcularPromedioNotasMixtas() {
        List<Float> valores = List.of(3.5f, 5.0f, 6.5f);
        float resultado = promedioTest.calcularPromedio(valores);
        assertEquals(5.0f, resultado, "El promedio de 3.5, 5.0 y 6.5 debería ser 5");
    }
}

