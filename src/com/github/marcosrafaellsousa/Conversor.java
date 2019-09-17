package com.github.marcosrafaellsousa;

import javax.naming.LimitExceededException;

public class Conversor {

    // Retorna o valor de um simbolo romano ou um erro caso os valores sejam invalidos
    int value(char r) throws IllegalArgumentException {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        throw new IllegalArgumentException();
    }

    // Encontra o valor decimal de um algarismo romano
    int romanToDecimal(String str) throws LimitExceededException {
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            int s1 = value(str.charAt(i));

            if (i + 1 < str.length()) {
                int s2 = value(str.charAt(i + 1));

                if (s1 >= s2) {

                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++;
                }
            } else {
                res = res + s1;
                i++;
            }
        }

        if (res > 4999) {
            throw new LimitExceededException();
        }
        return res;
    }
}
