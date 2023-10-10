
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.nhnacademy.Node;


public class TestNode extends Node {
    
    public TestNode() {
        super();
    }

    // public TestNode(String id){
    //     super(id);
    // }

    @Test
    public void constructionTest() {
        TestNode node = new TestNode();

        assertNotNull(node.getId() != null);
        assertTrue(node.getId().length() > 0 );
    }
 }
