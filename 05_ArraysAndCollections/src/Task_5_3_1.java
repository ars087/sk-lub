import java.util.NavigableSet;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Task_5_3_1 {

    private static final  String REG_ADD = "ADD\\s+\\b([\\dA-Za-z[_][-][!#$%&'*+/=?^_`{|}~]]([\\.])?)+\\b@\\b([\\da-z]([-])?)+\\b\\.[A-Za-z]+$";
    private static final String REG_LIST = "LIST";
    private static final  String REG_CLEAR ="CLEAR\\s*+";

    private static TreeSet <String> list = new TreeSet();

    public static void main(String[] args) {


  for (;;){

    String input = new Scanner(System.in).nextLine();

      addIndex(input);
      listIndex(input);
      clearIndex(input);
      if ( list.size() > 0 ){

          System.out.println("Количество E-mail в списке :"+list.size()  );
      }else {
          System.out.println("Список пуст");

      }

    }
    }

    private static void addIndex(String add) {

        if (add.matches(REG_ADD)) {

         String [] addArray = add.split("\\s+",2);
          String todoText = addArray[1];

            list.add(todoText);
            System.out.println("E-mail добавлен в список");

        }

    }

    private static void listIndex(String listInput) {

        if (listInput.matches(REG_LIST)) {


            for ( String list :  list) {

                System.out.println(list);
            }

        }

    }
    private static void clearIndex(String clear) {

        if (clear.matches(REG_CLEAR)) {

          if (list.size()> 0) {
              list.clear();
              System.out.println("Список очищен");
          }
        }
      }
    }




