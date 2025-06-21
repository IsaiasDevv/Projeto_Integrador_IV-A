package Projeto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraTeste {

    // Instância da classe que será testada
    Calculadora calc = new Calculadora();

    @Test
    void testSomar() {
        // Testa soma de dois números positivos
        assertEquals(5, calc.somar(2, 3));

        // Testa soma de número negativo com positivo (resultado zero)
        assertEquals(0, calc.somar(-2, 2));

        // Testa soma de dois números negativos
        assertEquals(-5, calc.somar(-2, -3));
    }

    @Test
    void testSubtrair() {
        // Testa subtração entre dois números positivos
        assertEquals(1, calc.subtrair(3, 2));

        // Testa subtração com número negativo e positivo
        assertEquals(-4, calc.subtrair(-2, 2));

        // Testa subtração entre dois negativos
        assertEquals(1, calc.subtrair(-2, -3));
    }

    @Test
    void testMultiplicar() {
        // Testa multiplicação de dois números positivos
        assertEquals(6, calc.multiplicar(2, 3));

        // Testa multiplicação entre negativo e positivo
        assertEquals(-4, calc.multiplicar(-2, 2));

        // Testa multiplicação por zero
        assertEquals(0, calc.multiplicar(0, 10));
    }

    @Test
    void testDividir() {
        // Testa divisão de dois números positivos
        assertEquals(2, calc.dividir(6, 3));

        // Testa divisão de negativo por positivo
        assertEquals(-2, calc.dividir(-4, 2));

        // Testa divisão de negativo por negativo
        assertEquals(2, calc.dividir(-6, -3));
    }

    @Test
    void testDivisaoPorZero() {
        // Testa se o método lança a exceção correta ao tentar dividir por zero
        assertThrows(IllegalArgumentException.class, () -> {
            calc.dividir(10, 0);
        });
    }
}