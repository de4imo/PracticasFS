package _SpringBoot_TE1_Testing.calculadora;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class CalculadoraTestMockito {

    @InjectMocks
    Calculadora calc; //dependiente

    @Mock
    CalculadoraOracleCloud calc0c; //Dependencia

    @Before
    public void init(){
        //calc = new Calculadora();
        when(calc0c.sum(5, 5)).thenReturn(10.0);
        when(calc0c.sum(10, 5)).thenReturn(15.0);
    }

    @Test
    public void probarSumaOracleCloud(){
        assertEquals(10, calc.sumOracleCloud(5, 5), 0.01);
    }
}