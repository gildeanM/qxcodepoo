public class VeiculoInexistenteException extends Exception {
    private boolean exist;

    public VeiculoInexistenteException(boolean exist){
        this.exist = exist;
    }

    @Override
    public String getMessage(){
        if(exist){
            return "fail: veiculo já existe no estacionamento";
        }else{
            return "fail: veiculo não existe no estacionamento";
        }
    }
}
