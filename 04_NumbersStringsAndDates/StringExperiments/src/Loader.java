
public class Loader
{
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

            int vasyaIndexOne = text.indexOf('л') + 1;
            int vasyaIndexTwo = text.indexOf('у') - 1;
            String substringVasya = text.trim().substring(vasyaIndexOne, vasyaIndexTwo);
            int parseIntVasya = Integer.parseInt(substringVasya.trim());

            //////////////////////////////////////////////////////////////////////////
            int petayIndex = text.indexOf(',');
            int petayIndexTwo = text.lastIndexOf(',');
            String substringPetya = text.substring(petayIndex, petayIndexTwo);

            int petaySalary = substringPetya.indexOf('-') + 1;
            int petaySalaryTwo = substringPetya.lastIndexOf(' ');
            String substringPetaTwo = substringPetya.substring(petaySalary, petaySalaryTwo);
            int parseIntPetya = Integer.parseInt(substringPetaTwo.trim());

            ///////////////////////////////////////////////////////////////////////////
            int MashaIndexOne = text.lastIndexOf('-') + 1;
            int MashaIndexTwo = text.lastIndexOf(' ');
            String substringMasha = text.substring(MashaIndexOne, MashaIndexTwo);
            int intMasha = Integer.parseInt(substringMasha.trim());
            int summa = parseIntVasya + parseIntPetya + intMasha;
            System.out.println("Заработок Васи" + substringVasya);
            System.out.println("Заработок Пети" + parseIntPetya);
            System.out.println("Заработок Маша" + substringMasha);
            System.out.println("Общая сумма заработка Васи, Пети и Маши :" + summa + "рублей");

        }
    }

