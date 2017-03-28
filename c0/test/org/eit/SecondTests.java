import static org.junit.Assert.*;
import org.junit.Test;

import org.eit.*;

public class SecondTests {

    @Test
    public void testCounterClass() {
    
        Counter counter = new Counter();
        counter.increment();
        counter.increment();
        counter.increment();
        assertEquals("after 3 increment it has to be 3:)",3, counter.getCounter());
        counter.decrement();
        assertEquals("...",2, counter.getCounter());
        
        assertEquals("...",3, counter.increment());
        assertEquals("...",2, counter.decrement());
        counter.increment();
        counter.increment();
        assertEquals("...",4, counter.getCounter());
    }
}
