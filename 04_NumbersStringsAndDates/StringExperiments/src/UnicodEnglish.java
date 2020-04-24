import java.util.Scanner;

public class UnicodEnglish {

        public static void main(String[] args) {

            String letterRussian = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
            String smallLetterRussian = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

            String letterEnglish = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String smallLetterEnglish = "abcdefghijklmnopqrstuvwxyz";
            String figures = "0123456789";


            char bigLetter;
            int bigLetterInt;

            char smollLetter;
            int smollLetterInt;

            char bigLetterEnglish;
            int bigLetterEnglishInt;

            char  smollLetterEnglish;
            int smallLetterEnglishInt;

            char figuresChar;
            int figuresInt;

            int i = 0;
            int x = 0;
            int g = 0;

            for (i = i; i < letterRussian.length();i++) {

                bigLetter = letterRussian.charAt(i); //русские буквы в печать--верхний регистр
                bigLetterInt =  bigLetter; /// русские буквы  int кодировка //преобразование

                smollLetter = smallLetterRussian.charAt(i); //печать буквы в нижнем регистре
                smollLetterInt = (int) smollLetter;   //преобразование в int


                System.out.println(bigLetter + "| " + bigLetterInt + "|" + smollLetter + "|" +smollLetterInt);


            }

            for( x = x; x < letterEnglish.length(); x++ ) {

                bigLetterEnglish = letterEnglish.charAt(x);// английские буквы в печать
                bigLetterEnglishInt =(int) bigLetterEnglish;     /// англ инт в кодировке


                smollLetterEnglish = smallLetterEnglish.charAt(x); //вывод английских  букв нижнего регистра
                smallLetterEnglishInt = (int) smollLetterEnglish;

                System.out.println(bigLetterEnglish + "| " + bigLetterEnglishInt + "|" + smollLetterEnglish + "|" + smallLetterEnglishInt);

            }

            for( g=g; g <figures.length(); g++ ) {

                figuresChar = figures.charAt(g);
                figuresInt = (int)  figuresChar;


                System.out.println(figuresChar + "|" + figuresInt);
            }
        }
    }

