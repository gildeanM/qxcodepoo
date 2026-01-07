
class Coin { 
    
    private Double value;
    private int volume;
    private String label;
    
    public static Coin C10 = new Coin(0.10, 1, "C10");
    public static Coin C25 = new Coin(0.25, 2, "C25");
    public static Coin C50 = new Coin(0.50, 3, "C50");
    public static Coin C100 = new Coin(0.100, 4, "C100");
    
    
    private Coin(Double value, int volume, String label){
        this.value = value;
        this.volume = volume;
        this.label = label;
    }
    
    public Double getValue(){
        return this.value;
    }
    
    public int getVolume(){
        return this.volume;
    }
    
    public String getLabel(){
        return this.label;
    }
    
    @Override
    public String toString(){
        return String.format("%.2f:%d", this.value, this.volume);
    }
    
    
}