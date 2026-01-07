public class Moto extends Veiculo{

    public Moto(String id){
        super("Moto", id);
    }

    @Override
    public void calcularValor(int horaSaida){
        int qtdMinutos = (horaSaida - this.horaEntrada);
        Double value =  qtdMinutos/20.0;

        System.out.println(String.format("%s chegou %d saiu %d. Pagar R$ %.2f",
            this.tipo,
            this.horaEntrada,
            horaSaida,
            value
        ));
    }

}
