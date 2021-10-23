class Bank {
    private String name;
    private Client[] clients;
    private BankAccount[] accounts;
    private BankClient[] bankclients;
    private int accountsCount;
    private int clientsCount;
    private int n = 3;
    
    Bank(String name) {
        this.name = name;
        this.clients = new Client[n];
        this.bankclients = new BankClient[n];
        this.accounts = new BankAccount[n];
    }
    public void createBankClient(BankClient bankClient) {
        if (this.clientsCount < this.n) {
            this.bankclients[this.clientsCount] = bankClient;
            this.clientsCount++;    
        } else {
            System.out.println("Bank has too many clients");
        }

    }

    public void createBankAccount(BankAccount bankAccount) {
        if (this.accountsCount < this.n) {
            this.accounts[this.accountsCount] = bankAccount;
            this.accountsCount++;    
        } else {
            System.out.println("Bank has too many accounts");
        }

 

    }
    public String countClient() {
        return "Client count: " + this.clientsCount;
    }
    public String countAccounts() {
        return "Accounts count: " + this.accountsCount;
    }
}
