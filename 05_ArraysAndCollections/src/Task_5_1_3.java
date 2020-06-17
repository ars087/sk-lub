public class Task_5_1_3 {


    public static void main(String[] args) {

        final int SIZE = 9;
        final int WIDTH = 9;
        final  int ZERO = 0;

        char[][] one = new char[SIZE][WIDTH];

        int w,e = 0 ;
        int i = -1;
        int y = 0;


        int thirdLevelArray = one[e].length;

        for (w = ZERO; w < SIZE; w++) {
            i ++;
            y ++;
            for (e = ZERO; e < WIDTH; e++) {

                one[w][e] = 'x';

                if ( w == ( one.length + i) - one.length ) {

                    if (e != w && e != thirdLevelArray - y) {

                        one[w][e] = ' ';
                    }
                }
            }

        }
        for (w = 0; w < SIZE; w++) {

            for (e = 0; e < WIDTH; e++) {

                System.out.print(one[w][e]);

            }
            System.out.println();
        }
    }
}



