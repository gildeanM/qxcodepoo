
class FullPigException extends Exception{
     
     @Override
     public String getMessage(){
         return "fail: the pig is full";
     }
     
}