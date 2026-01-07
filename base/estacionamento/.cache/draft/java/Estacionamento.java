import java.util.ArrayList;

public class Estacionamento {

    private ArrayList<Veiculo> veiculos;
    private int horaAtual;

    public Estacionamento(){
        this.veiculos = new ArrayList<>();
        this.horaAtual = 0;
    }

    private int procurarVeiculo(String id){


        int idxVeiculo = -1;

        for(Veiculo v : veiculos){
            if(v.getId().equals(id)){
                idxVeiculo = veiculos.indexOf(v);
                break;
            }
        }


        return idxVeiculo;

    }

    public void estacionar(Veiculo veiculo){

        try{
            int idxVeiculo = this.procurarVeiculo(veiculo.getId());
            if(idxVeiculo != -1)
                throw new VeiculoInexistenteException(true);

            veiculo.setHoraEntrada(this.horaAtual);
            veiculos.add(veiculo);
        }catch (VeiculoInexistenteException e ){
            System.out.println(e.getMessage());
        }

    }

    public void pagar(String id) throws Exception{

        int idxVeiculo = this.procurarVeiculo(id);
        if(idxVeiculo == -1)
            throw new VeiculoInexistenteException(false);

        veiculos.get(idxVeiculo).calcularValor(this.horaAtual);

    }

    public void sair(String id) throws Exception{

            int idxVeiculo = this.procurarVeiculo(id);
            if(idxVeiculo == -1)
                throw new VeiculoInexistenteException(false);

            veiculos.remove(idxVeiculo);
    }

    public void passarTempo(int tempo) throws TempoInvalidoException{

        if(tempo < 0)
            throw new TempoInvalidoException();

        this.horaAtual += tempo;
    }

    @Override
    public String toString(){

        String veiculos = "";

        for(Veiculo veiculo : this.veiculos){
            veiculos += veiculo;
            veiculos += "\n";
        }
        return String.format("%sHora atual: %d", veiculos, this.horaAtual);
    }

}
