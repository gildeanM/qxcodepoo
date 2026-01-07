
class PigAlreadyBrokenException extends Exception{
    
     @Override
     public String getMessage(){ 
         return "fail: the pig is already broken";
     }
     
}