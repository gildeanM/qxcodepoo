import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Utils {
    public static Coin createCoin(String coin){
        switch (coin){
            case "10": return Coin.M10;
            case "25": return Coin.M25;
            case "50": return Coin.M50;
            case "100": return Coin.M100;
            default: return null;
        }
    }

    public static String arrayToString(List list){
        String stringList = "";

        Iterator it = list.iterator();

        while(it.hasNext()){
            stringList += it.next();
            stringList += (it.hasNext()) ? ", " : "";
        }

        return stringList;
    }

}
