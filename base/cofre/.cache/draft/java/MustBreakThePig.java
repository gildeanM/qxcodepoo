
class MustBreakThePig extends Exception{
    
    @Override
    public String getMessage(){
        return "fail: you must break the pig first";
    }
    
}