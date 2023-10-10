import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.nhnacademy.Port;

public class TestPort extends Port {


    public TestPort(){
        super();
    }

    @Test
    void constructionTest() {
        TestPort port = new TestPort();
        

        assertNotNull(port.getId());
        assertTrue(port.getId().length() > 0);
    }
    
}
