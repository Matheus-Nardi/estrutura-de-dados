package lista.estatica.encadeada;

public class ListaEncadeada {
    private int tamanho; // tamanho lógico
    private int inicio; // onde inicia a lista
    private Item[] itens;

    public ListaEncadeada(int capacidade) {
        this.tamanho = 0;
        this.inicio = -1;
        this.itens = new Item[capacidade];

        for (int i = 0; i < itens.length; i++) {
            itens[i] = new Item();
        }
    }

    public boolean estaCheia() {
        return tamanho == itens.length; // Se o tamanho lógico for igual ao tamanho físico
    }

    private int encontrarPosicaoVazia() {
        if (!estaCheia()) {
            for (int i = 0; i < itens.length; i++) {
                if (itens[i].getVazio() == 1)
                    return i;
            }
        }
        return -1; // indica que não encontrou nehuma posicao disponivel , lista cheia
    }

    private int encontrarUltimo() {
        int atual = inicio;
        while (itens[atual].getProximo() != -1) {
            atual = itens[atual].getProximo();
        }

        return atual;
    }

    public boolean inserirElemento(int elemento) {
        if (estaCheia())
            return false;

        int posicaoVazia = encontrarPosicaoVazia();
        Item item = this.itens[posicaoVazia];
        item.setValor(elemento);
        item.setVazio(0);
        item.setProximo(-1);
        if (this.inicio == -1) {
            inicio = posicaoVazia; // Se não houver elementos na lista , eu defino o novo inicio a partir da
                                   // primeira posicao livre encontrada
        } else {
            int atual = encontrarUltimo();
            itens[atual].setProximo(posicaoVazia);
        }

        this.tamanho++;
        return true;
    }

    public boolean inserirElemento(int elemento, int posicao) {
        if (validarPosicao(posicao)) {
            int posicaoVazia = encontrarPosicaoVazia();
            if (posicaoVazia == 1)
                return false;
            Item item = this.itens[posicaoVazia];
            item.setValor(elemento);
            item.setVazio(0);

            if (posicao == 0)
                inserirElemento(elemento);
            else {
                int anterior = encontrarElementoAnterior(posicao);
                if (anterior != -1) {
                    this.itens[anterior].setProximo(posicaoVazia);
                    item.setProximo(this.itens[anterior].getProximo());
                }
            }
            tamanho++;
            return true;
        }
        return false;

    }

    private boolean validarPosicao(int posicao) {
        return posicao >= 0 && posicao <= this.tamanho;
    }

    private int encontrarElementoAnterior(int posicao) {
        int atual = inicio;
        int index = 0;

        while (atual != -1 && index < posicao - 1) {
            atual = itens[atual].getProximo();
            index++;
        }

        return atual; // Retorna o índice do elemento anterior ou -1 se não encontrado
    }

    public void imprimirLista() {
        if (inicio == -1) {
            System.out.println("A lista está vazia.");
            return;
        }

        int atual = inicio;
        StringBuilder sb = new StringBuilder();
        int contador = 0; // Contador para evitar loops infinitos

        while (atual != -1) {
            sb.append(itens[atual].getValor());
            atual = itens[atual].getProximo();

            if (atual != -1) {
                sb.append(" -> ");
            }

            contador++;
            if (contador > itens.length) { // Evita loop infinito
                System.out.println("Loop infinito detectado!");
                break;
            }
        }

        System.out.println(sb.toString());
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public Item[] getItens() {
        return itens;
    }

    public void setItens(Item[] itens) {
        this.itens = itens;
    }

}
