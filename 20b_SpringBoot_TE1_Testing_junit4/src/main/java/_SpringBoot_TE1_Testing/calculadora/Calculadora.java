package _SpringBoot_TE1_Testing.calculadora;

public class Calculadora {

    private int ans;

    public Calculadora(){
        ans = 0;
    }

    public static int suma(int a, int b){
        return a+b;
    }

    public static int resta(int a, int b){
        return a-b;
    }

    public int add(int a, int b){
        ans = a+b;
        return ans;
    }

    public int sub(int a, int b){
        ans = a-b;
        return ans;
    }

    public int add(int v){
        ans+=v;
        return ans;
    }

    public int sub(int v){
        ans-=v;
        return ans;
    }

    public int ans(){
        return ans;
    }

    public int div(int a, int b){
        if(b == 0)
            throw  new ArithmeticException();
        ans = a/b;
        return ans;
    }

    public void operacionOptima(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) { }
    }

    public void clear() {
        this.ans = 0;
    }

    //deberíamos poner alguna anotación para inyectar la dependencia, pero es así para el test de mockito
    CalculadoraOracleCloud calcOc;

    public double sumOracleCloud(double a, double b){
        return calcOc.sum(a, b);
    }
}
