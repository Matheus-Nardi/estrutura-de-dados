package lista.estatica.sequencial;

public class Main {
    public static void main(String[] args) {
        Lista minhaLista = new Lista(10);
        minhaLista.inserir(new Item(1));
        minhaLista.inserir(new Item(8));
        minhaLista.inserir(new Item(4));

        minhaLista.imprimir();
        minhaLista.removerInicioLista();

        minhaLista.imprimir();
    }
}
