package moedas;

public class Euro extends Moeda {
    private static final double Taxa_cambio = 6.19;

    public Euro(double valor) {
        super(valor);
    } 

    @Override
    public String getNome() {
        return "Euro";
    }

    @Override
    public double converterParaReal() { 
        return valor * Taxa_cambio;
    }

    public static double getTaxaCambio(){
        return Taxa_cambio;
    }
}