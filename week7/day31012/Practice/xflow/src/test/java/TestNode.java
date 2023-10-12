
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.nhnacademy.Node;


public class TestNode extends Node {

    public TestNode() {
        super();
    }

    // public TestNode(String id){
    // super(id);
    // }

    @Test
    public void constructionTest() {
        TestNode node = new TestNode();

        assertNotNull(node.getId() != null);
        assertTrue(node.getId().length() > 0);



        // node 개수를 하나하나 찾아가면서 일일히 비교
        List<TestNode> nodeList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            nodeList.add(new TestNode());
        }

        // 총 node 갯수
        System.out.println("Node Count : " + Node.getTotalCount());

        for (int i = 0; i < 10; i++) {
            TestNode node1 = nodeList.get(i);
            for (int j = i + 1; j < 10; j++) {
                if (node1.getId().equals(nodeList.get(j).getId())) {
                    System.out.println();
                    assertTrue(false);
                }
            }
        }



    }

    @Test
        void nameTest() {
            final String name = "first node.";

            StringBuilder builder = new StringBuilder();

            TestNode node = new TestNode();
            builder.append(name);// builder의 Test 방법 질문
            
            node.setName((name));
            assertEquals(name, node.getName());
            assertEquals(builder.toString(), node.getName());
        }

}
