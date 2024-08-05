import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lanchonete0{
    private static List<Lanche> lanches = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        

        List<Lanche> lanches = new ArrayList<>();
        

        Lanche hotdog = new Lanche("Hotdog", 4.00);
        Lanche xSalada = new Lanche("X Salada", 4.50);
        Lanche xBacon = new Lanche("X Bacon", 5.00);
        Lanche torrada = new Lanche("Torrada", 2.00);
        Lanche refrigerante = new Lanche("Refrigerante", 1.50);
        lanches.add(hotdog);
        lanches.add(xSalada);
        lanches.add(xBacon);
        lanches.add(torrada);
        lanches.add(refrigerante);
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Qual item você quer?");
            System.out.println("1 - Hotdog ------- 4,00");
            System.out.println("2 - X Salada ----- 4,50");
            System.out.println("3 - X Bacon ------ 5,00");
            System.out.println("4 - Torrada ------ 2,00");
            System.out.println("5 - Refri -------- 1,50");

            int codigo = scanner.nextInt();

            if (codigo < 1 || codigo > 5) {
                System.out.println("Código inválido!");
                continue;
            }

            System.out.println("Qual a quantidade?");
            int quantidade = scanner.nextInt();

            Lanche lancheEscolhido = lanches.get(codigo - 1);
            
            Pedido pedido = new Pedido(lancheEscolhido, quantidade);
            
            pedidos.add(pedido);

            System.out.println("Deseja adicionar mais alguma coisa? (s/n)");
            String resposta = scanner.next();

            if (resposta.equalsIgnoreCase("n")) {
                break;
            }
        }

        scanner.close();
        
        fecharPedido();
    }


    private static void fecharPedido() {
        double total = 0;
        System.out.println("Resumo do pedido:");
        for (Pedido pedido : pedidos) {
            double valor = pedido.getLanche().getPreco() * pedido.getQuantidade();
            System.out.println(pedido.getQuantidade() + " x " + pedido.getLanche().getNome() + " = " + valor);
            total += valor;
        }
        System.out.println("Total: " + total);
    }
}

class Lanche {
    private String nome;
    private double preco;

    public Lanche(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

class Pedido {
    private Lanche lanche;
    private int quantidade;

    public Pedido(Lanche lanche, int quantidade) {
        this.lanche = lanche;
        this.quantidade = quantidade;
    }

    public Lanche getLanche() {
        return lanche;
    }

    public int getQuantidade() {
        return quantidade;
    }
}