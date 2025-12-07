package moedas;

public class Dolar extends Moeda {
    private static final double Taxa_Cambio = 5.44;

    public Dolar (double valor) {
        super (valor);
    }

    @Override
    public String getNome() {
        return "Dólar";
    }

    @Override
    public double converterParaReal() {
        return valor * Taxa_Cambio;
    }

    public static double getTaxaCambio() {
        return Taxa_Cambio;
    }
}