
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Shell {
    public static void main(String[] _args) {
        
        Pig pig = new Pig(0);

        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("init")) {
                int maxVolume = Integer.parseInt(par[1]);
                pig = new Pig(maxVolume);
            }
            else if (cmd.equals("show")) {
                System.out.println(pig);
            }
            else if (cmd.equals("addCoin")) {
                var coin = par[1];
                Coin instanceCoin = null;
                
                if(coin.equals("10"))
                    instanceCoin = Coin.C10;
                else if(coin.equals("25"))
                    instanceCoin = Coin.C25;
                else if(coin.equals("50"))
                    instanceCoin = Coin.C50;
                else if(coin.equals("100"))
                    instanceCoin = Coin.C100;
                    
                pig.addCoin(instanceCoin);
            }
            else if (cmd.equals("addItem")) {
                var item = par[1];
                var volume = Integer.parseInt(par[2]);
                
                pig.addItem(new Item(item, volume));
            }
            else if (cmd.equals("break")) {
                pig.breakPig();
            }
            else if (cmd.equals("extractCoins")) {
                // Obtenha as moedas usando o método extractCoins
                var extract = pig.extractCoins();
                // Imprima as moedas obtidas
                String coins = "";
        
                for(int i = 0; i < extract.size(); i++){
                    coins += (i != 0) ? ", " : "";
                    coins += extract.get(i);
                }
                System.out.println("["+coins+"]");
            }
            else if (cmd.equals("extractItems")) {
                // Obtenha os itens usando o método extractItems
                var extract = pig.extractItems();
                // I11mprima os itens obtidos
                String items = "";
        
                for(int i = 0; i < extract.size(); i++){
                    items += (i != 0) ? ", " : "";
                    items += extract.get(i);
                }
                System.out.println("["+items+"]");
            }
            else {
                System.out.println("fail: invalid command");
            }
        }
    }

    public static Scanner scanner = new Scanner(System.in);
}