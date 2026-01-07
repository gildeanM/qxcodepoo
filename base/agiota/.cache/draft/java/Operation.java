class Operation {
    private int id;
    private String clientName;
    private Label label;
    private int value;

    public Operation( int id, String clientName, Label label, int value ) {
        this.id = id;
        this.clientName = clientName;
        this.label = label;
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "id:" + this.id + " " + this.label + ":" + this.clientName + " " + this.value;
    }

    public int getId() {
        return this.id;
    }
    public String getClientName() {
        return this.clientName;
    }
    public Label getLabel() {
        return this.label;
    }
    public int getValue() {
        return this.value;
    }
}
