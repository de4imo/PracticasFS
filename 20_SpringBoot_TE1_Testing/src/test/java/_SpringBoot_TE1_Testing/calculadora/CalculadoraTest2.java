package _SpringBoot_TE1_Testing.calculadora;

import org.junit.*;

import java.time.Duration;

import static org.junit.Assert.*;


public class CalculadoraTest2 {

    static Calculadora calc;

    //Solo se ejecuta 1 vez antes de todo lo demás
    @BeforeClass  //en junit 5 --> @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");
        calc = new Calculadora();
    }

    //Se ejecuta 1 vez antes de cada test unitario
    @Before //en junit 5 --> @BeforeEach
    public void beforeEach(){
        System.out.println("beforeEach");
        calc.clear();
    }

    //Se ejecuta 1 vez después de cada test unitario
    @After  //en junit 5 --> @AfterEach
    public void afterEach(){
        System.out.println("afterEach()");
    }

    //Solo se ejecuta 1 vez después de todo
    @AfterClass //en junit 5--> @AfterAll
    public static void afterAll(){
        System.out.println("afterAll()");
        calc.clear();
    }



    @Test
    public void testAnsSum(){
        System.out.println("testAnsSum()");
        int resul = calc.add(3, 2);
        int esper = calc.ans();
        assertEquals(resul, esper);
    }

    @Test
    public void testDiv(){
        System.out.println("testDiv()");
        calc.div(5, 2);
    }

    @Test
    public void shouldRaiseAnException() throws Exception {
        System.out.println("shouldRaiseAnException()");
        assertThrows(ArithmeticException.class, () -> {
            calc.div(5, 0);
        }, "se esperaba un ArithmeticException");
    }

    @Test
    public void testAlgoritmOptimo2() throws InterruptedException {
        System.out.println("testAlgoritmOptimo2()");
        assertTimeout(Duration.ofMillis(250), () -> calc.operacionOptima(), "Se esperaba que tardase menos de 250ms");
    }
}
