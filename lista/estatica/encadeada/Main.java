package lista.estatica.encadeada;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada(5);
        System.out.println(  lista.estaCheia());
        System.out.println(lista.inserirElemento(99));
        System.out.println(lista.inserirElemento(47));
        lista.imprimirLista();
        lista.inserirElemento(22, 1);
        lista.imprimirLista();
       
    }
}
