public class STA extends FuncionarioAutenticavel{
    protected int nivel;

    public STA(String nome, int nivel){
        super(nome);
        this.nivel = nivel;
        this.maxDiarias = 1;
    }
    public int getNivel(){
        return this.nivel;
    }

    @Override
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
