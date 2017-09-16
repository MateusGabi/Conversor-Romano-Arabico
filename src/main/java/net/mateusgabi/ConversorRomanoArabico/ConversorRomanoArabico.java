package net.mateusgabi.ConversorRomanoArabico;

import net.mateusgabi.ConversorRomanoArabico.Exception.ConversorRomanoArabicoForaDoLimiteDoSistemaException;

import java.util.HashMap;
import java.util.LinkedHashMap;


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

        if (i == 1) {
            return "I";
        }

        // Pegamos o romano interior superior a string
        Character romanoSuperior = numeroRomanoPosterior(string);
        Integer arabeSuperior = getValorRomano(romanoSuperior);

        Character romanoInferior = numeroRomanoAnterior(string);
        Integer arabeInferior = getValorRomano(romanoInferior);

        if (i >= 0.90 * arabeSuperior) {

            double i_f = 0.90 * arabeSuperior;

            i = i - (int) (i_f / 1);

            // por conta da regra iii) temos que fazer uma conversão:
            if (romanoInferior == 'V') romanoInferior = 'I';
            if (romanoInferior == 'L') romanoInferior = 'X';
            if (romanoInferior == 'D') romanoInferior = 'C';


            String r = String.valueOf(romanoInferior) + String.valueOf(romanoSuperior) + converteParaRomano(String.valueOf(i));

            return r;
        }
        else {

            i = i - arabeInferior;

            return romanoInferior + converteParaRomano(String.valueOf(i));

        }
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

    /**
     * Dado um número árabe, retorna o próximo número romano inteiro.
     *
     * Exemplo: dado 230, retorna D. Dado 3, retona V.
     *
     * @param string
     * @return
     */
    public static Character numeroRomanoPosterior(String string) throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {

        return numeroRomanoProximo(string, true);

    }


    /**
     * Dado um número árabe, retorna o número romano inteiro anterior.
     *
     * Exemplo: dado 230, retorna C. Dado 3, retona I.
     *
     * @param string
     * @return
     */
    public static Character numeroRomanoAnterior(String string) throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {

        return numeroRomanoProximo(string, false);

    }

    /**
     * Método que descobre o maior e o menor número romano inteiro
     * dado um número árabe.
     *
     * @param string
     * @param isSuperior
     * @return
     * @throws ConversorRomanoArabicoForaDoLimiteDoSistemaException
     */
    private static Character numeroRomanoProximo(String string, boolean isSuperior) throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {

        if (isArabico(string)) {

            Integer i = Integer.parseInt(string);

            if (i <= 0 || i > 1000) {
                throw new ConversorRomanoArabicoForaDoLimiteDoSistemaException();
            }

            for (int j = 1, valorProximoRomano = 5; j < LETRAS_ROMANO.length; j++) {

                if (i > valorProximoRomano) {

                    // andamos pelos valores das letras. basicamente funciona assim.
                    // j representa a posicao do proximo elemento no array LETRAS_ROMANO.
                    // entao, j - 1 representa o anterior.
                    //
                    // o valor das letras andam assim:
                    // 1, 5, 10, 50, 100, 500, 1000
                    //
                    // em função de x e começando na posição 1 do array, temos:
                    // 1, x, x = x*2, x = x*5,cx = x*2, x = x*5, x = x*2
                    //
                    // para sabermos se multiplicamos por 2 ou por 5 basta saber se andamos
                    // um número par ou ímpar. Se par, multiplicamos por 5, se ímpar, por 2.
                    valorProximoRomano = (j % 2) == 0 ? valorProximoRomano * 5 : valorProximoRomano * 2;

                }
                else if (i == 1) {
                    return 'I';
                }
                else if (valorProximoRomano == i){
                    return (LETRAS_ROMANO[j]);
                }
                else {

                    if (isSuperior) {
                        return (LETRAS_ROMANO[j]);
                    }
                    else {
                        return (LETRAS_ROMANO[j - 1]);
                    }

                }

            }

        }

        return null;

    }

    private static Integer getValorRomano(Character character) {
        switch (character){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
                default: return -1;
        }
    }

    private static final Character[] LETRAS_ROMANO = new Character[] {
            'I', 'V', 'X', 'L', 'C', 'D', 'M'
    };
}
