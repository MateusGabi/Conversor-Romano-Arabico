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
        Assert.assertTrue(ConversorRomanoArabico.isRomano("XVI"));
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
}
