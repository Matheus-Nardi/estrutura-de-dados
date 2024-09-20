package lista.estatica.sequencial;

import java.util.Arrays;

public class Lista implements ListaEstaticaSequencial {
    private int tamanho;
    private Item[] itens;

    public Lista(int qtdElementos) {
        this.tamanho = 0;
        this.itens = new Item[qtdElementos];
    }

    @Override
    public void inserir(Item item) {
        if (estaCheia()) {
            throw new IllegalArgumentException("A lista está cheia");
        }
        this.itens[tamanho] = item;
        this.tamanho++;
    }

    @Override
    public void inserirElementoNoInicio(Item item) {
        if (estaCheia())
            throw new IllegalArgumentException("A lista está cheia");

        for (int i = tamanho - 1; i >= 0; i--) { // ate desocupar o indice 0
            itens[i + 1] = itens[i]; // Fazer com que os elementos andem para frente
        }

        itens[0] = item;
    }

    @Override
    public void removerPrimeiraOcorrencia(Item item) {
        int indiceRemover = -1;
        for (int i = 0; i < itens.length; i++) {
            if (itens[i] != null && itens[i].equals(item)) {
                indiceRemover = i;
            }
        }

        if (indiceRemover == -1)
            throw new IllegalArgumentException("Elemento não encontrado");

        for (int i = indiceRemover; i < tamanho - 1; i++) {
            itens[i] = itens[i + 1];
        }
        this.tamanho--;
    }

    @Override
    public void removerInicioLista() {
        for (int i = 0; i < tamanho - 1; i++) {
            itens[i] = itens[i + 1];
        }

        this.tamanho--;
    }

    @Override
    public void inserirElementoApos(Item itemA, Item itemB) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserirElementoApos'");
    }

    @Override
    public boolean estaCheia() {
        return this.tamanho == this.itens.length;
    }

    @Override
    public Item removerElementoFinal() {

        return this.itens[--this.tamanho];
    }

    @Override
    public void imprimir() {
        System.out.println("Tamanho Lógico: " + this.tamanho);
        System.out.println("Tamanho Físico: " + this.itens.length);
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
