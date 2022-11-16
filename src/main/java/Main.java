import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        StrFunctions strFunctions = new StrFunctions();
        Scanner scan = new Scanner(System.in);
        int i;
        boolean check = true;

        System.out.println("Введите максимальную размерность при статическом добавлении элементов:");
        int maxsize = scan.nextInt();

        while(check) {
            System.out.println("Выберите действие");
            i = scan.nextInt();
            switch (i) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.print("Введите подстроку:");
                    scan.nextLine();
                    String substring = scan.nextLine();
                    strFunctions.printList(strFunctions.findItemsWithSubstring(list, substring));
                    break;
                case 8:
                    System.out.print("Введите путь к файлу:");
                    scan.nextLine();
                    String pathToFile = scan.nextLine();
                    strFunctions.initializeListFromTextFile(pathToFile);
                    break;
                case 9:
                    System.out.print("Введите индексы объектов для сравнения:");
                    int firstItemIndex = scan.nextInt();
                    int secondItemIndex = scan.nextInt();
                    if(strFunctions.compareInnerObjects(list, firstItemIndex, secondItemIndex)){
                        System.out.println("Строки одинаковые");
                    } else {
                        System.out.println("Строки разные");
                    }
                    break;
                case 10:
                    for(var length : strFunctions.itemLengthList(list)){
                        System.out.println(length);
                    }
                    break;
                case 11:
                    System.out.print("Введите строку для статического добавления:");
                    scan.nextLine();
                    String str = scan.nextLine();
                    strFunctions.addItemStatic(list, str, maxsize);
                    break;
                case 12:
                    for(int j =0; j< list.size(); j++ )
                    {
                        System.out.println(list.get(j));
                    }
                    break;
                case 0: check = false;
                    break;
                default:
                    System.out.println("Такого действия нет. Повторите ввод");
            }
        }
    }
}
