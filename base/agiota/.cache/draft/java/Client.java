import java.util.ArrayList;

class Client {
    private String name;
    private int limite;
    private ArrayList<Operation> operations;

    public Client(String name, int limite) {
        this.name = name;
        this.limite = limite;
        this.operations = new ArrayList<>();
    }

    @Override
    public String toString() {
        String ss = this.name + " " + this.getBalance() + "/" + this.limite + "\n";
        for ( Operation oper : this.operations ) {
            ss += oper + "\n";
        }
        return ss;
    }

    public String getName() {
        return this.name;
    }
    public int getLimite() {
        return this.limite;
    }
    
    public ArrayList<Operation> getOperations() {
        return this.operations;
    }

    public void addOperation(Operation operation) {
        this.operations.add( operation );
    }
    //quanto esta devendo
    public int getBalance() {
        int saldo = 0;
        for(Operation oper : this.operations){
            if(oper.getLabel().equals(Label.GIVE)){
                saldo += oper.getValue();
            }else if(oper.getLabel().equals(Label.TAKE)){
                saldo -= oper.getValue();
            }else if(oper.getLabel().equals(Label.PLUS)){
                saldo += oper.getValue();    
            }
            
            
        }
        
        return saldo;
    }
}
