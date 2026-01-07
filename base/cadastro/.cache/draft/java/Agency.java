

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Agency {

    private Map<Integer, Account> accounts;
    private Map<String, Client> clients;

    public Agency() {
        this.accounts = new HashMap<Integer,Account>();
        this.clients = new LinkedHashMap<String,Client>();
    }

    private Account getAccount(int accountId) throws Exception{
        Account acc = this.accounts.get(accountId);
        if(!this.accounts.containsKey(accountId))
            throw new Exception("fail: conta nao encontrada");

        return this.accounts.get(accountId);
    }

    public void addClient(String clientId){

        var client = new Client(clientId);

        var cc = new CheckingAccount(Account.nextAccountId++, clientId);
        var cp = new SavingsAccount(Account.nextAccountId++, clientId);

        this.accounts.put(cc.accId, cc);
        client.addAccount(cc);

        this.accounts.put(cp.accId, cp);
        client.addAccount(cp);

        this.clients.put(clientId, client);

    }

    public void deposit(int accId, Double value) throws Exception{

        var account = this.getAccount(accId);
        if(value < 0)
            throw new Exception("fail: valor invalido para deposito");
        account.deposit(value);

    }
    public void withdraw(int accId, Double value) throws Exception{

        var account = this.getAccount(accId);
        
        if(account.getBalance() - value <= 0)
            throw new Exception("fail: saldo insuficiente");

        account.withdraw(value);

    }

    public void transfer(int fromAccId, int toAccId, Double value) throws Exception{
        
        var fromAcc = this.getAccount(fromAccId);
        var toAcc = this.getAccount(toAccId);
        fromAcc.transfer(toAcc, value);
        
    }

    public void updateMonthly(){
        for(Account acc : this.accounts.values()){
            acc.updateMonthly();
        }
    }

    @Override
    public String toString(){
        String s = "- Clients\n";
        for ( Client client : this.clients.values() ) {
            s += client;
        }
        s += "- Accounts\n";
        for ( Account acc : this.accounts.values() ) {
            s += acc;
        }
        return s;
    }

}
