public class Task_5_1_2 {
        public static void main(String args[]) {
            double[] ticketNumbers = new double[30];

            int count = 0;

            double averageValue = 0;
            double averageValuePlus = 0;

            for (int i = 0; i < ticketNumbers.length; i++) {


                //int value = 32 + (int) Math.round(40 * Math.random());
                double value = 32 + Math.random() * 8;
                double roundOff = Math.round(value * 10.0) / 10.0;
                ticketNumbers[i] = roundOff; //заполняем массив случайными показателями температуры


                averageValuePlus += ticketNumbers[i];
                averageValue = Math.round(averageValuePlus / 30 * 10.0) / 10.0; //


                boolean normalTemperature = ticketNumbers[i] >= 36.2 && ticketNumbers[i] <= 36.9;
                if (normalTemperature) {
                    count += 1;

                }

                System.out.println(ticketNumbers[i]);

            }

            System.out.println("Средняя температура :" + averageValue);

            System.out.println( "Количество здоровых пациентов :" + count );


        }
    }

