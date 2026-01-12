import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pig {

    private boolean broken;
    private ArrayList<Valuable> valuables;
    private int volumeMax;

    public Pig(int volumeMax) {
        this.volumeMax = volumeMax;
        this.broken = false;
        this.valuables = new ArrayList<>();
    }

    public boolean addValuable(Valuable valuable){

        try{
            if(isBroken())
                throw new Exception("fail: the pig is broken");

            if(this.getVolume() + valuable.getVolume() > this.getVolumeMax())
                throw new Exception("fail: the pig is full");

            this.valuables.add(valuable);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean breakPig(){

        try{
            if(this.isBroken())
                throw new Exception("fail: o cofre já está quebrado");

            this.broken = true;

            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }

    public List<Coin> getCoins() throws Exception{


        if(!isBroken())
            throw new MustBreakThePig();

        List<Coin> coins = new ArrayList<>();

        for(Valuable valuable : this.valuables){
            if(valuable instanceof Coin){
                coins.add((Coin)valuable);
                
            }
        }
        
        this.valuables.removeAll(coins);

        return coins;

    }

    public List<Item> getItems() throws Exception{

        
        if(!isBroken())
            throw new MustBreakThePig();

        List<Item>  items = new ArrayList<>();

        for(Valuable valuable : this.valuables){
            if(valuable instanceof Item){
                items.add((Item)valuable);
            }
        }
        
        this.valuables.removeAll(items);

        return items;
    

    }

    public double calcValue(){

        double value = 0.0;

        for(Valuable valuable : this.valuables){
            value += valuable.getValue();
        }

        return value;
    }

    public int getVolumeMax(){
        return this.volumeMax;
    }

    public int getVolume(){
        int volume = 0;

        for(Valuable valuable : this.valuables){
            volume += valuable.getVolume();
        }

        return volume;
    }

    public boolean isBroken(){
        return this.broken;
    }

    @Override
    public String toString(){

        String valuables = Utils.arrayToString(this.valuables);
//
//        Iterator it = this.valuables.iterator();
//
//        while(it.hasNext()){
//            valuables += it.next();
//            valuables += (it.hasNext()) ? ", " : "";
//        }

        DecimalFormat df = new DecimalFormat("0.00");
        
        String status = "intact";
        int volume = this.getVolume();
        
        if(this.isBroken()){
            status = "broken";
            volume = 0;
        }
        

        return String.format(
                "[%s] : %s$ : %d/%d : %s",
                valuables,
                df.format(this.calcValue()),
                volume,
                this.getVolumeMax(),
                status
        );
    }




}
