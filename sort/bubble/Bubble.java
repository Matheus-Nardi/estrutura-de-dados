package sort.bubble;

import java.util.Random;

public class Bubble {

    public static void randFill(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1, 1000);
        }
    }

    public static void printArray(int[] arr, int linha) {
        for (int i = 1; i <= arr.length; i++) {
            System.out.print("\t" + (i - 1) + "[" + arr[i - 1] + "]");
            if (i % linha == 0)
                System.out.print("\n");
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;

    }

    // O(n²)
    /*
     * Problema desse bubble: Realiza trocas e comparações desnecessárias, mesmo
     * sabendo que o maior elemento está na ultima posição e não é necessario
     * compara-lo
     */
    public static Result bubbleZero(int[] arr) {
        int comparacoes = 0;
        int trocas = 0;
        int varreduras = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    comparacoes++;
                    swap(arr, j, j + 1);
                    trocas++;
                }
            }
            varreduras++;
        }
        return new Result(varreduras, comparacoes, trocas);
    }

    /*
     * Melhoria do bubble zero. Percorre de maneira que não realiza comparações com
     * os ulitmos elementos, visto que já estão na posição correta.
     * Logo, um array de 100 posições, fára com que vá decrementando o número de
     * trocas e comparações
     */
    public static Result bubbleOne(int[] arr) {
        int comparacoes = 0;
        int trocas = 0;
        int varreduras = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    comparacoes++;
                    swap(arr, j, j + 1);
                    trocas++;
                }
            }
            varreduras++;
        }
        return new Result(varreduras, comparacoes, trocas);
    }

    /*
     * Aqui adicionamos uma flag para verificar se foram feitas trocas durante a
     * varredura. Se nenhuma troca foi realizar é sinal que o array já esta
     * ordenado.
     */
    public static Result bubbleTwo(int[] arr) {
        int flag;
        int comparacoes = 0;
        int trocas = 0;
        int varreduras = 0;

        for (int i = 0; i < arr.length; i++) {
            flag = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    comparacoes++;
                    flag = 1;
                    swap(arr, j, j + 1);
                    trocas++;
                }
            }
            if (flag == 0) {
                i = arr.length;
            }
            varreduras++;
        }
        return new Result(varreduras, comparacoes, trocas);
    }

    /*
     * Ao mesmo tempo que realizamos um bubble, também realizamos um selection sort.
     * Pois alocamos os menores números no inicio do array
     */
    public static Result bubbleThree(int[] arr) {

        int flag;
        int menor;
        int comparacoes = 0;
        int trocas = 0;
        int varreduras = 0;

        for (int i = 0; i < arr.length; i++) {
            flag = 0;
            menor = i;
            for (int j = i; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    comparacoes++;
                    flag = 1;
                    swap(arr, j, j + 1);
                    trocas++;
                }
                if (arr[j] < arr[menor]) {
                    comparacoes++;
                    menor = j;
                }
            }
            swap(arr, menor, i);
            trocas++;
            if (flag == 0) {
                i = arr.length;
            }
            varreduras++;
        }
        return new Result(varreduras, comparacoes, trocas);
    }
}
