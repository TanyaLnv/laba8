import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var list = new ArrayList();
        var strFunctions = new StrFunctions();
        var scan = new Scanner(System.in);

        int i;//код меню
        boolean check = true;

        System.out.println("Введите максимальную размерность при статическом добавлении элементов:");
        int maxsize = enterInt(scan);
        while(maxsize<=0){
            System.out.print("Требуется целое положительное число. Повторите ввод:");
            maxsize = enterInt(scan);
        }

        System.out.println("1 - Добавление\n" +
                "2 - Удаление\n" +
                "3 - Поиск одинаковых элементов\n" +
                "4 - Выгрузка\n" +
                "5 - Реверс\n" +
                "6 - Статистика символов\n" +
                "7 - Поиск подстроки\n" +
                "8 - Инициализация\n" +
                "9 - Сравнение элементов\n" +
                "10 - Длина строк\n" +
                "11 - Статическое добавление\n" +
                "12 - Вывод на экран\n" +
                "0 - Выход\n");
        while (check) {
            System.out.println("\nВыберите действие");
            i = enterInt(scan);

            switch (i) {
                case 1:
                    System.out.println("Введите слово для добавления: ");
                    String s;
                    s = scan.nextLine();
                    strFunctions.add(list, s);
                    break;
                case 2:
                    System.out.println("Введите слово для удаления (происходит удаление первого вхождения слова, если есть одиноковые слова, повторите процедуру удаления )");
                    s = scan.nextLine();
                    strFunctions.remove(list, s);
                    break;
                case 3:
                    strFunctions.findEqual(list);
                    break;
                case 4:
                    strFunctions.toXML(list);
                    break;
                case 5:
                    strFunctions.reverse(list);
                    break;
                case 6:
                    strFunctions.statistics(list);
                    break;
                case 7:
                    System.out.print("Введите подстроку:");
                    String substring = scan.nextLine();
                    strFunctions.findItemsWithSubstring(list, substring);
                    break;
                case 8:
                    System.out.print("Введите путь к файлу для инициализации коллекции:");
                    String pathToFile = scan.nextLine();
                    System.out.println(pathToFile);
                    list = strFunctions.initializeListFromTextFile(pathToFile);
                    break;
                case 9:
                    System.out.println("Введите индексы объектов для сравнения");
                    int firstItemIndex, secondItemIndex;

                    System.out.print("Индекс первого объекта:");
                    firstItemIndex = enterInt(scan);

                    System.out.print("Индекс второго объекта:");
                    secondItemIndex = enterInt(scan);

                    strFunctions.compareInnerObjects(list, firstItemIndex, secondItemIndex);
                    break;
                case 10:
                    strFunctions.printSortedByStringLengthList(list);
                    break;
                case 11:
                    System.out.print("Введите строку для статического добавления:");
                    String str = scan.nextLine();
                    strFunctions.addItemStatic(list, str, maxsize);
                    break;
                case 12:
                    strFunctions.printList(list);
                    break;
                case 0:
                    check = false;
                    break;
                default:
                    System.out.println("Такого действия нет. Повторите ввод");
            }
        }
    }

    public static int enterInt(Scanner scan){
        while (!scan.hasNextInt()){
            scan.nextLine();
            System.out.print("Требуется целое число. Повторите ввод:");
        }
        int number = scan.nextInt();
        if(scan.hasNextLine()){
            scan.nextLine();
        }
        return number;
    }
}
