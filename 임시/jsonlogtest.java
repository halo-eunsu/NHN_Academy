import com.nhnacademy.node.FunctionNode;
import com.nhnacademy.node.JsonTest2;
import com.nhnacademy.node.MqttInNode;
import com.nhnacademy.node.MqttOutNode;
import com.nhnacademy.wire.Wire;

public class jsonlogtest {
    

    public static void main(String[] args) {
        MqttInNode mqttInNode = new MqttInNode();
        FunctionNode functionNode = new FunctionNode(1, 1);
        JsonTest2 jsonNode = new JsonTest2("jsonNode", 1, 2);
        MqttOutNode mqttOutNode = new MqttOutNode("mqttOutNode", 2, "tcp://localhost");
        Wire inTofun = new Wire();
        Wire funToout = new Wire();
        Wire jsonWire = new Wire();
        mqttInNode.connectOutputWire(0, inTofun);
        functionNode.connectInputWire(0, inTofun);
        functionNode.connectOutputWire(0, funToout);
        jsonNode.connectInputWire(0, funToout);
        jsonNode.connectOutputWire(0, jsonWire);
        mqttOutNode.connectInputWire(0, jsonWire);
        mqttInNode.start();
        functionNode.start();
        jsonNode.start();
        mqttOutNode.start();
    }
}
