package net.mateusgabi.ConversorRomanoArabico.Test;

import net.mateusgabi.ConversorRomanoArabico.ConversorRomanoArabico;
import net.mateusgabi.ConversorRomanoArabico.Exception.ConversorRomanoArabicoForaDoLimiteDoSistemaException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Mateus Gabi Moreira <mateusgabimoreira@gmail.com>
 *         on 11/09/2017.
 */
public class ConversorRomanoArabicoTest {

    @Test
    public void valor_romano() {
        Assert.assertEquals("I", ConversorRomanoArabico.converte("1"));
        Assert.assertEquals("V", ConversorRomanoArabico.converte("5"));
        Assert.assertEquals("X", ConversorRomanoArabico.converte("10"));
        Assert.assertEquals("L", ConversorRomanoArabico.converte("50"));
        Assert.assertEquals("C", ConversorRomanoArabico.converte("100"));
        Assert.assertEquals("D", ConversorRomanoArabico.converte("500"));
        Assert.assertEquals("M", ConversorRomanoArabico.converte("1000"));
    }

    @Test
    public void valor_arabe() {
        Assert.assertEquals("1", ConversorRomanoArabico.converte("I"));
        Assert.assertEquals("5", ConversorRomanoArabico.converte("V"));
        Assert.assertEquals("10", ConversorRomanoArabico.converte("X"));
        Assert.assertEquals("50", ConversorRomanoArabico.converte("L"));
        Assert.assertEquals("100", ConversorRomanoArabico.converte("C"));
        Assert.assertEquals("500", ConversorRomanoArabico.converte("D"));
        Assert.assertEquals("1000", ConversorRomanoArabico.converte("M"));
    }

    @Test
    public void deve_ser_arabico() {
        Assert.assertTrue(ConversorRomanoArabico.isArabico("1"));
    }

    @Test
    public void nao_deve_ser_arabico() {
        Assert.assertFalse(ConversorRomanoArabico.isArabico("1c"));
    }

    @Test
    public void deve_ser_romano() {
        Assert.assertTrue(ConversorRomanoArabico.isRomano("CMIII"));
    }

    @Test
    public void nao_deve_ser_romano___RegraIa() {
        Assert.assertFalse(ConversorRomanoArabico.isRomano("xvi"));
    }

    @Test
    public void nao_deve_ser_romano___RegraIb() {
        Assert.assertFalse(ConversorRomanoArabico.isRomano("XIEIV"));
    }

    @Test
    public void nao_deve_ser_romano___RegraIII() {
        Assert.assertFalse(ConversorRomanoArabico.isRomano("ICV"));
    }

    @Test
    public void nao_deve_ser_romano___RegraIV1() {
        Assert.assertFalse(ConversorRomanoArabico.isRomano("IIII"));
    }

    @Test
    public void nao_deve_ser_romano___RegraIV2() {
        Assert.assertFalse(ConversorRomanoArabico.isRomano("MMMMCCCCIII"));
    }

    @Test
    public void nao_deve_ser_romano___RegraIV3() {
        Assert.assertFalse(ConversorRomanoArabico.isRomano("MMMCCCCIII"));
    }

    @Test
    public void nao_deve_ser_romano___RegraIV4() {
        Assert.assertFalse(ConversorRomanoArabico.isRomano("MMMMM"));
    }

    @Test
    public void nao_deve_ser_romano___RegraIV5() {
        Assert.assertTrue(ConversorRomanoArabico.isRomano("XXXI"));
    }

    @Test
    public void nao_deve_ser_romano___RegraV1() {
        Assert.assertFalse(ConversorRomanoArabico.isRomano("VV"));
    }

    @Test
    public void nao_deve_ser_romano___RegraV2() {
        Assert.assertFalse(ConversorRomanoArabico.isRomano("LL"));
    }


    @Test
    public void nao_deve_ser_romano___RegraV3() {
        Assert.assertFalse(ConversorRomanoArabico.isRomano("DD"));
    }

    @Test
    public void limite_inferior_atingido() {
        Assert.assertNull(ConversorRomanoArabico.converte("-10"));
    }

    @Test
    public void limite_inferior() {
        Assert.assertNull(ConversorRomanoArabico.converte("-1"));
        Assert.assertNull(ConversorRomanoArabico.converte("-2"));
        Assert.assertNull(ConversorRomanoArabico.converte("0"));
        Assert.assertEquals("I", ConversorRomanoArabico.converte("1"));
        Assert.assertEquals("II", ConversorRomanoArabico.converte("2"));
    }

    @Test
    public void limite_superior() {
        Assert.assertEquals("M", ConversorRomanoArabico.converte("1000"));
        Assert.assertNull(ConversorRomanoArabico.converte("1001"));
        Assert.assertNull(ConversorRomanoArabico.converte("1002"));
    }

    @Test
    public void converte_arabe_romano() {
        Assert.assertEquals("1", ConversorRomanoArabico.converte("I"));
    }

    @Test
    public void converte_romano_arabe() {
        Assert.assertEquals("I", ConversorRomanoArabico.converte("1"));
    }

    @Test
    public void converte_romano_arabe_() {
        Assert.assertNull(ConversorRomanoArabico.converte("1www"));
    }

