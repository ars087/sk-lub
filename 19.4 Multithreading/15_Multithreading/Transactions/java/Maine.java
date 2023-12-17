import java.util.ArrayList;
import java.util.List;

public class Maine {


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Виктор Семенов");
        list.add("Денис Цилюба");
        list.add("Снежанна Дроздик");
        list.add("Иван Димьян");
        list.add("Жанна  Ривнева");
        list.add("Антон Тиняев");
        list.add("Алла Бекетова");
        list.add("Парфирий Абражевич");

        Bank bank = new Bank(list);
        System.out.println(bank.getSumAllAccounts());

        int quantityProcessors = Runtime.getRuntime().availableProcessors();
        List<Thread> list1 = new ArrayList<>();
        for (int i = 0; i <= quantityProcessors; i++) {
            list1.add(new Thread(bank));

        }

        for (Thread p : list1) {

            p.start();

        }

        for (Thread p : list1) {

           try {
               p.join();
           }catch ( InterruptedException ex){

               System.out.println(ex.getMessage());
           }

        }




        System.out.println(bank.getSumAllAccounts());
    }

}