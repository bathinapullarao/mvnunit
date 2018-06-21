
import junit.BaseTest;
import caluation.Calcul;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

/**
 * 测试类
 */
public class CalculTest extends BaseTest {

    @Resource
    private Calcul calcul;

    @Before
    public void init() {
        //在运行测试之前的业务代码
    }
    @After
    public void after() {
        //在测试完成之后的业务代码
    }

    @Test
    public void testHello(){
        String str1="Hello6 9World 2, Nic8e D7ay!";
        assertEquals(2,calcul.NumberSearch(str1));

        String str2="hello44444 world";
        assertEquals(-1,calcul.NumberSearch(str2));

        String str3="H3ello9-9";
        assertEquals(4,calcul.NumberSearch(str3));

        String str4="One Number*1*";
        assertEquals(0,calcul.NumberSearch(str4));

        String str5="1@#$%^&";
        assertEquals(-1,calcul.NumberSearch(str5));

        String str6="";
        assertEquals(-1,calcul.NumberSearch(str6));
    }

}
