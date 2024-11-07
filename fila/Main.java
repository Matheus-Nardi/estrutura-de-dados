import java.util.Scanner;

public class Main {

    private final static Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int op = Integer.MIN_VALUE;
        System.out.println("Digite o tamanho físico da fila: ");
        int tamanhoFisico = SCAN.nextInt();
        Fila fila = new Fila(tamanhoFisico);

        while (op != 0) {
            System.out.println("====================");
            System.out.println("Digite uma opção: ");
            System.out.println("0.SAIR");
            System.out.println("1.TAMANHO DA FILA");
            System.out.println("2.ENFILEIRAR");
            System.out.println("3.DESINFILERAR");
            System.out.println("4.PRIMEIRO");
            System.out.println("5.BUSCAR");
            System.out.println("6.LIMPAR");
            System.out.println("7.IMPRIMIR");

            op = SCAN.nextInt();

            switch (op) {
                case 1:
                    System.out.println("O tamanho da fila é: " + fila.tamanho());
                    break;
                case 2:
                    System.out.println("Informe um valor a enfileirar: ");
                    int valor = SCAN.nextInt();
                    Item item = new Item(valor);
                    fila.enfileirar(item);
                    fila.imprimir();
                    break;
                case 3:
                    fila.desenfileirar();
                    fila.imprimir();
                    break;
                case 4:
                    fila.primeiro();
                    break;
                case 5:
                    System.out.println("Informe um valor a ser buscado: ");
                    int buscado = SCAN.nextInt();
                    System.out.println(fila.contem(buscado) ? "Valor encontrado !" : "Valor não encontrado !");
                    break;
                case 6:
                    fila.limpar();
                    fila.imprimir();
                    break;
                case 7:
                    fila.imprimir();
                    break;

            }
        }

    }
}
