public class Fila {

    int tamanho; // tamanho lógico

    Item[] itens;

    public Fila(int qtdElementos) {
        tamanho = 0;
        itens = new Item[qtdElementos];
    }

    public boolean estaCheia() {
        return tamanho == itens.length; // Se der true, está cheia
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public void imprimir() {

        if (estaVazia()) {
            System.out.println("VAZIA");
            return;
        }
     
        for (int i = 0; i < tamanho; i++) {
            System.out.printf("[%d]\t", i);
        }
        System.out.println();

        for (int i = 0; i < tamanho; i++) {
            System.out.printf("[%d]\t", itens[i].valor);
        }
        System.out.println();
    }

    public void enfileirar(Item item) {
        if (!estaCheia()) {
            itens[tamanho] = item;
            tamanho++;
        }

    }

    public void desenfileirar() {
        if (!estaVazia()) {
            for (int i = 0; i < tamanho - 1; i++) {
                itens[i] = itens[i + 1];
            }
            tamanho--;
        }
    }

    public void primeiro() {
        if (estaVazia()) {
            System.out.println("VAZIA");
            return;
        }

        System.out.println("O primeiro valor é: " + itens[0].valor);
    }

    public boolean contem(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (itens[i].valor == valor)
                return true;
        }

        return false;
    }

    public void limpar(){
        tamanho = 0;
    }
}
