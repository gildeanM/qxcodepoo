public class TempoInvalidoException extends Exception {

    @Override
    public String getMessage(){
        return "fail: o tempo deve ser um inteiro positivo";
    }

}
