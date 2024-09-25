package lista.estatica.sequencial;

import java.util.Arrays;

public class Lista {
    private int tamanho;
    private Item[] itens;

    public Lista(int capacidade) {
        this.tamanho = 0;
        this.itens = new Item[capacidade];
        for (int i = 0; i < itens.length; i++) {
            itens[i] = new Item();
        }
    }

    public boolean estaCheia() {
        return this.tamanho == this.itens.length;
    }

    public boolean inserir(int valor) {
        if (estaCheia())
            return false;

        this.itens[tamanho] = new Item(valor);
        tamanho++;
        return true;
    }

    public boolean inserir(int valor, int posicao) {
        if (posicao < 0 || posicao > tamanho)
            return false;

        if (estaCheia())
            return false;

        for (int i = tamanho; i > posicao; i--) {
            itens[i] = itens[i - 1];
        }

        itens[posicao] = new Item(valor);
        tamanho++;
        return true;
    }

    public boolean inserirInicio(int valor) {
        if (estaCheia())
            return false;

        for (int i = tamanho; i >= 0; i--) {
            itens[i + 1] = itens[i];
        }

        itens[0] = new Item(valor);
        tamanho++;
        return true;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean remover() {
        if (estaVazia())
            return false;

        --tamanho;
        return true;
    }

    public boolean remover(int posicao) {
        if (posicao < 0 || posicao > tamanho)
            return false;

        for (int i = 0; i < tamanho; i++) {
            if (i == posicao) {
                itens[i] = itens[i + 1];
            }
        }
        tamanho--;
        return true;
    }

    public boolean removerOcorrencia(int valor) {
        if (estaVazia())
            return false;

        for (int i = 0; i < tamanho; i++) {

            if (itens[i].getValor() == valor) {
                remover(i);
                i--;
            }
        }
        return true;
    }

    public boolean inserirValorADepoisDeValorB(int valorA, int valorB) {
        if (estaCheia())
            return true;

        for (int i = 0; i < tamanho; i++) {
            if (itens[i].getValor() == valorB) {
                inserir(valorA, i + 1);
                return true;
            }
        }

        return false;
    }

    public void imprimir() {
        for (int i = 0; i < this.tamanho; i++) {
            System.out.println(itens[i]);
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public Item[] getItens() {
        return itens;
    }

    public void setItens(Item[] itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Lista [tamanho=" + tamanho + ", itens=" + Arrays.toString(itens) + "]";
    }

}
