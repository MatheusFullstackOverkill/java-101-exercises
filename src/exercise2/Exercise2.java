package exercise2;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Faça um programa em que o usuário informa a altura e o comprimento de uma parede e o programa informa
    a quantidade de latas de tinta que devem ser compradas.
    Sabe-se que uma lata de tinta consegue pintar 1.6 m² de parede.
 */

public class Exercise2 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        double bucketSquareMeterCapacity = 1.6;

        try {
            System.out.println("Comprimento da parede");
            double length = scanner.nextDouble();

            System.out.println("Largura da largura");
            double width = scanner.nextDouble();

            Double totalWallSquareMeter = width * length;

            Double totalRequiredBuckets = totalWallSquareMeter / bucketSquareMeterCapacity;
            totalRequiredBuckets = Math.ceil(totalRequiredBuckets);
            Integer totalRequiredBucketsInt = totalRequiredBuckets.intValue();

            System.out.println("Total Required Buckets: " + totalRequiredBucketsInt);

            scanner.close();
        } catch (Exception e) {
            if (e instanceof InputMismatchException) {
                System.out.println("Valor inválido, é nescessário ser um número");

                return;
            };

            System.out.println("Ocorreu um erro inesperado");
        }
    }
}
