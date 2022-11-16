import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class StrFunctions {
    public ArrayList<String> findItemsWithSubstring(ArrayList<String> list, String substring){
        ArrayList<String> foundItems = new ArrayList<>();
        for (String item : list) {
            if(item.contains(substring)){
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public ArrayList<String> initializeListFromTextFile(String pathToTextFile){
        var fileLinesList = new ArrayList<String>();
        try(var fileReader = new BufferedReader(new FileReader(pathToTextFile))){
            String line = fileReader.readLine();
            while(line != null){
                fileLinesList.add(line);
                line = fileReader.readLine();
            }
        }catch (FileNotFoundException e) {
            System.out.println("File wasn't found.");
        } catch (IOException e) {
            System.out.println("IOException");
        }
        printList(fileLinesList);
        return fileLinesList;
    }

    public void printList(ArrayList<String> collection){
        if(collection.size() == 0){
            System.out.println("Collection is empty.");
        } else {
            System.out.println("Collection items:");
            for(var item : collection){
                System.out.println(item);
            }
        }
    }

    public boolean compareInnerObjects(ArrayList<String> list, int firstItemIndex, int secondItemIndex){
//        if(firstObjectIndex < 0 || secondObjectIndex < 0){
//            return false;
//        }
        String firstItem = list.get(firstItemIndex).trim();
        String secondItem = list.get(secondItemIndex).trim();
        return firstItem.equals(secondItem);
    }

    public ArrayList<Integer> itemLengthList(ArrayList<String> list){
        var itemLengthList = new ArrayList<Integer>();
        for(var item : list){
            itemLengthList.add(item.length());
        }
        Collections.sort(itemLengthList);
        return itemLengthList;
    }

    public ArrayList<String> addItemStatic(ArrayList<String> list, String itemToAdd, int maxsize){
        //если
        if(maxsize < 0){
            //throw new InvalidCollectionSizeException();
            return list;
        }
        while(list.size() >= maxsize){
            list.remove(0);
        }
        list.add(itemToAdd);
        return list;
    }
}
