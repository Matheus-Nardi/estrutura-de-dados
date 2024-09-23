package lista.estatica.encadeada;

public class Item {
    private int valor;
    private int vazio; // 1 para vazio e 0 para ocupado
    private int proximo; // aponta para o proximo item

    public Item() {
        this.vazio = 1; // Inicialmente vazio
        this.proximo = -1; // Sem próximo inicialmente
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getVazio() {
        return vazio;
    }

    public void setVazio(int vazio) {
        this.vazio = vazio;
    }

    public int getProximo() {
        return proximo;
    }

    public void setProximo(int proximo) {
        this.proximo = proximo;
    }

}
