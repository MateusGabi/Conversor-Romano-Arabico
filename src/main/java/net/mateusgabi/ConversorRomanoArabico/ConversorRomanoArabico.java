package net.mateusgabi.ConversorRomanoArabico;

import net.mateusgabi.ConversorRomanoArabico.Exception.ConversorRomanoArabicoForaDoLimiteDoSistemaException;

/**
 * @author Mateus Gabi Moreira <mateusgabimoreira@gmail.com>
 *         on 11/09/2017.
 */
public class ConversorRomanoArabico {

    public static boolean isArabico(String numero) {

        try {

            Integer.parseInt(numero);


        } catch (Exception ex) {

            return false;
        }

        return true;


    }

    public static void convert(int i) throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {

        if (i<=0 || i>1000){
            throw new ConversorRomanoArabicoForaDoLimiteDoSistemaException();
        }

    }
}
