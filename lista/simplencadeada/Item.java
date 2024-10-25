package lista.simplencadeada;
public class Item {
    int chave;
    Item proximo;

    // Inicializo um novo item
    public Item(int chave) {
        this.chave = chave;
        this.proximo = null;
    }

    public Item() {
        super();
    }

}