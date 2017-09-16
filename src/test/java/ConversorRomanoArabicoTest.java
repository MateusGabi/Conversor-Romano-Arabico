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
    public void limite_superior_atingido() {
        Assert.assertNull(ConversorRomanoArabico.converte("1001"));
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
    public void deve_retornar_maior_numeros_romano_sequente() throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {
        Assert.assertEquals(new Character('D'), ConversorRomanoArabico.numeroRomanoPosterior("230"));
    }

    @Test
    public void deve_retornar_maior_numeros_romano_sequente1() throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {
        Assert.assertEquals(new Character('V'), ConversorRomanoArabico.numeroRomanoPosterior("3"));
    }

    @Test(expected=ConversorRomanoArabicoForaDoLimiteDoSistemaException.class)
    public void deve_retornar_maior_numeros_romano_limite_inferior() throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {
        ConversorRomanoArabico.numeroRomanoPosterior("-1");
    }

    @Test
    public void deve_retornar_maior_numeros_romano_limite_inferior1() throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {
        Assert.assertEquals(new Character('I'), ConversorRomanoArabico.numeroRomanoPosterior("1"));
    }

    @Test(expected=ConversorRomanoArabicoForaDoLimiteDoSistemaException.class)
    public void deve_retornar_maior_numeros_romano_limite_superior() throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {
        ConversorRomanoArabico.numeroRomanoPosterior("1001");
    }

    @Test
    public void deve_retornar_maior_numeros_romano_limite_superior1() throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {
        Assert.assertEquals(new Character('M'), ConversorRomanoArabico.numeroRomanoPosterior("1000"));
    }

    @Test(expected = ConversorRomanoArabicoForaDoLimiteDoSistemaException.class)
    public void deve_retornar_menor_numero_romano_limite_inferior() throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {
        ConversorRomanoArabico.numeroRomanoAnterior("0");
    }

    @Test
    public void deve_retornar_menor_numero_romano_limite_intferior1() throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {
        Assert.assertEquals(new Character('I'), ConversorRomanoArabico.numeroRomanoAnterior("3"));
    }

    @Test
    public void deve_retornar_menor_numero_romano_limite_intferior2() throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {
        Assert.assertEquals(new Character('I'), ConversorRomanoArabico.numeroRomanoAnterior("1"));
    }

    @Test
    public void deve_retornar_menor_numero_romano_limite_superior() throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {
        Assert.assertEquals(new Character('M'), ConversorRomanoArabico.numeroRomanoAnterior("1000"));
    }

    @Test
    public void deve_retornar_menor_numero_romano_limite_superior1() throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {
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


}
