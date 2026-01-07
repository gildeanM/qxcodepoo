

import java.text.DecimalFormat;

abstract class Account {

    protected static int nextAccountId = 0;
    protected Double balance;
    protected int accId;
    protected String clientId;
    protected String typeId;

    public Account(int accId, String clientId, String typeId){
        this.accId = accId;
        this.clientId = clientId;
        this.typeId = typeId;
        this.balance = 0.0;
    }

    public void deposit(Double value) throws Exception{
        this.balance += value;
    }
    public void withdraw(Double value) throws Exception{
        this.balance -= value;

    }
    public void transfer(Account other, Double value) throws Exception{

        this.withdraw(value);
        other.deposit(value);

    }

    public abstract void updateMonthly();

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("0.00");
        return String.format("%d:%s:%s:%s\n",
                this.accId,
                this.clientId,
                df.format(this.balance),
                this.typeId
        );
    }

    public Double getBalance() {
        return balance;
    }

    public int getAccId() {
        return accId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getTypeId() {
        return typeId;
    }

}
