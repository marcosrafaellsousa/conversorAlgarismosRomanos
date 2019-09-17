package com.github.marcosrafaellsousa;

import javax.naming.LimitExceededException;

public class Conversor {

    // Retorna o valor de um simbolo romano ou um erro caso os valores sejam invalidos
    int encontrarValorDeAlgarismo(char algarismo) throws IllegalArgumentException {
        if (algarismo == 'I')
            return 1;
        if (algarismo == 'V')
            return 5;
        if (algarismo == 'X')
            return 10;
        if (algarismo == 'L')
            return 50;
        if (algarismo == 'C')
            return 100;
        if (algarismo == 'D')
            return 500;
        if (algarismo == 'M')
            return 1000;
        throw new IllegalArgumentException();
    }

    /* Encontra o valor decimal de um numero escrito em algarismos romanos ou retorna um erro caso exceda 4999 (limite
    estabelecido pelo professor */
    int romanoParaDecimal(String numeroEmRomano) throws LimitExceededException {
        int resultado = 0;

        for (int i = 0; i < numeroEmRomano.length(); i++) {
            int s1 = encontrarValorDeAlgarismo(numeroEmRomano.charAt(i));

            if (i + 1 < numeroEmRomano.length()) {
                int s2 = encontrarValorDeAlgarismo(numeroEmRomano.charAt(i + 1));

                if (s1 >= s2) {

                    resultado = resultado + s1;
                } else {
                    resultado = resultado + s2 - s1;
                    i++;
                }
            } else {
                resultado = resultado + s1;
                i++;
            }
        }

        if (resultado > 4999) {
            throw new LimitExceededException();
        }
        return resultado;
    }
}
