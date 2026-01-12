public class Professor extends Funcionario{

    protected String classe;
    //inicializa classe e muda maxDiarias para 2
    public Professor(String nome, String classe){
        super(nome);
        this.classe = classe;
    }
    public String getClasse(){
        return this.classe;
    }

    public void addDiaria(){
        super.setMaxDiarias(2);
        super.addDiaria();
    }

    //lógica do salário do professor
    //usa o super.getSalario para pegar bonus e diarias
    public int getSalario(){

        int adicional = super.getSalario();
                int salario = 0;

        switch (this.classe){
            case "A" : salario = 3000; break;
            case "B" : salario = 5000; break;
            case "C" : salario = 7000; break;
            case "D" : salario = 9000; break;
            case "E" : salario = 11000; 
        }

        return salario + adicional;
    }

    @Override
    public String toString(){
        return String.format(
            "prof:%s:%s:%d",
                super.getNome(),
                this.classe,
                this.getSalario()
        );
    }

}
