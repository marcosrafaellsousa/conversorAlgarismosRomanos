package com.github.marcosrafaellsousa;

import javax.naming.LimitExceededException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o numero em algarismo romano");
        String numeroEmRomano = scanner.nextLine();
        numeroEmRomano = numeroEmRomano.toUpperCase();
        Conversor conversor = new Conversor();

        // Verifica se os algarismos sao validos
        try {
            System.out.println("O valor inteiro dos algarismos digitados e: " + conversor.romanoParaDecimal(numeroEmRomano));
        } catch (IllegalArgumentException e) {
            System.out.println("Algarismos invalidos");
        } catch (LimitExceededException e) {
            System.out.println("O limite de 4999 foi excedido");
        }
    }
}
