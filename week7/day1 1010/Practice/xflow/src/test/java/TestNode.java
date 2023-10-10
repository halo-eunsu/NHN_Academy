import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil.Test;
import com.nhnacademy.Node;;


public class TestNode extends Node {
    
    public TestNode() {
        super();
    }

    public TestNode(String id){
        super(id);
    }

    @Test
    public void constructionTest() {
        TestNode node = new TestNode();

        
        assertTrue(node.getId().length() > 0 );
    }
 }
