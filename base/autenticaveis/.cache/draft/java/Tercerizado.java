public class Tercerizado extends Funcionario{

    protected int horas;
    protected boolean isSalubre = false;

    public Tercerizado(String nome, int horas, String isSalubre){
        super(nome);
        this.horas = horas;
        this.isSalubre = isSalubre.equalsIgnoreCase("sim");
    }
    public int getHoras(){
        return this.horas;
    }
    public String getIsSalubre(){
        return (this.isSalubre ? "sim" : "não");
    }

    @Override
    public int getSalario(){

        int adicional = super.getSalario();
        int salario = 4*this.horas + (this.isSalubre ? 500 : 0);

        return salario + adicional;
    }
    @Override
    public void addDiaria(){
        throw new MsgException("fail: terc nao pode receber diaria");
    }

    @Override
    public String toString(){
        return String.format(
                "ter:%s:%s:%s:%d",
                super.getNome(),
                this.getHoras(),
                this.getIsSalubre(),
                this.getSalario()
        );
    }

}
