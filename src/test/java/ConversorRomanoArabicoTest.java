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

    @Test(expected=ConversorRomanoArabicoForaDoLimiteDoSistemaException.class)
    public void limite_inferior_atingido() throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {
        ConversorRomanoArabico.convert(-10);
    }

    @Test(expected=ConversorRomanoArabicoForaDoLimiteDoSistemaException.class)
    public void limite_superior_atingido() throws ConversorRomanoArabicoForaDoLimiteDoSistemaException {
        ConversorRomanoArabico.convert(1001);
    }

}
