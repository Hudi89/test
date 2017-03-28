import static org.junit.Assert.*;
import org.junit.Test;

import org.eit.*;

public class FirstTests {

    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        assertEquals("HelloWorld::asd() must be 12",12, Main.asd());
    }
    
    @Test 
    public void testHelperMultiplyFunction(){
        assertEquals("Helper::multiplyTwoNumber",10,Helper.multiplyTwoNumber(5,2));
        assertEquals("Helper::multiplyTwoNumber",12,Helper.multiplyTwoNumber(6,2));
        assertEquals("Helper::multiplyTwoNumber",0,Helper.multiplyTwoNumber(0,2));
        assertEquals("Helper::multiplyTwoNumber",0,Helper.multiplyTwoNumber(2,0));
        assertEquals("Helper::multiplyTwoNumber",2,Helper.multiplyTwoNumber(1,2));
    }
}
