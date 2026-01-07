public abstract class Veiculo {

    private String id;
    protected String tipo;
    protected int horaEntrada;

    public Veiculo(String tipo, String id){
        this.tipo = tipo;
        this.id = id;
    }

    public abstract void calcularValor(int horaSaida);

    @Override
    public String toString() {
        return String.format(
                "%10s-:-%10s-:-%s", //alinhar a direita 10 caracteres inserindo espaços
                this.tipo,
                this.id,
                this.horaEntrada
        )
        .replace(' ', '_') //substituir espaço por underline
        .replace('-', ' '); //substituir hífen por espaço
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

}
