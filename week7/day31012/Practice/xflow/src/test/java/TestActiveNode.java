import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.nhnacademy.ActiveNode;
import com.nhnacademy.Node;

public class TestActiveNode extends ActiveNode {


    @Override
    public void main() {


    }



    public TestActiveNode() {
        super();
    }

    @Test
    void constructionTest() {
        TestActiveNode node = new TestActiveNode();

        assertTrue(node instanceof Node);
        assertTrue(node instanceof ActiveNode);
        assertFalse(node.isAlive());


        assertEquals(0, node.getLoopCount);


        node.start();

        Thread.sleep(2000);
        assertTrue(node.isAlive());
        assertEquals("main", node.getStatus());
        Thread.sleep(2000);
        node.stop();



    }



}
