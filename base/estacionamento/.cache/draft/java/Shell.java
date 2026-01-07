import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class Shell {

    public static void main(String[] a) {

        Estacionamento estacionamento = new Estacionamento();
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("show")) {
                System.out.println(estacionamento);
            }
            else if (cmd.equals("init")) {
                estacionamento = new Estacionamento();
            }
            else if (cmd.equals("estacionar")) {
                 var tipo = par[1];
                 var id = par[2];

                 Veiculo veiculo = null;

                 if(tipo.equalsIgnoreCase("Bike")){
                     veiculo = new Bike(id);
                 }else if(tipo.equalsIgnoreCase("Moto")){
                     veiculo = new Moto(id);
                 }else if(tipo.equalsIgnoreCase("Carro")){
                     veiculo = new Carro(id);
                 }

                 estacionamento.estacionar(veiculo);
            }
            else if (cmd.equals("pagar")) {
                // CHAME OS METODOS DE PAGAMENTO E SAIDA
                 var veiculo = par[1];

                 try{
                     estacionamento.pagar(veiculo);
                     estacionamento.sair(veiculo);
                 }catch(Exception e){
                     System.out.println(e.getMessage());
                 }

            }
            else if (cmd.equals("tempo")) {
                 var tempo = Integer.parseInt(par[1]);

                 try{
                     estacionamento.passarTempo(tempo);
                 }catch (Exception e){
                     System.out.println(e.getMessage());
                 }

            }
            else {
                System.out.println("fail: comando inválido");
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
}