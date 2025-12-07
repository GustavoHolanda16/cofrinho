import moedas.*;
import java.util.Scanner;

public class Principal {
    private static Cofrinho cofrinho = new Cofrinho();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("      SISTEMA COFRINHO DE MOEDAS");
        System.out.println("==========================================");
        System.out.println("Cotações fixas:");
        System.out.printf("  1 Dólar  = R$ %.2f%n", Dolar.getTaxaCambio());
        System.out.printf("  1 Euro   = R$ %.2f%n", Euro.getTaxaCambio());
        System.out.println("  1 Real   = R$ 1.00");
        System.out.println("==========================================");
        
        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            processarOpcao(opcao);
        } while (opcao != 5);
        
        System.out.println("\nObrigado por usar o Sistema Cofrinho!");
        scanner.close();
    }
    

    private static void exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Adicionar moeda");
        System.out.println("2. Remover moeda");
        System.out.println("3. Listar moedas");
        System.out.println("4. Calcular total em Reais");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
   
    private static int lerOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, digite um número entre 1 e 5: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
    
   
    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarMoeda();
                break;
            case 2:
                removerMoeda();
                break;
            case 3:
                cofrinho.listarMoedas();
                break;
            case 4:
                calcularTotal();
                break;
            case 5:
                break;
            default:
                System.out.println("Opção inválida! Digite um número entre 1 e 5.");
        }
    }
    
   
    private static void adicionarMoeda() {
        System.out.println("\n--- ADICIONAR MOEDA ---");
        System.out.println("1. Real (BRL)");
        System.out.println("2. Dólar (USD)");
        System.out.println("3. Euro (EUR)");
        System.out.print("Escolha o tipo de moeda: ");
        
        int tipo = lerOpcao();
        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo de moeda inválido!");
            return;
        }
        
        System.out.print("Digite o valor da moeda: ");
        double valor = scanner.nextDouble();
        
        Moeda moeda;
        switch (tipo) {
            case 1:
                moeda = new Real(valor);
                break;
            case 2:
                moeda = new Dolar(valor);
                break;
            case 3:
                moeda = new Euro(valor);
                break;
            default:
                moeda = null;
        }
        
        if (moeda != null) {
            cofrinho.adicionar(moeda);
        }
    }
    
   
    private static void removerMoeda() {
        System.out.println("\n--- REMOVER MOEDA ---");
        
        if (cofrinho.getMoedas().isEmpty()) {
            System.out.println("O cofrinho está vazio! Não há moedas para remover.");
            return;
        }
        
        
        cofrinho.listarMoedas();
        
        System.out.println("1. Real (BRL)");
        System.out.println("2. Dólar (USD)");
        System.out.println("3. Euro (EUR)");
        System.out.print("Escolha o tipo de moeda a remover: ");
        
        int tipo = lerOpcao();
        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo de moeda inválido!");
            return;
        }
        
        System.out.print("Digite o valor da moeda a remover: ");
        double valor = scanner.nextDouble();
        
        Moeda moeda;
        switch (tipo) {
            case 1:
                moeda = new Real(valor);
                break;
            case 2:
                moeda = new Dolar(valor);
                break;
            case 3:
                moeda = new Euro(valor);
                break;
            default:
                moeda = null;
        }
        
        if (moeda != null) {
            cofrinho.remover(moeda);
        }
    }
    
    private static void calcularTotal() {
        double total = cofrinho.calcularTotalEmReal();
        System.out.printf("\n=== TOTAL NO COFRINHO ===%n");
        System.out.printf("Valor total convertido para Real: R$ %.2f%n", total);
        System.out.println("===========================\n");
    }
}