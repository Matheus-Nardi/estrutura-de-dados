package lista.simplencadeada;

public class Main {

    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.insertStart(33);
        lista.insertEnd(13);
        lista.insertEnd(44);
        lista.insertEnd(83);

        lista.print();
        System.out.println();
        System.out.println(lista.size());
        System.out.println(lista.occurrences(33));

        lista.swap(13);
        System.out.println();
        lista.print();
    }
}

class Item {
    int chave;
    Item proximo;

    public Item(int chave) {
        this.chave = chave;
        this.proximo = null;
    }
}

class Lista {
    int quantidade;
    Item inicio;

    public void insertStart(int chave) {
        if (this.inicio == null) {
            this.inicio = new Item(chave);
            return;
        }

        Item novoItem = new Item(chave);
        Item atual = this.inicio;
        this.inicio = novoItem;
        novoItem.proximo = atual;
    }

    public void insertEnd(int chave) {
        if (this.inicio == null) {
            insertStart(chave);
            return;
        }

        Item novo = new Item(chave);
        Item atual = this.inicio;

        while (atual.proximo != null) {
            atual = atual.proximo;
        }
        atual.proximo = novo;
    }

    public void print() {
        Item atual = this.inicio;

        while (atual != null) {
            System.out.print(atual.chave + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }

    public int size() {
        int size = 0;
        Item atual = this.inicio;

        while (atual != null) {
            size++;
            atual = atual.proximo;
        }

        return size;
    }

    public int occurrences(int chave) {
        int occurrences = 0;
        Item atual = this.inicio;

        while (atual != null) {
            if (atual.chave == chave)
                occurrences++;
            atual = atual.proximo;
        }

        return occurrences;
    }

    public void insertAfterItem(int chave, int novaChave) {
        Item atual = this.inicio;
        while (atual != null) {
            if (atual.chave == chave) {
                Item novoItem = new Item(novaChave);
                Item referencia = atual.proximo;
                atual.proximo = novoItem;
                novoItem.proximo = referencia;
                return;
            }
            atual = atual.proximo;
        }
    }

    public void swap(int chave) {
        Item anterior = previus(chave);

        if (anterior == null) {
            Item atual = this.inicio;

            if (atual != null && atual.proximo != null) {
                Item proximo = atual.proximo;
                this.inicio = proximo;
                atual.proximo = proximo.proximo;
                proximo.proximo = atual;
            }
            return;
        }

        Item atual = anterior.proximo;

        if (atual != null && atual.proximo != null) {
            Item proximo = atual.proximo;
            anterior.proximo = proximo;
            atual.proximo = proximo.proximo;
            proximo.proximo = atual;
        }
    }

    public Item previus(int chave) {
        if (this.inicio == null || this.inicio.chave == chave) {
            return null;
        }

        Item atual = this.inicio;
        Item anterior = null;

        while (atual != null && atual.chave != chave) {
            anterior = atual;
            atual = atual.proximo;
        }

        return anterior;
    }
}
