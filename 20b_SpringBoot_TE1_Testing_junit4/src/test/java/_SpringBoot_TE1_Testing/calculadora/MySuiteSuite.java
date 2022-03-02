package _SpringBoot_TE1_Testing.calculadora;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//Para ejecutar una suite de varios test, además los realiza en orden en el que se ponga en "@Suite.SuiteClasses({..."
@RunWith(value = Suite.class)
@Suite.SuiteClasses({
        CalculadoraTest.class,
        CalculadoraParametroTest.class
})
public class MySuiteSuite {
}
