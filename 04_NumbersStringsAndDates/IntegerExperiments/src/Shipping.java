import java.util.Scanner;
    public class Shipping {
        public static void main(String[] args) {
            System.out.println("Ведите количество перевозимых коробок! ");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();

            //  int allBox = number;
            int oneCargoContainer = 12; // количество  контейнеров  вмещающихся в один грузовой автомобиль
            int boxInContainer = 27; // количество  вмещающихся коробок в одном контейнере
            int allBoxInOneCargo = boxInContainer * oneCargoContainer ;// общее количество коробо к в одном авто

            final int ZERO = 0;
            int i = 0; //счетчик ящиков
            int containerPlus = 0;//количество вхождений в условие/ подсчет количество контейнеров
            int cargoPlus =0; //

////--------------------------------------------------------------------------------------/////////////////////////
            for ( i=i; i <= number ; i++ ) {

                if (  i != ZERO  ) {   //////считаем грузовики
                    System.out.println("\t"  + "\t" + "\t" + "\t" + "ящик№" + i);
                }
                int moduloDivisionCargo = i % allBoxInOneCargo;

                if( moduloDivisionCargo  == ZERO ) {
                    cargoPlus += 1;

                    if (i != number) {
                        System.out.println(  "грузовик № " + cargoPlus);

                    }
                    if (i == number) {
                        cargoPlus -=1;
                    }

                }
                ///////////считаем контейнеры
                int  moduloDivisionContainer = i % boxInContainer; //- остаток от i - определение контейнеров
                if (moduloDivisionContainer == ZERO) {
                    containerPlus += 1;

                    if (i != number) {
                        System.out.println("\t" + "\t" + "контейнер № " + containerPlus);
                    }
                    if (i == number){

                        containerPlus -=1;
                    }
                }

                if (i >= number) {

                    break;

                }
            }/////////////////////////////////////////////////завершение цикла

            int leftoversBoxes = i % boxInContainer;

            if( number!= ZERO ){

                System.out.println( "для перевозки ящиков количеством" + number + "шт." + "необходимо грузовых транспортных средств:" + cargoPlus );


                System.out.println("так же необходимы контейнеры  в количестве:"+ containerPlus  );

                if (leftoversBoxes!= ZERO) {
                    System.out.println("контейнер №" + containerPlus + "не достаточно заполнен!В нем ящиков:" + leftoversBoxes + " вместимость ящиков в одином контейнере:" + boxInContainer);
                }

            }
        }
    }


