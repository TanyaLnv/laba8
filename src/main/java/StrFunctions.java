import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class StrFunctions {
    Scanner scan = new Scanner(System.in);
     int a;
    public boolean add(ArrayList<String> list, String str){
        if(list.add(str)){
        return true;}
        else{ return false;}
    }

    public String remove(ArrayList<String> list, String str)
    {
        if(list.isEmpty()){
            System.out.println("Пусто");
            return "Пусто";
        }else {
            if(list.remove(str)){
                System.out.println("Объект успешно удален");
            }
            else{
                System.out.println("Такого объекта в списке нет");
            }
            return str;
        }
    }

    public boolean findEqual(ArrayList<String> list) {
        HashMap<String, Integer> hm= new HashMap<>();
        for(int i=0; i< list.size(); i++)
        {
            if(hm.containsKey(list.get(i))){
                hm.replace(list.get(i), hm.get(list.get(i))+1);
            }
            else {
                hm.put(list.get(i), 1);
            }
        }
        SortedMap<String, Integer> sm = new TreeMap<>(hm);
        for(Map.Entry<String, Integer> pair : sm.entrySet() )
        {
            if(pair.getValue()!=1) {
                System.out.println(pair.getKey() + " " + pair.getValue());
            }
        }
        return true;
    }

    public ArrayList<String> findItemsWithSubstring(ArrayList<String> list, String substring) {
        ArrayList<String> foundItems = new ArrayList<>();
        if(substring != null) {
            for (String item : list) {
                if (item.contains(substring)) {
                    foundItems.add(item);
                }
            }
        }
        printFoundItems(foundItems);
        return foundItems;
    }

    public ArrayList<String> initializeListFromTextFile(String pathToTextFile){
        var fileLinesList = new ArrayList<String>();
        try (var fileReader = new BufferedReader(new FileReader(pathToTextFile))) {
            String line = fileReader.readLine();
            while (line != null) {
                fileLinesList.add(line);
                line = fileReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла.");
        }
        printList(fileLinesList);
        return fileLinesList;
    }

    public boolean compareInnerObjects(ArrayList<String> list, int firstItemIndex, int secondItemIndex) {
        boolean isEqual = false;
        if (firstItemIndex >= 0 && secondItemIndex >= 0) {
            String firstItem = list.get(firstItemIndex);
            String secondItem = list.get(secondItemIndex);
            if(firstItem != null){
                isEqual = firstItem.equals(secondItem);
            } else {
                isEqual = (secondItem == null);
            }
            if (isEqual) {
                System.out.println("Строки одинаковые");
            } else {
                System.out.println("Строки разные");
            }
        } else {
            System.out.println("Неверные индексы объектов");
        }
        return isEqual;
    }

    public ArrayList<String> printSortedByStringLengthList(ArrayList<String> list) {
        var sortedByStringLengthListCopy = new ArrayList<>(list);
        sortedByStringLengthListCopy.sort(new StringComparator());
        printListWithStringLength(sortedByStringLengthListCopy);
        return sortedByStringLengthListCopy;
    }

    public ArrayList<String> addItemStatic(ArrayList<String> list, String itemToAdd, int maxsize) {
        if (maxsize <= 0) {
            list.clear();
            return list;
        }
        while (list.size() >= maxsize) {
            list.remove(0);
        }
        list.add(itemToAdd);
        return list;
    }

    public boolean toXML (ArrayList < String > list) {
        FileOutputStream fos = null;
        XMLEncoder encoder = null;
        boolean check = false;
        try {
            fos = new FileOutputStream("array.xml");
            encoder = new XMLEncoder(fos);
            for(int i=0;i<list.size(); i++){
                encoder.writeObject(list.get(i));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally {
            if(encoder!=null)
                encoder.close();
            try {
                if(fos!=null) {
                    check = true;
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    public void reverse (ArrayList < String > list)
    {
        if(!list.isEmpty()) {
            String sb;
            for (int i = 0; i < list.size(); i++) {
                sb = new StringBuilder(list.get(i)).reverse().toString();
                list.remove(i);
                list.add(i, sb);
            }
        }
        else{
            System.out.println("Список пустой");
        }
    }

    public HashMap<Character, Integer> statistics (ArrayList < String > list) {
        StringBuilder newList = new StringBuilder();
        for(int i=0;i<list.size(); i++){
            newList.append(list.get(i));
        }
        String str = newList.toString();
        char [] chars = str.toCharArray();
        HashMap<Character, Integer> hm= new HashMap<>();
        for(int i=0; i< chars.length; i++)
        {
            if(hm.containsKey(chars[i])){
                hm.replace(chars[i], hm.get(chars[i])+1);
            }
            else {
                hm.put(chars[i], 1);
            }
        }
        SortedMap<Character, Integer> sm = new TreeMap<>(hm);
        for(Map.Entry<Character, Integer> pair : sm.entrySet() )
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        return hm;
    }


    public void printList(ArrayList<String> collection) {
        if(collection != null) {
            if (collection.size() == 0) {
                System.out.println("Коллекция пуста.");
            } else {
                System.out.println("Строки из коллекции:");
                for (var item : collection) {
                    System.out.println(item);
                }
            }
        }
    }

    public void printListWithStringLength(ArrayList<String> collection) {
        if(collection != null) {
            if (collection.size() == 0) {
                System.out.println("Коллекция пуста.");
            } else {
                System.out.println("Строки из коллекции:");
                for (var item : collection) {
                    System.out.println(item + " - " + item.length());
                }
            }
        }
    }

    public void printFoundItems(ArrayList<String> foundItems) {
        if (foundItems != null) {
            if (foundItems.size() > 0) {
                System.out.println("Найденные строки:");
                for (var item : foundItems) {
                    System.out.println(item);
                }
                return;
            }
        }
        System.out.println("Подходящие строки не найдены.");
    }

}