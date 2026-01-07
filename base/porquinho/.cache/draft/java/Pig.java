
import java.util.ArrayList;

class Pig{
    
    private boolean broken;
    private ArrayList<Coin> coins;
    private ArrayList<Item> items;
    private int volumeMax;
    
    public Pig(int volumeMax){
        
        this.broken = false;
        this.coins = new ArrayList<>();
        this.items = new ArrayList<>();
        this.volumeMax = volumeMax;
        
    }
    
    public boolean addCoin(Coin coin){
        
        try{
            
            if(this.isBroken())
                throw new BrokenPigException();
            
            if(this.getVolume() + coin.getVolume() > this.getVolumeMax())
                throw new FullPigException();
                
            
            this.coins.add(coin);
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean addItem(Item item){
        try{
            
            if(this.isBroken())
                throw new BrokenPigException();
            
            if(this.getVolume() + item.getVolume() > this.getVolumeMax())
                throw new FullPigException();
                
            
            this.items.add(item);
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean breakPig(){
        
        try{
            
            if(this.isBroken())
                throw new PigAlreadyBrokenException();
            
            this.broken = true;
            return true;
            
        }catch(PigAlreadyBrokenException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ArrayList<Coin> extractCoins(){
        
        try{
            
            if(!this.isBroken())
                throw new BreakPigFirstException();
            
            ArrayList<Coin> coinsRemoved = this.coins;
            this.coins = new ArrayList<>();
            
            return coinsRemoved;
        
        }catch(BreakPigFirstException e){
            System.out.println(e.getMessage());
            return new ArrayList<Coin>();
        }
    }
    
    public ArrayList<Item> extractItems(){
        try{
            
            if(!this.isBroken())
                throw new BreakPigFirstException();
            
            ArrayList<Item> itemsRemoved = this.items;
            this.items = new ArrayList<>();
            
            return itemsRemoved;
        
        }catch(BreakPigFirstException e){
            System.out.println(e.getMessage());
            return new ArrayList<Item>();
        }
    }
    
    @Override
    public String toString(){
        
        String state = (this.isBroken()) ? "broken" : "intact";
        
        String coins = "";
        
        for(int i = 0; i < this.coins.size(); i++){
            coins += (i != 0) ? ", " : "";
            coins += this.coins.get(i);
        }
        
        String items = "";
        
        for(int i = 0; i < this.items.size(); i++){
            items += (i != 0) ? ", " : "";
            items += this.items.get(i);
        }
        
        
        return String.format("state=%s : coins=[%s] : items=[%s] : value=%.2f : volume=%d/%d",
            state,
            coins,
            items,
            this.getValue(),
            this.getVolume(),
            this.getVolumeMax()
        );
    }
 
    public int getVolume(){
        
        if(this.isBroken())
            return 0;
        
        int volume = 0;
        
        for(Coin coin : coins){
            volume += coin.getVolume();
        }
        
        for(Item item : items){
            volume += item.getVolume();
        }
        
        return volume;
        
    }
    
    public Double getValue(){
        
        double value = 0;
        
        for(Coin coin : coins){
            value += coin.getValue();
        }
        
        return value;
    }
    
    public int getVolumeMax(){
        return this.volumeMax;
    }
    
    public boolean isBroken(){
        return this.broken;
    }
    
}