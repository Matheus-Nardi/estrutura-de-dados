package lista.estatica.encadeada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        navegar();
    }

    private static void navegar() {
        Scanner scanner = new Scanner(System.in);
        ListaEncadeada lista = new ListaEncadeada(10);
        boolean continuar = true;

        while (continuar) {
            menu();
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o valor para adicionar no final: ");
                    int valorFinal = scanner.nextInt();
                    lista.inserirElemento(valorFinal);
                    break;
                case 2:
                    System.out.print("Digite o valor para adicionar no início: ");
                    int valorInicio = scanner.nextInt();
                    lista.inserirInicio(valorInicio);
                    break;
                case 3:
                    System.out.print("Digite o valor para adicionar: ");
                    int valor = scanner.nextInt();
                    System.out.print("Digite a posição onde deseja inserir: ");
                    int posicao = scanner.nextInt();
                    lista.inserir(valor, posicao);
                    break;
                case 4:
                    lista.remover();
                    break;
                case 5:
                    lista.imprimir();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();

    }

    private static void menu() {
        System.out.println("\n===========LISTA ENCADEADA==========");
        System.out.println("1. ADICIONAR ELEMENTO NO FINAL");
        System.out.println("2. ADICIONAR ELEMENTO NO INÍCIO");
        System.out.println("3. ADICIONAR ELEMENTO EM QUALQUER POSIÇÃO");
        System.out.println("4. REMOVER ELEMENTO");
        System.out.println("5. IMPRIMIR");
        System.out.println("6. SAIR");
        System.out.print("Escolha uma opção: ");
    }
}
