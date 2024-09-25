package lista.estatica.sequencial;

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista(10);
        lista.inserir(22);
        lista.inserir(44);
        lista.inserir(12);
        lista.inserir(44);

        lista.imprimir();
        System.out.println();
        lista.removerOcorrencia(44);
        lista.imprimir();
        System.out.println();
        lista.inserir(78, 2);
        lista.imprimir();

        System.out.println();
        lista.inserirValorADepoisDeValorB(23, 22);
        lista.imprimir();
    }
}
