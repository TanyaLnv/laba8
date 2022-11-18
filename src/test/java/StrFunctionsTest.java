import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.Arrays;

class StrFunctionsTest {
    private ArrayList<String> list;
    private StrFunctions strFunctions = new StrFunctions();

    @BeforeEach
    void initEach(){
        list = new ArrayList<String>();
        list.add("application");
        list.add("cat");
        list.add("dog");
        list.add("frog");
        list.add("cat");
    }

    @Test
    void findItemsWithSubstring() {
        String substring = "cat";
        ArrayList<String> actual = strFunctions.findItemsWithSubstring(list, substring);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("cat");
        expected.add("cat");
        expected.add("application");

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
        int firstItemIndex = 1;
        int secondItemIndex = 4;

        boolean isEqual = strFunctions.compareInnerObjects(list, firstItemIndex, secondItemIndex);

        Assertions.assertTrue(isEqual);
    }

    @Test
    void printSortedByStringLengthList() {

        ArrayList<String> actual = strFunctions.printSortedByStringLengthList(list);


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