import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class StrFunctions {
    Scanner scan = new Scanner(System.in);

    public void add(ArrayList<String> list){
        System.out.println("Введите слово для добавления: ");
        String str;
        str = scan.nextLine();
        list.add(str);
    }

    public void remove(ArrayList<String> list)
    {
        if(list.isEmpty()){
            System.out.println("Пусто");
        }else {
            System.out.println("Введите слово для удаления (происходит удаление первого вхождения слова, если есть одиноковые слова, повторите процедуру удаления )");
            String str;
            str = scan.nextLine();
            if(list.remove(str)){
                System.out.println("Объект успешно удален");
            }
            else{
                System.out.println("Такого объекта в списке нет");
            }
        }
    }

    public void findEqual(ArrayList<String> list) {
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
    }

    public void toXML (ArrayList < String > list) {
        FileOutputStream fos = null;
        XMLEncoder encoder = null;
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
                if(fos!=null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void reverse (ArrayList < String > list)
    {
        String sb;
        for (int i = 0; i < list.size(); i++) {
            sb = new StringBuilder(list.get(i)).reverse().toString();
            list.remove(i);
            list.add(i, sb);
        }
    }

    public void statistics (ArrayList < String > list) {
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
    }

}