public class Carro extends Veiculo{

    public Carro(String id){
        super("Carro", id);
    }

    @Override
    public void calcularValor(int horaSaida){
        int qtdMinutos = (horaSaida - this.horaEntrada);
        Double value =  qtdMinutos/10.0;
        if(value < 5.00)
            value = 5.00;

        System.out.println(String.format("%s chegou %d saiu %d. Pagar R$ %.2f",
                this.tipo,
                this.horaEntrada,
                horaSaida,
                value
        ));
    }

}
