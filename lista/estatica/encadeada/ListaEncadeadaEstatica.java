package lista.estatica.encadeada;

public class ListaEncadeadaEstatica {
    private int[] elementos;
    private int[] proximos;
    private int inicio;
    private int espacoLivre;
    private int tamanho;

    public ListaEncadeadaEstatica(int capacidade) {
        this.elementos = new int[capacidade];
        this.proximos = new int[capacidade];
        this.inicio = -1; // indicando que não há elementos, logo apontando para o indice -1
        this.espacoLivre = 0; // indicando que o espaco livre está no indice 0
        this.tamanho = 0;

        // Inicializamos o array de próximos, onde cada posição aponta para a próxima
        // livre
        for (int i = 0; i < capacidade - 1; i++) {
            proximos[i] = i + 1;
        }
        proximos[capacidade - 1] = -1; // O último índice não tem próximo
    }

    public void adicionar(int novoElemento) {
        if (estaCheia()) {
            throw new IllegalStateException("A lista está cheia");
        }

        int novoIndice = espacoLivre;
        elementos[novoIndice] = novoElemento;

        espacoLivre = proximos[novoIndice];

        if (inicio == -1) {
            inicio = novoIndice;
        } else {
            int atual = inicio;
            while (proximos[atual] != -1) {
                atual = proximos[atual];
            }
            proximos[atual] = novoIndice;
        }

        proximos[novoIndice] = -1;
        tamanho++;

    }

    public boolean estaCheia() {
        return espacoLivre == -1;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void imprimir() {
        int atual = inicio;
        while (atual != -1) {
            System.out.print(elementos[atual] + " -> ");
            atual = proximos[atual];
        }
        System.out.println("null");
        System.out.println("Inicio: " + inicio);
        System.out.println("Espaço livre:" + espacoLivre);
        System.out.println("Tamanho:" + tamanho);
    }

}
