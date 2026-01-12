public abstract class Funcionario {

    protected String nome;
    protected int bonus;
    protected int diarias;
    protected int maxDiarias;

    public Funcionario(String nome){
        this.nome = nome;
    };
    public String getNome(){
        return this.nome;
    };
    public void setBonus(int bonus){
        this.bonus = bonus;
    }


    //se não atingiu o máximo, adicione mais uma diária
    //se atingiu o máximo, lance uma MsgException
    public void addDiaria(){
        if(this.diarias + 1 > this.maxDiarias)
            throw new MsgException("fail: limite de diarias atingido");
        this.diarias++;
    }
    //retorna bonus + diarias * 100
    public int getSalario(){
        int salario = this.bonus + this.diarias*100;
        return salario;
    };

}
