import java.text.DecimalFormat;
import java.util.Formatter;

public class Task_5_1_2 {
        public static void main(String args[]) {

            final int PATIENTS = 30;
            final double MAX_TEMP = 40.5;
            final double MIN_TEMP = 32;

            final double MIN_TEMP_PATIENT =  36.2;
            final double MAX_TEMP_PATIENT =  36.9;



            double[] ticketNumbers = new double[PATIENTS];

            int count = 0;

            double averageValue = 0;
            double averageValuePlus = 0;


            DecimalFormat format = new DecimalFormat("#0.00°C");

            for (int i = 0; i < ticketNumbers.length; i++) {
                //int value = 32 + (int) Math.round(40 * Math.random());
             //   double value = MIN_TEMP +(int) ( Math.random() * 8);
                double value = MIN_TEMP  + (Math.random() * ((MAX_TEMP - MIN_TEMP)));
                //double roundOff = Math.round(value * 10.0) / 10.0;
                ticketNumbers[i] = value; //заполняем массив случайными показателями температуры


                averageValuePlus += ticketNumbers[i];
               // averageValue = Math.round(averageValuePlus / 30 * 10.0) / 10.0; //
                averageValue = averageValuePlus / 30;

                boolean normalTemperature = ticketNumbers[i] >= MIN_TEMP_PATIENT && ticketNumbers[i] <= MAX_TEMP_PATIENT;

                if (normalTemperature) {
                    count += 1;
                }
                System.out.println(format.format(ticketNumbers[i]));
            }

      // System.out.println("Средняя температура :" + format.format( averageValue));

            System.out.println( "Количество здоровых пациентов :" + count );
            System.out.printf("Средняя температура = %.02f C", averageValue);


        }
    }

