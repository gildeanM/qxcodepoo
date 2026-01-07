

public class CheckingAccount extends Account{

    protected Double monthlyFee;

    public CheckingAccount(int accId, String clientId) {
        super(accId, clientId, "CC");
        this.monthlyFee = 20.0;
    }

    @Override
    public void updateMonthly(){
        try{
            this.withdraw(this.monthlyFee);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
