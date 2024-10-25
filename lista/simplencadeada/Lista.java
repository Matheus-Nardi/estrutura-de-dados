package lista.simplencadeada;

public class Lista {
    int quantidade; // Representa a quantidade de elementos da lista
    Item inicio; // Ela se torna dinamica aqui, não há um tamanho físico, mas sim a referencia do
                 // proximo

    // Método para inserir no inicio
    public void insertStart(int chave) {
        // Verificar se a this esta vazia inicio.proximo == NULL
        // Caso esteja, redefino meu novo ínicio
        // Caso contrário, apenas realizo o encadeamento

        if (this.inicio == null) {
            this.inicio = new Item(chave); // Insiro na primeira posição
            return;
        }

        Item novoItem = new Item(chave); // Criando um novo item a ser inserido
        Item atual = this.inicio;
        this.inicio = novoItem;
        novoItem.proximo = atual; // Aponta para o antigo inicio
    }

    // Método para inserir no final
    public void insertEnd(int chave) {
        // Verificar se a this está vazia
        // Caso esteja eu apenas chamo inserir inicio
        // Caso não, procuro o ultimo elemento, onde o proximo seja nulo

        if (this.inicio == null) {
            insertStart(chave);
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
    }

    public int size() {
        int size = 0;
        Item atual = this.inicio;

        // Percorrer a lista até o proximo ser NULL e contar os elementos
        while (atual != null) {
            size++;
            atual = atual.proximo; // Percorre a lista
        }

        return size;

    }

    public int occurrences(int chave) {
        int occurrences = 0;
        Item atual = this.inicio;
        while (atual != null) {
            if (atual.chave == chave)
                occurrences++;

            atual = atual.proximo; // Percorre a lista
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

        // Verificar se há anterior
        if (anterior == null) {
           // Se for null, indica que estamos na primeira posição
            Item atual = this.inicio;

            // Verificamos se há proximo para ser trocado
            if (atual != null && atual.proximo != null) {
                // Se houver, ocorre o swap.
                Item proximo = atual.proximo;
                this.inicio = proximo; // Defini o novo inicio da lista
                atual.proximo = proximo.proximo;
                proximo.proximo = atual;
            }
            return;
        }

        Item atual = anterior.proximo;

        // Caso não seja primeiro, verifaremos se está no "meio"
        if (atual != null && atual.proximo != null) {
            Item proximo = atual.proximo;

            // Ajustar as referências e fazer o swap
            anterior.proximo = proximo;
            atual.proximo = proximo.proximo;
            proximo.proximo = atual;
        }
    }

    public Item previus(int chave) {
        // Não há anteriores
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
