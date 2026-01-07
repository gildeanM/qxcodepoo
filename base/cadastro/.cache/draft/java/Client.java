
import java.util.ArrayList;
import java.util.List;

public class Client {

    protected String clientId;
    protected List<Account> accounts;

    public Client(String clientId) {
        this.clientId = clientId;
        this.accounts = new ArrayList<Account>();
    }

    public void addAccount(Account account){
        this.accounts.add(account);
    }

    public List<Account> getAccounts(){
        return this.accounts;
    }

    public String getClientId(){
        return this.clientId;
    }

    @Override
    public String toString(){

        StringBuilder accounts = new StringBuilder();

        for(int i = 0; i < this.accounts.size(); i++){
            accounts.append(this.accounts.get(i).accId);
            if(i < this.accounts.size() - 1)
                accounts.append(", ");
        }

        return String.format("%s [%s]\n", this.clientId, accounts);
    }

}
