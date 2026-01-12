import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class UFC {

    private Map<String, Funcionario> funcionarios;
    private Map<String, Aluno> alunos;

    public UFC(){
        this.funcionarios = new TreeMap<String, Funcionario>();
        this.alunos = new TreeMap<String, Aluno>();
    }

    private String listUsuarios(Iterator it){
        StringBuilder list = new StringBuilder();
        
        while(it.hasNext()){
            list.append(it.next());
            list.append("\n");
        }
        return list.toString();
    }

    @Override
    public String toString(){

        
        String funcionarios = this.listUsuarios(this.funcionarios.values().iterator());
        String alunos = this.listUsuarios(this.alunos.values().iterator());
        
        return String.format(
                "%s%s", 
                funcionarios,
                alunos
        );
    }

    public Funcionario getFuncionario(String nome){
        return funcionarios.get(nome);
    }
    public void addFuncionario(Funcionario funcionario){
        
        if(this.funcionarios.get(funcionario.getNome()) != null)
            throw new MsgException("fail: funcionario já existe");

        this.funcionarios.put(funcionario.getNome(), funcionario);

    }

    public void rmFuncionario(String nome){
        
        var funcRemoved = this.getFuncionario(nome);

        if(funcRemoved == null)
            throw new MsgException("fail: funcionario inexistente");

        this.funcionarios.remove(nome);
        
    }
    //reparte o bonus para todos os funcionarios
    public void setBonus(int bonus){
        var qtdFuncionarios = this.funcionarios.size();
        var bonusFuncionario = bonus/qtdFuncionarios;

        for(Funcionario func : this.funcionarios.values()){
            func.setBonus(bonusFuncionario);
        }

    }

    public Aluno getAluno(String nome){
        return this.alunos.get(nome);
    }
    public void addAluno(Aluno aluno){
        
        if(this.alunos.get(aluno.getNome()) != null)
            throw new MsgException("fail: aluno já existe");

        this.alunos.put(aluno.getNome(), aluno);
        

    }

    public void rmAluno(String nome){
        
        if(this.getAluno(nome) == null)
            throw new MsgException("fail: aluno inexistente");

        this.alunos.remove(nome);
        
    }


}
