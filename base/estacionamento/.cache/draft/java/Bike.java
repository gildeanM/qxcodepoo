public class Bike extends Veiculo{

    public Bike(String id) {
        super("Bike", id);
    }

    @Override
    public void calcularValor(int horaSaida) {
        System.out.println(
            String.format("%s chegou %d saiu %d. Pagar R$ %.2f",
            this.tipo,
            this.horaEntrada,
            horaSaida,
            3.0
        ));
    }
}
