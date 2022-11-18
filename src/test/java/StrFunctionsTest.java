import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class StrFunctionsTest {

    private ArrayList<String> list;
    private StrFunctions strFunctions = new StrFunctions();

    @BeforeEach
    void initEach(){
        list = new ArrayList<String>();
        list.add("One");
        list.add("application");
        list.add("cat");
        list.add("dog");
        list.add("frog");
        list.add("cat");
        list.add("do");
    }
    @Test
    public void add(){
        String str = "Hello";
        assertTrue(strFunctions.add(list, str));
    }

    @Test
    public void remove(){
        assertEquals("One", strFunctions.remove(list, "One"));
    }

    @Test
    public void findEqual(){
        strFunctions.add(list, "cat");
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

    @Test
    void findItemsWithSubstring() {
        String substring = "cat";
        ArrayList<String> actual = strFunctions.findItemsWithSubstring(list, substring);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("cat");
        expected.add("cat");
        expected.add("application");

        checkIfListContentEquals(actual, expected);
    }

    @Test
    void findItemsWithNullSubstring() {
        String substring = null;
        ArrayList<String> actual = strFunctions.findItemsWithSubstring(list, substring);

        ArrayList<String> expected = new ArrayList<>();

        checkIfListContentEquals(actual, expected);
    }

    @Test
    void initializeListFromTextFile() {
        String pathToTextFile = "src/main/resources/textfile.txt";

        ArrayList<String> expected = new ArrayList<>();
        expected.add("Dolphins");
        expected.add("marine mammals");
        expected.add("whales");
        expected.add("name");

        ArrayList<String> actual = strFunctions.initializeListFromTextFile(pathToTextFile);

        checkIfListContentEquals(actual, expected);
    }

    @Test
    void compareInnerObjects() {
        int firstItemIndex = 2;
        int secondItemIndex = 5;

        boolean isEqual = strFunctions.compareInnerObjects(list, firstItemIndex, secondItemIndex);

        Assertions.assertTrue(isEqual);
    }

    @Test
    void printSortedByStringLengthList() {
        ArrayList<String> actual = strFunctions.printSortedByStringLengthList(list);
        assertEquals("do",actual.get(0));
    }

    @Test
    void addItemStatic() {
        int maxsize = 5;
        String itemToAdd = "dolphin";
        ArrayList<String> actual = strFunctions.addItemStatic(list,itemToAdd, maxsize);

        ArrayList<String> expected = new ArrayList<>(Arrays.asList(new String[]{"cat","dog","frog", "cat", itemToAdd}));

        checkIfListContentEquals(actual, expected);
    }

    private void checkIfListContentEquals(ArrayList<String> actual, ArrayList<String> expected){
        if(expected.size() == actual.size()){
            for(var item : expected){
                if(!actual.contains(item)){
                    Assertions.fail();
                }
            }
        } else {
            Assertions.fail();
        }
    }

}








