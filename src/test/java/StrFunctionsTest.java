import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class StrFunctionsTest {

    ArrayList<String> list = new ArrayList(Arrays.asList("One", "Two", "Three"));
    StrFunctions strFunctions = new StrFunctions();

    @Test
    public void add(){
        String str = "Hello";
        assertTrue(strFunctions.add(list, str));
    }

    @Test
    public void remove(){
        assertEquals("Пусто", strFunctions.remove(list, "Nice"));
    }

    @Test
    public void findEqual(){
        strFunctions.add(list, "Two");
        assertTrue(strFunctions.findEqual(list));
    }

    @Test
    public void toXML(){
        assertTrue(strFunctions.toXML(list));
    }

    @Test
    public void reverse(){
        strFunctions.reverse(list);
        assertEquals("enO",list.get(0));
    }

    @Test
    public void  statistics(){
        HashMap<Character, Integer> hm = strFunctions.statistics(list);
        assertTrue(hm.containsKey('O'));
        assertTrue(hm.containsValue(3));
    }

}
