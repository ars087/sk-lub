import java.util.ArrayList;
import java.util.Scanner;

public class Task_5_2_1 {

    public static void main(String[] args) {

        final String ADD = "ADD";
        final String DELETE = "DELETE";
        final String EDIT = "EDIT";
        final String LIST = "LIST";

        ArrayList<String> list = new ArrayList<>();

        for (; ; ) {
            System.out.println( "\t \t \t Для внесения изменений в список используйте следующие ключевые слова," + "\n"
                    + "\t \t \t добавить - ADD, редактировать - EDITE, удалить - DELETE, вывести на экран все позиции в списке - LIST");


            String input = new Scanner(System.in).nextLine();

            addIndex(input, list);
            editeIndex(input, list);
            deleteIndex(input, list);
            listIndex( input,list);

            if (list.size() == 0) {

                System.out.println("Список пуст! Добавьте позицию.");

            } else {
                System.out.println("В списке позиций - " + list.size());
            }

        }

    } //// бесконечный цикл


    ////////////////////////////////Метод ADD///////////////////////////////////////////////
    private static void addIndex(String add, ArrayList<String> list) {

        final String REG_ADD = "ADD\\s+\\d*+\\s*+.+";


        if (add.matches(REG_ADD)) {

            String[] array = add.split("\\s", 3);

            String addStringNumber = array[1].replaceAll("[^0-9]", "");
            boolean boolStr = addStringNumber.length() > 0;

            if (addStringNumber.length() > 0 && array.length == 3) {
                int number = Integer.parseInt(addStringNumber);
                String arrayTwo = array[2];

                if (number > list.size()) {
                    number = list.size();
                    list.add(number, arrayTwo);
                    System.out.println("Позиция добавлена в конец списка");
                } else {
                    list.add(number, arrayTwo);
                    System.out.println("Позиция добавлена");
                }

            } else if (array.length == 3) {
                String arrayOne = array[1];
                String arrayTwo = array[2];
                list.add(arrayOne + arrayTwo);
                System.out.println("Позиция добавлена");

            } else {
                String arrayOne = array[1];

                list.add(arrayOne);
                System.out.println("Позиция добавлена");
            }

        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    }

    private static void editeIndex(String edite, ArrayList<String> list) {

        final String REG_EDITE = "EDITE\\s+\\d+\\s+.+";

        if (edite.matches(REG_EDITE)) {

            String[] editeArray = edite.split("\\s");

            String editNumderString = editeArray[1].trim().replaceAll("[^0-9]", "");
            int intEdit = Integer.parseInt(editNumderString);

            if (intEdit <= list.size()) {
                list.set(intEdit, editeArray[2]);
                System.out.println("Изменения внесены!");
            } else {
                System.out.println("Вы указали не существующий номер позиции! На данный момент в списке :" + list.size() + " - позиций.");
            }

        }


    }

    // private void addIndex (String add,int index ){
    private static void deleteIndex(String delete, ArrayList<String> list) {
        final String REG_DELETE = "DELETE\\s*+\\d*+\\s*+";

        if (delete.matches(REG_DELETE)) {

            String[] arrayDelete = delete.split("\\s");

            if (arrayDelete.length == 2) {
                String deleteNumderString = arrayDelete[1].replaceAll("[^0-9]", "");

                int deleteNumderInt = Integer.parseInt(deleteNumderString);
                if (deleteNumderInt <= list.size() && list.size() > 0) {

                    list.remove(deleteNumderInt);
                    System.out.println("Позиция удалена!");

                } else {
                    System.out.println("Вы пытаетесь удалить не существующую позицию в списке!");
                }

            } else if (list.size() != 0) {
                list.clear();
                System.out.println("Список очищен!");
            } else {
                System.out.println("Вы пытаетесь удалить не существующий список!");
            }


        }


    }

    private static void listIndex(String listInput, ArrayList<String> list) {
        final String REG_LIST = "LIST";

        if (listInput.matches(REG_LIST)) {

            int p = 0;
            for (String print : list) {
                p++;
                System.out.println(p + "-" + print);
            }

        }

    }
}


