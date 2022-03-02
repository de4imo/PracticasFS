package _SpringBoot_TE1_Testing.calculadora;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    Calculadora calc;

    @BeforeEach //(previously @Before) denotes that the annotated method will be executed before each test method
    public void before(){
        System.out.println("before()");
        calc = new Calculadora();
    }

    @Test
    void main() {
        ///fail();
    }

    @DisplayName("Sumar dos numeros")
    @Test
    void suma() {
        int result = calc.suma(5, 5);
        int esperado = 10;
        assertEquals(esperado, result);
    }

    @Test
    void resta() {
        int result = calc.resta(10, 8);
        int esperado = 2;
        assertEquals (esperado, result, "da error");
    }

    @Test
    void same(){
//        String s1 = "aa";
//        String s2 = "aa";
//        assertSame(s1, s2);

        Date d1 = new Date();
        Date d2 = new Date();
        assertEquals(d1, d2); //Compara si son iguales
        assertSame(d1, d2); //compara si son el mismo
    }

    @Test
    public void testSum(){
       // Calculadora calc = new Calculadora();
        int resul = calc.add(3, 2);
        int esper = 5;
        assertEquals(resul, esper);
    }

    @Test
    public void testAnsSum(){
     //   Calculadora calc = new Calculadora();
        int resul = calc.add(3, 2);
        int esper = calc.ans();
        assertEquals(resul, esper);
    }

    @Test
    public void testDiv(){
        calc.div(5, 2);
    }

//      Ya no se puede usar como en JUNIT 4:
/*    @Test(expected = ArithmeticException.class)
    public void testDivPorCero(){
        calc.div(5, 0);
    }*/

    //Ahora en JUNIT5:
    @Test
    public void shouldRaiseAnException() throws Exception {
        assertThrows(ArithmeticException.class, () -> {
            calc.div(5, 0);
        }, "se esperaba un ArithmeticException");
    }

    //hacer que una test falle si emplea más tiempo del normal, se esperan 100milseg
    //pero esto es de JUNIT 4....
/*    @Test(timeout = 100)
    public void testAlgoritmOptimo(){
        calc.operacionOptima();
    }*/

    @Test
    public void testAlgoritmOptimo2() throws InterruptedException {
        assertTimeout(Duration.ofMillis(100), () -> calc.operacionOptima(), "Se esperaba que tardase menos de 100ms");
    }
}