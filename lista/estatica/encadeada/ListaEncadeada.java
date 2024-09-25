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

    public boolean inserirInicio(int valor) {
        if (tamanho == itens.length) {
            return false;
        }
        int posicaoVazia = encontrarPosicaoVazia();
        if (posicaoVazia != -1) {
            int antigoPrimeiro = inicio;
            inicio = posicaoVazia;
            itens[inicio] = new Item();
            itens[inicio].setVazio(0);
            itens[inicio].setValor(valor);
            itens[inicio].setProximo(antigoPrimeiro);
            tamanho++;
            return true;
        }
        return false;

    }

    public boolean inserir(int valor, int posicao) {
        if (posicao < 0 && posicao > tamanho) {
            return false;
        }
        if (posicao == 0) {
            return inserirInicio(valor);
        }

        int posicaoVazia = encontrarPosicaoVazia();
        if (posicaoVazia != -1) {
            int anterior = inicio;
            for (int i = 0; i < posicao - 1; i++) {
                anterior = itens[anterior].getProximo();
            }

            itens[posicaoVazia] = new Item();
            itens[posicaoVazia].setVazio(0);
            itens[posicaoVazia].setValor(valor);

            itens[posicaoVazia].setProximo(itens[anterior].getProximo());
            itens[anterior].setProximo(posicaoVazia);
            return true;
        }
        return false;

    }

    public boolean remover() {
        if (inicio == -1) {
            return false;
        }

        if (itens[inicio].getProximo() == -1) {
            inicio = -1;
            tamanho--;
            return true;
        }

        int penultimo = inicio;
        int atual = itens[inicio].getProximo();

        while (itens[atual].getProximo() != -1) {
            penultimo = atual;
            atual = itens[atual].getProximo();
        }

        itens[penultimo].setProximo(-1); // se torna o ultimo
        itens[atual].setVazio(1);
        tamanho--;
        return true;

    }

    public void imprimir() {

        if (inicio == -1) {
            System.out.println("Lista vazia - NULL");
            return;
        }
        int atual = inicio;
        while (itens[atual].getProximo() != -1) {
            System.out.print(itens[atual].getValor() + " -> ");
            atual = itens[atual].getProximo();
        }

        System.out.println(itens[atual].getValor() + " -> NULL");

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
