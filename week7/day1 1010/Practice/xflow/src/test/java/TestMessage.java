import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.nhnacademy.Message;

public class TestMessage extends Message{
    



    
    @Test
    void constructionTest(){
            
        TestMessage message = new TestMessage();

        assertNotNull(message.getId());
        assertTrue(message.getId().length());

    }
}
