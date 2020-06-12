import java.util.Scanner;

public class UnicodEnglish {

        public static void main(String[] args) {

            String letterRussian = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
            String smallLetterRussian = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

            String letterEnglish = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String smallLetterEnglish = "abcdefghijklmnopqrstuvwxyz";
            String figures = "0123456789";

            for (Character ch : letterRussian.toCharArray()) {

                int charDigit = (int) ch;
                System.out.println(ch + " | " + charDigit);

             }

            for (Character ch : smallLetterRussian.toCharArray()) {

                int charDigit = (int) ch;
                System.out.println(ch + " | " + charDigit);

            }

            for (Character ch : letterEnglish.toCharArray()) {

                int charDigit = (int) ch;
                System.out.println(ch + " | " + charDigit);
            }


            for (Character ch : smallLetterEnglish.toCharArray()) {

                int charDigit = (int) ch;
                System.out.println(ch + " | " + charDigit);
            }

            for (Character ch :figures .toCharArray()) {

                int charDigit = (int) ch;
                System.out.println(ch + " | " + charDigit);
            }

            System.out.println("----------------*********************----------------------");

            int i = 0;
            int x = 0;
            int g = 0;

            for (i = i; i < letterRussian.length();i++) {

                char   bigLetter = letterRussian.charAt(i); //русские буквы в печать--верхний регистр

                char  smollLetter = smallLetterRussian.charAt(i); //печать буквы в нижнем регистре


                System.out.println(bigLetter + "| " + (int) bigLetter + "|" + smollLetter + "|" + (int) smollLetter);

            }
            for( x = x; x < letterEnglish.length(); x++ ) {

            char  bigLetterEnglish = letterEnglish.charAt(x);// английские буквы в печать

            char smollLetterEnglish = smallLetterEnglish.charAt(x); //вывод английских  букв нижнего регистра



             System.out.println(bigLetterEnglish + "| " + (int) bigLetterEnglish + "|" + smollLetterEnglish + "|" +(int) smollLetterEnglish);

            }
            for( g = g; g <figures.length(); g++ ) {

              char  figuresChar = figures.charAt(g);


                System.out.println( figuresChar + "|" + (int)figuresChar );
            }

        }



    }

