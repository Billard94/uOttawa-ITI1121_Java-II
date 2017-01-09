public abstract class PostalCode {

    private String code;

    public PostalCode( String code ) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public abstract boolean isValid();

}
