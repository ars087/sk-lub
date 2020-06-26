import java.util.ArrayList;
import java.util.Scanner;

public class Task_5_2_1 {


    private static final  String REG_ADD = "ADD\\s+\\d*+\\s*+.+";
    private static final String REG_EDIT = "EDITE\\s+\\d+\\s+.+";
    private static final String REG_DELETE = "DELETE\\s*+\\d*+\\s*+";
    private static final String REG_LIST = "LIST";


   private static  ArrayList<String> list = new ArrayList<>();



    public static void main(String[] args) {



        for (; ; ) {
            System.out.println( "\t \t \t Для внесения изменений в список используйте следующие ключевые слова," + "\n"
                    + "\t \t \t добавить - ADD, редактировать - EDITE, удалить - DELETE, вывести на экран все позиции в списке - LIST");

            String input = new Scanner(System.in).nextLine();

            addIndex(input);
            editeIndex(input);
            deleteIndex(input);
            listIndex(input);

            if (list.size() == 0) {

                System.out.println("Список пуст! Добавьте позицию.");

            } else {
                System.out.println("В списке позиций - " + list.size());
            }

        }

    }


    private static void addIndex(String add) {



        if (add.matches(REG_ADD)) {

            String[] addArray = add.split("\\s", 3);

            String replaceAll = addArray[1].replaceAll("[^0-9]","");

            if (replaceAll.length() > 0 && addArray.length == 3) {
                int number = Integer.parseInt(replaceAll);
                String todoText = addArray[2];

                if (number > list.size() && list.size() > 0 ) {
                    list.add(todoText);
                    System.out.println("Позиция будет  добавлена в конец списка");
                } else if ( (number > list.size() && list.size() == 0 )){
                    list.add(todoText);
                    System.out.println("Позиция добавлена!");

                } else {
                    list.add(number,todoText);
                    System.out.println("Позиция добавлена!");
                }

            } else if (addArray.length == 3) {
                String todoText = addArray[1];
                String todoTextSecond = addArray[2];
                list.add(todoText +" "+ todoTextSecond);
                System.out.println("Позиция добавлена");

            } else {
               String todoText = addArray[1];

                list.add(todoText);
                System.out.println("Позиция добавлена");
            }

        }

    }

    private static void editeIndex(String edite) {


        if (edite.matches(REG_EDIT)) {

            String[] editeArray = edite.split("\\s");

            String replaceAll = editeArray[1].trim().replaceAll("[^0-9]", "");
            int number = Integer.parseInt(replaceAll);

            if (number <= list.size()) {
                list.set(number, editeArray[2]);
                System.out.println("Изменения внесены!");
            } else {
                System.out.println("Вы указали не существующий номер позиции! На данный момент в списке :" + list.size() + " - позиций.");
            }

        }


    }

    private static void deleteIndex(String delete) {

        if (delete.matches(REG_DELETE)) {

            String[] deleteArray = delete.split("\\s");

            if (deleteArray.length == 2) {
                String replaceAll = deleteArray[1].replaceAll("[^0-9]", "");

                int number = Integer.parseInt(replaceAll);
                if (number <= list.size() && list.size() > 0) {

                    list.remove(number);
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

    private static void listIndex(String listInput) {


        if (listInput.matches(REG_LIST)) {


            for ( int i = 0; i < list.size();i++) {

                System.out.println(  i + 1 + ")"+ list.get(i));
            }

        }

    }
}


