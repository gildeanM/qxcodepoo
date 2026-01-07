
public class SavingsAccount extends Account{

    protected Double monthlyInterest;

    public SavingsAccount(int accId, String clientId) {
        super(accId, clientId, "CP");
        this.monthlyInterest = 0.01;
    }

    @Override
    public void updateMonthly(){
        try{
            double saldo = this.getBalance()*this.monthlyInterest;
            super.deposit(saldo);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
