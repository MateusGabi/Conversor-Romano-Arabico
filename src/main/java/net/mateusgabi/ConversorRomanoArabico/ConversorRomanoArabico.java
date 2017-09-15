package net.mateusgabi.ConversorRomanoArabico;

import net.mateusgabi.ConversorRomanoArabico.Exception.ConversorRomanoArabicoForaDoLimiteDoSistemaException;


/**
 * @author Mateus Gabi Moreira <mateusgabimoreira@gmail.com>
 *         on 11/09/2017.
 */
public class ConversorRomanoArabico {

    /**
     * Método Principal responsável por detectar e realizar Conversão
     *
     * @param string
     */
    public static String converte(String string) {

        if (isRomano(string)) {
            return converteParaArabico(string);
        }
        else if (isArabico(string)) {
            try {
                return converteParaRomano(string);
            } catch (ConversorRomanoArabicoForaDoLimiteDoSistemaException e) {
                return null;
            }
        }

        return null;

    }

    /**
     * Recebe um número em arábico, converte para romano e retorna.
     *
     * @param string
     * @return
     */
    private static String converteParaRomano(String string) throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {

        int i = Integer.parseInt(string);

        if (i <= 0 || i > 1000) {
            throw new ConversorRomanoArabicoForaDoLimiteDoSistemaException();
        }

        return "I";
    }

    /**
     * Recebe um número em romano, converte para arabico e retorna.
     *
     * @param string
     * @return
     */
    private static String converteParaArabico(String string) {
        return "1";
    }

    /**
     * Detecta se a string informada é um número arábico válido.
     *
     * @param numero
     * @return
     */
    public static boolean isArabico(String numero) {

        try {

            Integer.parseInt(numero);


        } catch (Exception ex) {

            return false;
        }

        return true;


    }

    /**
     * Detecta se a string informada é um número romano válido.
     * <p>
     * Para se detectar se um número é romano ou não, tem que
     * se saber quais são as regras dos números romanos.
     * <p>
     * i) A numeração romana utiliza sete letras maiúsculas,
     * que correspondem aos seguintes valores:
     * <p>
     * I	=> 1
     * V	=> 5
     * X	=> 10
     * L	=> 50
     * C	=> 100
     * D	=> 500
     * M	=> 1000
     * <p>
     * ii) Se à direita de uma cifra romana se escreve outra
     * igual ou menor, o valor desta se soma ao valor da
     * anterior.
     * <p>
     * iii) A letra "I" colocada diante da "V" ou de "X", subtrai
     * uma unidade; a letra "X", precedendo a letra "L" ou a "C",
     * lhes subtrai dez unidades e a letra "C", diante da "D" ou
     * da "M", lhes subtrai cem unidades.
     * <p>
     * iv) Em nenhum número se pode pôr uma mesma letra mais de
     * três vezes seguidas.
     * <p>
     * v) A letra "V", "L" e a "D" não podem se duplicar porque
     * outras letras ("X", "C", "M") representam seu valor duplicado.
     * <p>
     * vi) Se entre duas cifras quaisquer existe outra menor, o valor
     * desta pertencerá a letra seguinte a ela.
     *
     * @param string
     * @return
     */
    public static boolean isRomano(String string) {

        return ConversorRomanoArabico.verificaLetras(string) &&
                ConversorRomanoArabico.verificaProximaLetra(string) &&
                ConversorRomanoArabico.verificaLetrasComMaisDeTresSeguidas(string);
    }

    /**
     * Verifica regra IV: se uma letra se repete mais de três vezes.
     *
     * @return
     */
    private static boolean verificaLetrasComMaisDeTresSeguidas(String string) {
        if (string.length() <= 3) {
            return true;
        }

        for (int i = 0; i < string.length(); i++) {
            for (int j = i + 1; j < string.length(); j++) {

                if (string.charAt(i) == string.charAt(j)) {

                    if ((j - i) == 3) {
                        return false;
                    }
                } else {
                    break;
                }
            }
        }

        return true;
    }

    /**
     * Verifica Regra III e V. Se a letra a direita é uma letra válida
     * dado a letra atual. E a letra "V", "L" e a "D" não podem se
     * duplicar porque outras letras ("X", "C", "M") representam seu valor duplicado.
     *
     * @param string
     * @return
     */
    private static boolean verificaProximaLetra(String string) {

        boolean valido = true;

        // VERIFICA SE NÚMERO A DIREITA É VÁLIDO
        for (int i = 0; i < string.length() - 1; i++) {

            char letra = string.charAt(i);
            char proximaLetra = string.charAt(i+1);

            //
            // abaixo sempre usamos esse inArray para indicar que.
            // a letra do caso só vai ficar à esquerda dessas letras.
            // Exemplo:
            //
            // a letra 'I' vai ficar à esquerda das letras I, V e X
            //

            switch (letra) {
                case 'I':
                    valido = inArray(proximaLetra, new Character[] {
                            'I', 'V', 'X'
                    });
                    break;
                case 'V':
                    valido = inArray(proximaLetra, new Character[] {
                            'I'
                    });
                    break;
                case 'X':
                    valido = inArray(proximaLetra, new Character[] {
                            'I', 'V', 'X', 'L'
                    });
                    break;
                case 'L':
                    valido = inArray(proximaLetra, new Character[] {
                            'I', 'V', 'X'
                    });
                    break;
                case 'C':
                    valido = inArray(proximaLetra, new Character[] {
                            'I', 'V', 'X', 'L', 'C'
                    });
                    break;
                case 'D':
                    valido = inArray(proximaLetra, new Character[] {
                            'I', 'X', 'V', 'L', 'C'
                    });
                    break;
                case 'M':
                    valido = inArray(proximaLetra, new Character[] {
                            'I', 'X', 'V', 'L', 'C', 'M'
                    });
                    break;
                default:
                    return false;
            }

            if (!valido) return false;


        }

        return true;
    }

    /**
     * Verifica se um Caracter esta em um array de caracter. Essa função é muito útil!
     *
     * @param c
     * @param characters
     * @return
     */
    private static boolean inArray(Character c, Character[] characters) {

        for (Character character: characters) {
            if (c.equals(character)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Verifica regra i.
     *
     * @param string
     * @return
     */
    private static boolean verificaLetras(String string) {

        for (char c: string.toCharArray()) {
            if (!inArray(c, LETRAS_ROMANO)) {
                return false;
            }
        }


        return true;
    }

    private static final Character[] LETRAS_ROMANO = new Character[] {
       'I', 'V', 'X', 'L', 'C', 'D', 'M'
    };

}
