

import java.util.List;
import java.util.ArrayList;

interface Map<T>{
    int apply(T element);
}

class CollectionUtils<T> { 
    public Iterable<T> changeElements(Map map, Iterable<T> iterable){

        List<T> result = new ArrayList<>();

        for(T t : iterable) { 
            result.add(map.apply(t), t);
        }
        

        return iterable;

    }
}




public class TestList {
    List <Integer> list = new ArrayList<>();
}
