package employeeinfo;

public enum AccountType {
    CHECKING("checking"),
    SAVINGS("savings"),
    RETIREMENT("retirement");
    public final String type;

    AccountType(String type) {
        this.type = type;
    }
}
