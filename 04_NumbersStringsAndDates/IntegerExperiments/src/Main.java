public class Main
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

        Integer number1  = Integer.parseInt(String.valueOf(input.charAt(0)));
        Integer number2  = Integer.parseInt(String.valueOf(input.charAt(1)));
        Integer number3  = Integer.parseInt(String.valueOf(input.charAt(2)));

        //@TODO: write code here

        return number1+number2+number3 ;
    }













}