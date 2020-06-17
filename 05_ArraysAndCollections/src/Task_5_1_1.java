public class Task_5_1_1 {
    public static void main(String args[]) {
        String text = "Каждый охотник желает знать, где сидит  фазан";

        String[] colors = text.split(",?\\s+");

        int colorsLength = colors.length;

        for (int i = 0; i < colorsLength /2; i++) {

            String temp = colors[colorsLength - i - 1];
            colors[colorsLength - i - 1] = colors[i];
            colors[i] = temp;
        }


        //Выводим конечный массив в консоль
        for (int i = 0; i < colors.length; i++) {
            System.out.println(colors[i]);

        }
    }
}
