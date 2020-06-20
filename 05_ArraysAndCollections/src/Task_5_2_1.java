import java.util.ArrayList;
import java.util.Scanner;

public class Task_5_2_1 {

    public static void main(String[] args) {

        final String ADD = "ADD";
        final String DELETE = "DELETE";
        final  String EDIT = "EDIT";
        final  String LIST = "LIST";


        ArrayList<String> list = new ArrayList<>();

        for (; ;) {
            System.out.println("Введите ключевое слово!");
            String input = new Scanner(System.in).nextLine();
            if (input.length() != 0) {


                if (input.subSequence(0, ADD.length()).equals(ADD)) {


                    String addStringNumber = input.trim().replaceAll("[^0-9]", "");

                    if (addStringNumber.length() > 0) {
                        int number = Integer.parseInt(addStringNumber);

                        if (number > list.size()) {
                            number = list.size();
                            list.add(number, input);
                            System.out.println("Позиция добавлена");
                        } else {
                            list.add(number, input);
                            System.out.println("Позиция добавлена");
                        }

                    } else {
                        list.add(input);
                        System.out.println("Позиция добавлена");
                    }

                } else if (input.equals(LIST)) {
                    int p = 0;
                    for (String print : list) {
                        p++;
                        System.out.println(p + "-" + print);

                    }


                    /////////////////////*///////////////////////////
                } else if (input.subSequence(0, EDIT.length()).equals(EDIT)) {

                    String editNumderString = input.trim().replaceAll("[^0-9]", "");

                    if (editNumderString.length() > 0) {

                        int intEdit = Integer.parseInt(editNumderString);

                        if (intEdit > list.size()) {

                            intEdit = list.size() - 1;

                            list.set(intEdit, input);
                            System.out.println("Изменения внесены!");

                        } else {
                            list.set(intEdit, input);
                            System.out.println("Изменения внесены!");
                        }

                    } else {

                        System.out.println("Укажите номер  позиции, которую необходимо отредактировать!");
                    }


                } else if (input.subSequence(0, DELETE.length()).equals(DELETE)) {

                    String deleteNumderString = input.trim().replaceAll("[^0-9]", "");

                    if (deleteNumderString.length() > 0) {

                        int deleteNumderInt = Integer.parseInt(deleteNumderString);

                        if (deleteNumderInt > list.size()) {

                            deleteNumderInt = list.size() - 1;
                            list.remove(deleteNumderInt);
                            System.out.println("Удалена последняя позиция!");

                        } else {
                            list.remove(deleteNumderInt);

                            System.out.println("Позиция удалена!");
                        }

                    } else {
                        list.clear();
                        System.out.println("Список очищен!");
                    }


                }

            }else {
                System.out.println("Введите данные!");
            }
        }

        }
}