import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        StrFunctions strFunctions = new StrFunctions();
        Scanner scan = new Scanner(System.in);
        int i;
        boolean check = true;
        while(check) {
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
                    "11 - Статическое добавление\n"+
                    "12 - Вывод на экран\n"+
                    "0 - Выход\n");
            i = scan.nextInt();
            switch (i) {
                case 1: strFunctions.add(list);
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

                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    System.out.println("Ваш массив:");
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
