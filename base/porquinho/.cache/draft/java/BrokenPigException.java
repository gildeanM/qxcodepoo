
class BrokenPigException extends Exception{
    
     @Override
     public String getMessage(){
         return "fail: the pig is broken";
     }
     
}