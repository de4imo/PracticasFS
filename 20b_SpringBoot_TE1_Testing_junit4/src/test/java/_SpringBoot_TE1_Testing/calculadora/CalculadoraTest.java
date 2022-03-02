package _SpringBoot_TE1_Testing.calculadora;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.commons.annotation.Testable;


import java.util.Date;

import static org.junit.Assert.*;

//@Testable
public class CalculadoraTest {

    Calculadora calc;

    @Before //en junit5 @BeforeEach (denotes that the annotated method will be executed before each test method)
    public void before(){
        System.out.println("before()");
        calc = new Calculadora();
    }

    @Test
    public void main() {
        ///fail();
    }

    @Test
    public void suma() {
        int result = calc.suma(5, 5);
        int esperado = 10;
        assertEquals(esperado, result);
    }

    @Test
    public void resta() {
        int result = calc.resta(10, 8);
        int esperado = 2;
        assertEquals ("da error", esperado, result);
    }

    @Test
    public void same(){
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


    @Test(expected = ArithmeticException.class)
    public void testDivPorCero(){
        calc.div(5, 0);
    }

//JUNIT 5:
//    @Test
//    public void shouldRaiseAnException() throws Exception {
//        assertThrows(ArithmeticException.class, () -> {
//            calc.div(5, 0);
//        }, "se esperaba un ArithmeticException");
//    }

    //hacer que una test falle si emplea más tiempo del normal, se esperan 100milseg
    @Test(timeout = 300)
    @DisplayName("test")
    public void testAlgoritmOptimo(){
        calc.operacionOptima();
    }

//JUNIT 5:
//    @Test
//    public void testAlgoritmOptimo2() throws InterruptedException {
//        assertTimeout(Duration.ofMillis(100), () -> calc.operacionOptima(), "Se esperaba que tardase menos de 100ms");
//    }
}