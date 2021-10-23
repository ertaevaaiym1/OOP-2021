package OOP;
import java.math.BigDecimal; 
public class Account {
    protected String number;
	protected String status;
	protected Client owner;
	protected BigDecimal balance;
	protected String[] operations;
	protected int opIndex; 

	public Account(String number, String status, Client owner, BigDecimal balance){
		this.number = number;
		
		if (status == null || !"1".equals(status) && !"2".equals(status)){
			throw new IllegalArgumentException("Invalid status!");
		}

		this.status = status;
		this.owner = new Client(owner.getName(), owner.getPhone(), owner.getId());
		
		if (balance == null || balance.compareTo(BigDecimal.ZERO) < 0){
			throw new IllegalStateException("Not enough cash");
		}

		this.balance = balance;
		this.operations = new String[100];
	}

	public Client getOwner(){
		System.out.println("Inside bankaccount " + owner.getName());
		return new Client(owner.getName(), owner.getPhone(), owner.getId());
	}

	public String getNumber(){
		return number;
	}

	public String getStatus(){
		return status;
	}

	public void setStatus(String status){
		if (status == null || !"1".equals(status) && !"2".equals(status)){
			throw new IllegalArgumentException("Invalid status!");
		}
		this.status = status;
	}

	public String getBalance(){
		return balanceBuilder();
	}

	protected String balanceBuilder(){
		return "Your balance is " + balance.toString();
	}

	public void credit(BigDecimal amount){
		balance = balance.add(amount);
		operations[opIndex] = "Credit " + amount.toString();
		opIndex++;
	}

	public void debit(BigDecimal amount){
		BigDecimal newBalance = balance.subtract(amount);

		if (newBalance.compareTo(BigDecimal.ZERO) < 0){
			throw new IllegalStateException("Not enough cash");
		}

		balance = newBalance;

		operations[opIndex] = "Debit " + amount.toString();
		opIndex++;
	}
	

	public void paymentForService(){
		BigDecimal newBalance = balance.subtract(new BigDecimal("2000.00"));
		balance = newBalance;
	}

	public void getStatement(){
		StringBuilder sb = new StringBuilder();
		sb.append("Account statement\n");
		for (String statement : operations) {
			if (statement == null) {
				break;
			}
			sb.append(statement).append("\n");
		}
		System.out.println(sb);
	}
}
