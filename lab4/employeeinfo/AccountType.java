package employeeinfo;

public enum AccountType {
    CHECKING(0),
    SAVINGS(1),
    RETIREMENT(2);
    public final int type;

    AccountType(int type) {
        this.type = type;
    }
}
