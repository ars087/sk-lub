import java.util.Scanner;


import java.util.Calendar;
import java.util.Scanner;

    public class FullName {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.println( " Напишите вашу Фамилию, Имя, Отчество!");

            String  fullName = scanner.nextLine();


            int x = 0;

            char indexInput;
            boolean finishPrinting = false;


            String  printSurname; //возврат фамилии
            String printName; ///возврат имени
            String printPatronymic;  ///возврат отчества


            boolean isClosingSurname   = true;
            boolean isClosingName = false;
            boolean isClosingPatronymic = false;


            boolean closeFirstSpace = false; ///первый пробел
            boolean closeSecondSpace = false; ///второй пробел
            boolean closeThirdSpace = false; // третий пробел


            boolean letterAfterSpace =false;

            int countSurname = 0;
            int countName = 0;
            int countPatronymic = 0;
            int letterBeforIntpatronymic = 0;


            int countFirstSpace = 0; //подсчет количества  пробелов  после фамилии
            int countSecondSpace = 0;//подсчет количества  пробелов  после имени
            int spaceThirdSpace = 0; //подсчет количества  пробелов  после отчества

            int spaceBeforeSurname =0;
            int spaceBeforeName =0;

            while (!finishPrinting) {  //////////////начало цикла/////////////////////////////////////////////////////////////////////////////////////////////////

                int lenghtDataInput = fullName.length();

                boolean isLenght = lenghtDataInput  <= 0;




                if (!isLenght){



                    indexInput = fullName.charAt(x);

                    char firstLetteRussianAlphabet = 'а';
                    char lastLetterRussiaAlphabet = 'я';
                    char firstLetteRussianUpperCase = 'А';
                    char lastLetterRussiaUpperCase = 'Я';
                    boolean russianAlphabet = (indexInput >= firstLetteRussianAlphabet) && (indexInput <=lastLetterRussiaAlphabet);
                    boolean russianAlphabetUpperCase = (indexInput >= firstLetteRussianUpperCase) && (indexInput <= lastLetterRussiaUpperCase);

                    char firstLetteEnglishAlphabet = 'a';
                    char lastLetterEnglishAlphabet = 'z';
                    char firstLetteEnglishUpperCase = 'A';
                    char lastLetterEnglishUpperCase = 'Z';

                    boolean englishAlphabet = (indexInput >= firstLetteEnglishAlphabet) && (indexInput <=lastLetterEnglishAlphabet);
                    boolean englishAlphabetUpperCase = (indexInput >=  firstLetteEnglishUpperCase) && (indexInput <= lastLetterEnglishUpperCase);

                    x += 1;
                    boolean isSpace = Character.isWhitespace(indexInput);  // является ли символ пробелом??

                    boolean isLetter = Character.isLetter(indexInput);// проверка: является ли введенный символ буквой


                    if (isSpace && countSurname <= 0 &&  countName <=0){

                        System.out.println("Введена пустая строка");
                        fullName = scanner.nextLine();


                    }




/////////////////////////////////////////////// проверка  условия на содержание  буквы ////////////////////////////////////////////////////////////////



                    if (isLetter || russianAlphabet || isSpace || russianAlphabetUpperCase) {

                        if(  englishAlphabet || englishAlphabetUpperCase){

                            System.out.println("Измените раскладку клавиатуры на ввод русскими буквами!");
                            x=0;
                            fullName = scanner.nextLine();

                        }

                        if (isLetter && isClosingSurname){ //////// количество символов в фамилии


                            countSurname += 1;
                            closeFirstSpace = true;

                        } else if ( isSpace && closeFirstSpace ){ countFirstSpace += 1; isClosingSurname = false; isClosingName = true;//пробел после фамилии
                            spaceBeforeSurname =x;
                        }/// пробелов после фамилии


                        if (isLetter && isClosingName && !isClosingSurname ){ /// символов в имени


                            countName += 1;
                            closeFirstSpace = false;
                            closeSecondSpace  = true;

                        } else if ( isSpace && closeSecondSpace ) {countSecondSpace += 1; isClosingName = false; isClosingPatronymic = true; spaceBeforeName = x; } ///пробелы после имени


                        if (isLetter && isClosingPatronymic ){ //////символов в отчестве

                            countPatronymic +=1;
                            closeSecondSpace = false;
                            closeThirdSpace = true;

                        }else if (isSpace && closeThirdSpace ) {  spaceThirdSpace +=1; isClosingPatronymic = false; letterAfterSpace = true;  } /// пробелов после в отчества

                        if (isLetter &&letterAfterSpace ){  ///количество букв после отчества

                            letterBeforIntpatronymic +=1;

                        }



                    } else {
                        System.out.println("Введен не допустимый символ :" + indexInput + "|" + "Пожалуйста вводите данные правильно!");

                        x = 0;


                        fullName = scanner.nextLine();
                    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                    if (x == fullName.length()) {

                        if ( countSurname >= 3  && countFirstSpace >= 1 && countName >= 2 && countSecondSpace >=1 && countPatronymic >= 3 && spaceThirdSpace >=0 &&  letterBeforIntpatronymic <= 0 ) {

                            finishPrinting = true;

                        } else {


                            System.out.println("Введите данные разделяя  фамилию, имя, отчество пробелом!!");
                            System.out.println("Возможно вы ввели не полные данные!");

                            x = 0;


                            countSurname = 0;
                            countName= 0;
                            countPatronymic = 0;

                            countFirstSpace = 0;  // подсчет количества  пробелов после фамилии
                            countSecondSpace = 0; // подсчет количества пробелов после имени.
                            spaceThirdSpace = 0; // подсчет количества пробелов после отчества.

                            spaceBeforeSurname = 0; // номера места нахождения первого пробела
                            spaceBeforeName = 0; // номер места нахождения второго  пробела

                            letterBeforIntpatronymic = 0; // буква после отчесывытва


                            isClosingSurname = true; // закрытие подсчета фамилии
                            isClosingName = false;// закрытие подсчета имени
                            isClosingPatronymic= false; //закрытие подсчета отчества


                            closeFirstSpace  = false; /// закрытие  первого пробела
                            closeSecondSpace = false; /// второй пробел
                            closeThirdSpace = false; /// третий пробел

                            letterAfterSpace =false; ///буква после отчества

                            fullName= scanner.nextLine();

                        }
                    }

                } else {
                    System.out.println("Данные не введены!!! Впишите ваше ФИО ");

                    fullName = scanner.nextLine();


                }

            }///конец цикла.////-------------------------------///////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            int lenghtFullname = fullName.length()  ;


            printSurname =  fullName.substring( 0,spaceBeforeSurname); // возврат фамилии

            printName = fullName.substring( spaceBeforeSurname, spaceBeforeName ); // возврат имени

            printPatronymic =  fullName.substring( spaceBeforeName, lenghtFullname );  //возврат  отчества


/////////////////////////////////////////// первый символ фамилии /////////////////////////////////////////////////
            char getIsOneLetterSurname = printSurname.charAt(0); // первый   символ фамилии

            boolean isUpperCaseSurname = Character.isUpperCase(getIsOneLetterSurname);// в верхнем ли регистре  символ??
            String requiredLetterSurname  = Character.toString(getIsOneLetterSurname);// замена буквы


            char toUpperCaseSurname = Character.toUpperCase(getIsOneLetterSurname); // преобразует символ в верхний регистор
            String replaceFirstLetterSurname = Character.toString(toUpperCaseSurname); //замена буквы

            if (!isUpperCaseSurname) {
                printSurname = printSurname.replaceFirst(requiredLetterSurname , replaceFirstLetterSurname);
            }

//////////////////////////////////////// первый символ имени//////////////////////////////////////////////////////

            char getIsOneLetterName = printName.charAt(0); // первый символ имени

            boolean isUpperCaseName = Character.isUpperCase(getIsOneLetterName);
            String requiredLetterName  = Character.toString( getIsOneLetterName);// замена буквы

            char toUpperCaseName =  Character.toUpperCase(getIsOneLetterName);
            String replaceFirstLetterName = Character.toString(toUpperCaseName); //замена буквы

            if (!isUpperCaseName) {
                printName  =printName.replaceFirst(requiredLetterName , replaceFirstLetterName);

            }

//////////////////////////////////////// первый символ в отчестве//////////////////////////////////////////////////

            char getIsOneLetterPatronymic = printPatronymic.charAt(0); // первый символ имени

            boolean isUpperCasePatronymic = Character.isUpperCase(getIsOneLetterPatronymic);
            String requiredLetterPatronymic  = Character.toString( getIsOneLetterPatronymic);// замена буквы

            char toUpperCasePatronymic =  Character.toUpperCase(getIsOneLetterPatronymic);
            String replaceFirstLetterPatronymic  = Character.toString(toUpperCasePatronymic); //замена буквы

            if (!isUpperCasePatronymic) {
                printPatronymic =printPatronymic.replaceFirst(requiredLetterPatronymic , replaceFirstLetterPatronymic);

            }

            System.out.println("Данные введены верно!!!");

            System.out.println("Фамилия :" +printSurname.trim());

            System.out.println("Имя :" + printName.trim());

            System.out.println("Отчество:" + printPatronymic.trim());



        }
    }

