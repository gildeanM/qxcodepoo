
public enum Label{
    
    GIVE("give"),
    TAKE("take"),
    PLUS("plus");
    
    private String description;
    
    public String getDescription(){
        return this.description;
    }
    
    Label(String description){
        this.description = description;
    }
    
    @Override
    public String toString(){
        return this.description;
    }
    
    
    
    
}