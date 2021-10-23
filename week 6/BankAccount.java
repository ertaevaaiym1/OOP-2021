class BankAccount{
    private String number;
    private String status;
    private Client client;
    
    BankAccount(String number, Client client) {
        this.number = number;
        this.status = "active";
        this.client = client;
    }
    
    public String getNumber() {
        return this.number;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public Client getClient() {
        return this.client;
    }
    
    public void setStatus(String newStatus) {
        this.status = newStatus;
    }
   
}