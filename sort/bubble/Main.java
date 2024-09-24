package sort.bubble;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Criando um array com 100 elementos aleatórios
        int[] arrZero = new int[100];
        Bubble.randFill(arrZero);
        System.out.println("=============ARRAY ORIGINAL============");
        Bubble.printArray(arrZero, 10);

        // Executando o Bubble Zero
        System.out.println("=============BUBBLE ZERO============");
        int[] arrBubbleZero = Arrays.copyOf(arrZero, arrZero.length);
        System.out.println(Bubble.bubbleZero(arrBubbleZero));
        Bubble.printArray(arrBubbleZero, 10);

        // Executando o Bubble One
        System.out.println("=============BUBBLE ONE============");
        int[] arrBubbleOne = Arrays.copyOf(arrZero, arrZero.length);
        System.out.println(Bubble.bubbleOne(arrBubbleOne));
        Bubble.printArray(arrBubbleOne, 10);

        // Executando o Bubble Two
        System.out.println("=============BUBBLE TWO============");
        int[] arrBubbleTwo = Arrays.copyOf(arrZero, arrZero.length);
        System.out.println(Bubble.bubbleTwo(arrBubbleTwo));
        Bubble.printArray(arrBubbleTwo, 10);

        System.out.println("=============BUBBLE THREE============");
        int[] arrBubbleThree = Arrays.copyOf(arrZero, arrZero.length);
        System.out.println(Bubble.bubbleThree(arrBubbleThree));
        Bubble.printArray(arrBubbleTwo, 10);
    }
}
