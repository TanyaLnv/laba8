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
        while (check) {
            System.out.println("Выберите действие");
            System.out.println(" 1 - Добавление\n" +
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
            i = scan.nextInt();
            switch (i) {
                case 1:
                    strFunctions.add(list);
                    break;
                case 2:
                    strFunctions.remove(list);
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
                    if (strFunctions.compareInnerObjects(list, firstItemIndex, secondItemIndex)) {
                        System.out.println("Строки одинаковые");
                    } else {
                        System.out.println("Строки разные");
                    }
                    break;
                case 10:
                    for (var length : strFunctions.itemLengthList(list)) {
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
                    strFunctions.printList(list);
                    break;
                case 0:
                    check = false;
                    break;
                default:
                    System.out.println("Такого действия нет. Повторите ввод");
            }

        }
        //Изменения Наташи Масловской
    }
}
