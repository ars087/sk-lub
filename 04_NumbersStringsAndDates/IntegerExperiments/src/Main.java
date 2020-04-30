public class Main     //
{
    public static void main(String[] args)
    {
        Container container = new Container();

        container.count += 7843;

        System.out.println(   container.count );

        System.out.println( sumDigits(569));
    }



    public static Integer sumDigits(Integer name)
    {
        String  input =Integer.toString(name);
        int count = 0;

        char index;

        for(int i = 0; i < input.length(); i++) {

            index = input.charAt(i);

            int  intNumber = Integer.parseInt(String.valueOf(index));



            count += intNumber ;

        }

       return count;


    }













}