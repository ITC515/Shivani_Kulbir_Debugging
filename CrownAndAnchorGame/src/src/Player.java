
public class Player {
	private String name;
	private int balance;
	private int limit;
	
	public Player(String name, int balance) {
		if (name == null || name .isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
		if (balance < 0) throw new IllegalArgumentException("Balance cannot be negative");
		this.name = name;
		this.balance = balance;
		this.limit = 0;
	}
		
	public String getName() { return name; }
	public int getBalance() {return balance; }
	public int getLimit() {return limit; }
	
	public void setLimit(int limit) {
		if (limit < 0) throw new IllegalArgumentException("Limit cannot be negative.");
		if (limit > balance)  throw new IllegalArgumentException("Limit cannot be greater than balance.");
		this.limit = limit;
		
	}

	public boolean balanceExceedsLimit() {
		
		return (balance > limit);
		
	}
	
	public boolean balanceExceedsLimitBy(int amount) {
		return (balance - amount >= limit );
		//this is the corrected code for second error
		//when balance is 5,amount is 5, and limit is 0, code does not work
	}
	
	public void takeBet(int bet) {
		if (bet < 0) throw new IllegalArgumentException("Bet cannot be negative.");
		if (!balanceExceedsLimitBy(bet)) throw new IllegalArgumentException("Placing bet would go below limit.");
		balance = balance - bet;
	//this method is created bug, even if player wins the balance is already reduced by 5 
		//thats why in that output one win does not affect to the balance of the player
		
	}
	
	public void receiveWinnings(int winnings) {
		if (winnings < 0) throw new IllegalArgumentException("Winnings cannot be negative.");
		balance = balance + winnings;
	}
	
	
	public String toString() {
		return String.format("Player: %s, Balance: %d, Limit: %d", name, balance, limit);
	}
}
