import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Comparador implements Comparator<Client> {
    public int compare(Client c1, Client c2) {
        return c1.getName().compareTo(c2.getName());
    }
}

class Agiota {
    private ArrayList<Client> aliveList;
    private ArrayList<Client> deathList;
    private ArrayList<Operation> aliveOper;
    private ArrayList<Operation> deathOper;
    private int nextOpId;

    private int searchClient(String name) {
        
        // this.sortAliveList();
        
        int idxClient = -1;
        
        for(Client client : this.aliveList){
            if(client.getName().equals(name)){
                idxClient = this.aliveList.indexOf(client);
                break;
            }
        }
        
        return idxClient;
        
    }
    
    private void pushOperation(Client client, String name, Label label, int value) {
        Operation oper = new Operation( this.nextOpId, name, label, value );
        this.aliveOper.add( oper );
        client.addOperation( oper );
        ++this.nextOpId;
        
    }

    private void sortAliveList() {
        // this.aliveList.sort(); //para inteiros
        // Collections.sort (this.aliveList); //para inteiros

        // this.aliveList.sort( new Comparator<Client>() {
        //     public int compare(Client c1, Client c2) {
        //         return c1.getName().compareTo(c2.getName());
        //         // if (c1.getLimite() < c2.getLimite()) return -1;
        //         // else if (c1.getLimite() > c2.getLimite()) return 1;
        //         // else return 0;
        //     }
        // });

        // Collections.sort (this.aliveList, new Comparator<Client>() {
        //     public int compare(Client c1, Client c2) {
        //         return c1.getName().compareTo(c2.getName());
        //     }
        // });

        Collections.sort (this.aliveList, new Comparador());
    }

    public Agiota() {
        
        this.aliveList = new ArrayList<>();
        this.deathList = new ArrayList<>();
        this.aliveOper = new ArrayList<>();
        this.deathOper = new ArrayList<>();
        this.nextOpId = 0;
        
    }
    

    public Client getClient(String name) {
        int idxClient = this.searchClient(name);
        Client client = this.aliveList.get(idxClient);
        return client;
    }

    public void addClient(String name, int limite) throws Exception {
        
        
        try{
            
            int idxClient = this.searchClient(name);
            
            if(idxClient != -1)
                throw new ClienteException(true);
                
            Client newClient = new Client( name, limite );
            this.aliveList.add(newClient);
            
        }catch(ClienteException e){
            IO.println(e.getMessage());
        }
        
    }

    public void give(String name, int value) throws Exception {
        try{
            int idxClient = this.searchClient(name);
            
            if(idxClient == -1)
                throw new ClienteException(false);
            
            Client operClient = this.aliveList.get(idxClient);
            int clientBalance = operClient.getBalance();
            int clientLimite = operClient.getLimite();
            
            if(clientBalance + value > clientLimite)
                throw new LimiteExcedidoException();
            
            this.pushOperation(operClient, name, Label.GIVE, value);
            
        }catch(Exception e){
            IO.println(e.getMessage());
        }
    }

    public void take(String name, int value) throws Exception {
        try{
            int idxClient = this.searchClient(name);
            
            if(idxClient == -1)
                throw new ClienteException(false);
                
            Client operClient = this.aliveList.get(idxClient);
            this.pushOperation(operClient, name, Label.TAKE, value);
            
            if(operClient.getBalance() > operClient.getLimite()){
                this.kill(operClient.getName());
            }
            
        }catch(ClienteException e){
            IO.println(e.getMessage());
        }
        
    }

    public void kill(String name) {
        try{
            int idxClient = this.searchClient(name);
            
            if(idxClient == -1)
                throw new ClienteException(false);
                
            
            Client clientKilled = this.aliveList.get(idxClient);
            
            this.deathList.add(clientKilled);
            this.aliveList.remove(clientKilled);
            
            
            for (int i=0; i<this.aliveOper.size(); i++) {
                Operation oper = this.aliveOper.get(i);
                if(oper.getClientName().equals(name)){
                    this.deathOper.add(oper);
                    this.aliveOper.remove(oper);
                    i--;
                }
            }
            
            // for(Operation oper : this.aliveOper){
            //     if(oper.getClientName().equals(name)){
            //         this.deathOper.add(oper);
            //         this.aliveOper.remove(oper);
                    
            //     }
            // }
        }catch(ClienteException e){
            IO.println(e.getMessage());
        }
        
    }

    public void plus() {
            for (Client client : this.aliveList) {
                this.pushOperation( client, client.getName(), Label.PLUS, (int) Math.ceil( 0.1*client.getBalance() ) );
            }
            
            // for (Client client : this.aliveList) {
            //     if ( client.getBalance() > client.getLimite() ) {
            //         this.kill( client.getName() );
            //     }
            // }
            for (int i=0; i<this.aliveList.size(); i++) {
                Client client = this.aliveList.get(i);
                if ( client.getBalance() > client.getLimite() ) {
                    this.kill( client.getName() );
                    i--;
                }
            }
    }

    @Override
    public String toString() {
        this.sortAliveList();
        String ss = "";
        for ( Client client : this.aliveList ) {
            ss += ":) " + client.getName() + " " + client.getBalance() + "/" + client.getLimite() + "\n";
        }
        for ( Operation oper : this.aliveOper ) {
            ss += "+ " + oper + "\n";
        }
        for ( Client client : this.deathList ) {
            ss += ":( " + client.getName() + " " + client.getBalance() + "/" + client.getLimite() + "\n";
        }
        for ( Operation oper : this.deathOper ) {
            ss += "- " + oper + "\n";
        }
        return ss;
    }
}
