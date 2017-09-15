package net.mateusgabi.ConversorRomanoArabico;

import net.mateusgabi.ConversorRomanoArabico.Exception.ConversorRomanoArabicoForaDoLimiteDoSistemaException;

/**
 * @author Mateus Gabi Moreira <mateusgabimoreira@gmail.com>
 *         on 11/09/2017.
 */
public class ConversorRomanoArabico {

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
     *
     * Para se detectar se um número é romano ou não, tem que
     * se saber quais são as regras dos números romanos.
     *
     * i) A numeração romana utiliza sete letras maiúsculas,
     * que correspondem aos seguintes valores:
     *
     * I	=> 1
     * V	=> 5
     * X	=> 10
     * L	=> 50
     * C	=> 100
     * D	=> 500
     * M	=> 1000
     *
     * ii) Se à direita de uma cifra romana se escreve outra
     * igual ou menor, o valor desta se soma ao valor da
     * anterior.
     *
     * iii) A letra "I" colocada diante da "V" ou de "X", subtrai
     * uma unidade; a letra "X", precedendo a letra "L" ou a "C",
     * lhes subtrai dez unidades e a letra "C", diante da "D" ou
     * da "M", lhes subtrai cem unidades.
     *
     * iv) Em nenhum número se pode pôr uma mesma letra mais de
     * três vezes seguidas.
     *
     * v) A letra "V", "L" e a "D" não podem se duplicar porque
     * outras letras ("X", "C", "M") representam seu valor duplicado.
     *
     * vi) Se entre duas cifras quaisquer existe outra menor, o valor
     * desta pertencerá a letra seguinte a ela.
     *
     * @param string
     * @return
     */
    public static boolean isRomano(String string) {


        return ConversorRomanoArabico.verificaLetras(string);
    }

    /**
     * Verifica regra i.
     *
     * @param string
     * @return
     */
    private static boolean verificaLetras(String string) {
        for (char c: string.toCharArray()) {
            switch (c) {
                case 'I':
                case 'V':
                case 'X':
                case 'L':
                case 'C':
                case 'D':
                case 'M':
                    break;
                default:
                    return false;
            }
        }

        return true;
    }

    /**
     * Identifica se é um número romano ou arábico e o converte.
     * Isto é, se for romano, converte para arábico. Se for arábico,
     * converte para romano. Se não for nada, dispara exceção.
     *
     * @param i
     * @throws ConversorRomanoArabicoForaDoLimiteDoSistemaException
     */
    public static void convert(int i) throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {

        if (i<=0 || i>1000){
            throw new ConversorRomanoArabicoForaDoLimiteDoSistemaException();
        }

    }
}
