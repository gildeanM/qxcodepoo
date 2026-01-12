public class MsgException extends RuntimeException{

    private String message;
    public MsgException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
