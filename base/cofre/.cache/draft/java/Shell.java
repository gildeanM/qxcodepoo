import java.util.Scanner;

public class Shell {
    public static void main(String[] arg) {
        Pig pig = new Pig(5);

        while (true) {
            String line = input();
            println("$" + line);
            String[] args = line.split(" ");

            try {
                if      (args[0].equals("end"))          { break; }
                else if (args[0].equals("init"))         { pig = new Pig( (int) number(args[1]) ); }
                else if (args[0].equals("show"))         { println(pig); }
                else if (args[0].equals("addCoin"))      { pig.addValuable( Utils.createCoin( args[1] ) ); }
                else if (args[0].equals("addItem"))      { pig.addValuable( new Item( args[1], number(args[2]), (int) number(args[3]) ) ); }
                else if (args[0].equals("break"))        { pig.breakPig(); }
                else if (args[0].equals("extractCoins")) { try{println("[" + Utils.arrayToString(pig.getCoins()) + "]");}catch(Exception e){println(e.getMessage());} }
                else if (args[0].equals("extractItems")) { try{println("[" + Utils.arrayToString(pig.getItems()) + "]");}catch(Exception e){println(e.getMessage());} }
                else                                     { println("fail: comando invalido"); }
            } catch (Exception e) {
                println(e.getMessage());
                // e.printStackTrace(System.out);
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static String  input()                { return scanner.nextLine();        }
    private static double  number(String value)   { return Double.parseDouble(value); }
    public  static void    println(Object value)  { System.out.println(value);        }
    public  static void    print(Object value)    { System.out.print(value);          }
}
