package _SpringBoot_TE1_Testing.calculadora;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


@RunWith(value = Parameterized.class)
public class CalculadoraParametroTest {

    @Parameters
    public static Iterable<Object[]> getData(){
        return Arrays.asList(new Object[][]{
                {3, 1, 4}, {2, 3, 5}, {3, 3, 6}
        });
    }

    private int a,  b,  exp;

    public CalculadoraParametroTest (int a, int b, int exp){
        this.a = a;
        this.b = b;
        this.exp = exp;
    }

    @Test
    public void testAdd(){
        Calculadora calc = new Calculadora();
        int resultado = calc.add(a, b);
        System.out.println("resultado: " + resultado);
        assertEquals(exp, resultado);
    }
}