    @Test
    public void deve_retornar_maior_numeros_romano_sequente() {
        Assert.assertEquals(new Character('D'), ConversorRomanoArabico.numeroRomanoPosterior("230"));
    }

    @Test
    public void deve_retornar_maior_numeros_romano_sequente1() {
        Assert.assertEquals(new Character('V'), ConversorRomanoArabico.numeroRomanoPosterior("3"));
    }

    @Test
    public void deve_retornar_maior_numeros_romano_limite_inferior1() {
        Assert.assertEquals(new Character('I'), ConversorRomanoArabico.numeroRomanoPosterior("1"));
    }

    @Test
    public void deve_retornar_menor_numero_romano_limite_intferior1() {
        Assert.assertEquals(new Character('I'), ConversorRomanoArabico.numeroRomanoAnterior("3"));
    }

    @Test
    public void deve_retornar_menor_numero_romano_limite_intferior2()  {
        Assert.assertEquals(new Character('I'), ConversorRomanoArabico.numeroRomanoAnterior("1"));
    }

    @Test
    public void deve_retornar_menor_numero_romano_limite_superior() {
        Assert.assertEquals(new Character('M'), ConversorRomanoArabico.numeroRomanoAnterior("1000"));
    }

    @Test
    public void deve_retornar_menor_numero_romano_limite_superior1() {
        Assert.assertEquals(new Character('D'), ConversorRomanoArabico.numeroRomanoAnterior("999"));
    }

    @Test
    public void deve_converte_para_romano() {
        Assert.assertEquals("DCCLXXXVIII", ConversorRomanoArabico.converte("788"));
    }

    @Test
    public void deve_converte_para_romano1() {
        Assert.assertEquals("CMIII", ConversorRomanoArabico.converte("903"));
    }

    @Test
    public void deve_converte_para_romano2() {
        Assert.assertEquals("CCXLVI", ConversorRomanoArabico.converte("246"));
    }

    @Test
    public void deve_converte_para_arabe1() {
        Assert.assertEquals("903", ConversorRomanoArabico.converte("CMIII"));
    }

    @Test
    public void deve_converte_para_arabe() {
        Assert.assertEquals("902", ConversorRomanoArabico.converte("CMII"));
    }

    @Test
    public void deve_converte_para_arabe3() {
        Assert.assertEquals("901", ConversorRomanoArabico.converte("CMI"));
    }

    @Test
    public void deve_converte_para_arabe4() {
        Assert.assertEquals("900", ConversorRomanoArabico.converte("CM"));
    }

    @Test
    public void deve_converte_para_arabe5() {
        Assert.assertEquals("100", ConversorRomanoArabico.converte("C"));
    }

    @Test
    public void nao_deve_converte() {
        Assert.assertNull(ConversorRomanoArabico.converte("-100"));
    }

    @Test
    public void nao_deve_converte1() {
        Assert.assertNull(ConversorRomanoArabico.converte("Y"));
    }


    @Test
    public void numeros_aleatorios() {
        Assert.assertEquals("LXXIV", ConversorRomanoArabico.converte("74"));
        Assert.assertEquals("XXV", ConversorRomanoArabico.converte("25"));
        Assert.assertEquals("CCCLXXIX", ConversorRomanoArabico.converte("379"));
        Assert.assertEquals("CCCXIX", ConversorRomanoArabico.converte("319"));
        Assert.assertEquals("DCCCLX", ConversorRomanoArabico.converte("860"));
        Assert.assertEquals("CCXLII", ConversorRomanoArabico.converte("242"));
        Assert.assertEquals("XXXVII", ConversorRomanoArabico.converte("37"));
        Assert.assertEquals("XXXVIII", ConversorRomanoArabico.converte("38"));
        Assert.assertEquals("XXXIX", ConversorRomanoArabico.converte("39"));
        Assert.assertEquals("XL", ConversorRomanoArabico.converte("40"));
        Assert.assertEquals("XLVIII", ConversorRomanoArabico.converte("48"));
        Assert.assertEquals("XLIX", ConversorRomanoArabico.converte("49"));
        Assert.assertEquals("L", ConversorRomanoArabico.converte("50"));
        Assert.assertEquals("LI", ConversorRomanoArabico.converte("51"));
        Assert.assertEquals("LII", ConversorRomanoArabico.converte("52"));
        Assert.assertEquals("LIII", ConversorRomanoArabico.converte("53"));
        Assert.assertEquals("LIV", ConversorRomanoArabico.converte("54"));
        Assert.assertEquals("CCCLXXXVIII", ConversorRomanoArabico.converte("388"));
    }

    @Test
    public void verificaProximaLetra() {
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("II"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("IV"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("IX"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("VI"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("XI"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("XV"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("XX"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("XL"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("LI"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("LV"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("LX"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("CI"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("CV"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("CX"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("CL"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("CC"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("CM"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("DI"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("DX"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("DV"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("DL"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("DC"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("MI"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("MX"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("MV"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("ML"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("MC"));
        Assert.assertTrue(ConversorRomanoArabico.verificaProximaLetra("MM"));
    }

    @Test
    public void numeroRomanoProximo() {
        Assert.assertEquals(new Character('C'), ConversorRomanoArabico.numeroRomanoProximo("100", true));
    }

}
