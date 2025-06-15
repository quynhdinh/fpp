package lab12.prog2.employeeinfo;

import lab12.prog2.OverdrawnAccountException;

public class RetirementAccount extends Account {
	private final double PENALTY_PERCENT = 2.0;

	RetirementAccount(Employee e, double startBalance) {
		super(e, startBalance);
	}

	RetirementAccount(Employee e) {
		super(e);
	}

	@Override
	void makeWithdrawal(double amount) throws OverdrawnAccountException {
		double totalAmount = amount;
		totalAmount += PENALTY_PERCENT / 100 * super.getBalance();
		if (totalAmount > super.getBalance()) {
			throw new OverdrawnAccountException("After computing penalties, your withdrawal amount exceeds your balance.");
		}
		setBalance(super.getBalance() - totalAmount);
	}

	public AccountType getAcctType() {
		return AccountType.RETIREMENT;
	}

}