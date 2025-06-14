package lab12.prog2.employeeinfo;

public class RetirementAccount extends Account {
	private final double PENALTY_PERCENT = 2.0;

	RetirementAccount(Employee e, double startBalance) {
		super(e, startBalance);
	}

	RetirementAccount(Employee e) {
		super(e);
	}

	public AccountType getAcctType() {
		return AccountType.RETIREMENT;
	}

}
