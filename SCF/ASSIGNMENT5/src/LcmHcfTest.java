import static org.junit.Assert.*;
import org.junit.Test;

public class LcmHcfTest {

    //H.C.F positive test
	lcmHcf obj = new lcmHcf();
    @Test
	public void testHcf() 
    {
    	int result = obj.findHcf(54,24);
    	assertEquals(6, result);
    }
    @Test
	public void testHcfWithZeroSecond() 
    {
    	int result = obj.findHcf(54,0);
    	assertEquals(54, result);
    }
    @Test
   	public void testHcfWithZeroFirst() 
    {
       	int result = obj.findHcf(0,24);
       	assertEquals(24, result);
    }

    //H.C.F negative test
    @Test
   	public void negativeTestHcf() 
    {
       	int result = obj.findHcf(54,24);
       	assertEquals(7, result);
    }

    //L.C.M positive test
    @Test
    public void testLcm()
    {
    	int result = obj.findLcm(54, 24);
    	assertEquals(216, result);
    }
    @Test
    public void testLcmWithZeroFirst()
    {
    	int result = obj.findLcm(0, 24);
    	assertEquals(0, result);
    }
    @Test
    public void testLcmWithZeroSecond()
    {
    	int result = obj.findLcm(54, 0);
    	assertEquals(0, result);
    }

    //L.C.M negative test 
    @Test
    public void negativeTestLcm()
    {
    	int result = obj.findLcm(54, 24);
    	assertEquals(200, result);
    }
}
