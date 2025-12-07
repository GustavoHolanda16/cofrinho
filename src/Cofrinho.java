import moedas.Moeda;
import java.util.ArrayList;
import java.util.List;

public class Cofrinho {
    private List<Moeda> moedas;

    public Cofrinho() {
        this.moedas = new ArrayList<>();
    }  
    public void adicionar(Moeda moeda) {
        moedas.add(moeda);
        System.out.println("Moeda adicionada: " + moeda);
    }

    public boolean remover(Moeda moeda) {
        if (moedas.contains(moeda)) {
            moedas.remove(moeda);
            System.out.println("Moeda removida: " + moeda);
            return true;
        } else {
            System.out.println("Moeda não encontrada no cofrinho!");
            return false;
        }
    }

    public void listarMoedas() {
        if (moedas.isEmpty()) {
            System.out.println("O cofrinho está vazio!");
            return;
        }
        
        System.out.println("\n=== MOEDAS NO COFRINHO ===");
        for (int i = 0; i < moedas.size(); i++) {
            Moeda moeda = moedas.get(i);
            System.out.printf("%d. %s (Valor original: %.2f) → R$ %.2f%n", 
                i + 1, moeda, moeda.getValor(), moeda.converterParaReal());
        }
        System.out.println("==========================\n");
    }

    public double calcularTotalEmReal() {
        double total = 0;
        for (Moeda moeda : moedas) {
            total += moeda.converterParaReal();
        }
        return total;
    }
    
    public List<Moeda> getMoedas() {
        return moedas;
    }
}