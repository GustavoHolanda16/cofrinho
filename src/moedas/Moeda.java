package moedas;

public abstract class Moeda {
    protected double valor;

    public Moeda(double valor) {
        this.valor = valor;
    }

    public abstract double converterParaReal();

    public double getValor(){
        return valor;
    }

    public abstract String getNome();

    @Override 
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Moeda moeda = (Moeda) obj;
        return Double.compare(moeda.valor, valor) == 0;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getNome(), valor);
    }
}