package lista.estatica.sequencial;

public interface ListaEstaticaSequencial {
    void inserir(Item item);
    void inserirElementoNoInicio(Item item);
    void removerPrimeiraOcorrencia(Item item);
    void removerInicioLista();
    void inserirElementoApos(Item itemA , Item itemB);
    Item removerElementoFinal();
    boolean estaCheia();
    void imprimir();
}
