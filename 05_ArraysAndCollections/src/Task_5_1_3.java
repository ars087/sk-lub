public class Task_5_1_3 {
        public static void main(String[] args) {
            char[][] one = new char[5][6];
            int w, e;
            for (w = 0; w < 5; w++) {

                for (e = 0; e < 6; e++) {

                    one[w][e] = 'x';
                    if (w == 0 || w == 4 ) {
                        if (e > 0 && e < 4) {
                            one[w][e] = ' ';
                        }
                    }else if (w ==1 || w == 3 ){

                        if ( e < 1 || e > 3 || e == 2 ) {
                            one[w][e] = ' ';
                        }

                    }else {

                        if (e !=2 ) {

                            one[w][e] = ' ';
                        }
                    }
                }
            }
            for (w = 0; w < 5; w++) {

                for (e = 0; e < 5; e++) {

                    System.out.print(one[w][e]);

                }
                System.out.println();
            }
        }
    }


