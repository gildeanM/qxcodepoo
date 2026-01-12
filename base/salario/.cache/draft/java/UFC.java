import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class UFC {

    private Map<String, Funcionario> funcionarios = new TreeMap<>();

    public String toString(){

        StringBuilder funcionarios = new StringBuilder();

        Iterator it = this.funcionarios.values().iterator();

        while(it.hasNext()){
            funcionarios.append(it.next());
            if(it.hasNext())
                funcionarios.append("\n");
        }

        return String.format("%s", funcionarios);
    }

    public Funcionario getFuncionario(String nome){
        return funcionarios.get(nome);
    }
    public void addFuncionario(Funcionario funcionario){

        try{
            if(this.funcionarios.get(funcionario.getNome()) != null)
                throw new MsgException("fail: funcionario já existe");

            this.funcionarios.put(funcionario.getNome(), funcionario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void rmFuncionario(String nome){

        try{
            var funcRemoved = this.getFuncionario(nome);

            if(funcRemoved == null)
                throw new MsgException("fail: funcionario inexistente");

            this.funcionarios.remove(nome);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    //reparte o bonus para todos os funcionarios
    public void setBonus(int bonus){
        var qtdFuncionarios = this.funcionarios.size();
        var bonusFuncionario = bonus/qtdFuncionarios;

        for(Funcionario func : this.funcionarios.values()){
            func.setBonus(bonusFuncionario);
        }

    }

}
