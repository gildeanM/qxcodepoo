public class STA extends Funcionario{
    protected int nivel;

    public STA(String nome, int nivel){
        super(nome);
        this.nivel = nivel;
    }
    public int getNivel(){
        return this.nivel;
    }

    public void addDiaria(){
        super.setMaxDiarias(1);
        super.addDiaria();
    }

    public int getSalario(){

        int adicional = super.getSalario();
        int salario = 3000 + this.nivel*300;

        return salario + adicional;
    }

    @Override
    public String toString(){
        return String.format(
                "sta:%s:%s:%d",
                super.getNome(),
                this.getNivel(),
                this.getSalario()
        );
    }
}
