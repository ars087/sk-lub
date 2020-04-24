public class Loade_4_5 {

    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя 7563 - рубля, а Маша 30000 - рублей";

        String countText = text.replaceAll("[^0-9]"," ");

        String[]  textSplit  = countText.trim().split("\\s+");
        int i=0;

        int vasya = 0;
        int petya = 0;
        int masha = 0;
        int amount;

        if ( textSplit.length >1) {

            for (i = i; i < textSplit.length; i++) {


                if (i == 0) {
                    vasya = Integer.parseInt(textSplit[i]);

                } else if (i == 1) {

                    petya = Integer.parseInt(textSplit[i]);

                } else if (i == 2) {

                    masha = Integer.parseInt(textSplit[i]);

                }

                System.out.println(textSplit[i]);

            }
            if  ( vasya> 0 || petya >0 || masha >0 ){

                amount = vasya + petya + masha;

                System.out.println("Общая сумма заработка Васи,Пети и Маши :" + amount);

            }

        }else {
            System.out.println("Данные отсутствуют");}

    }


}
