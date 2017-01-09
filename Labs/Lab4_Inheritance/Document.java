public class Document {

    private static int lastIndexNumber = 100;
    private int iNumber;

    private String name;
    private String owner;

    public Document( String name, String owner ) {
        iNumber = lastIndexNumber++;
        this.name = name;
        this.owner = owner;
    }

    public int getIndexNumber() {
        return iNumber;
    }

    public String getName() {
        return name;
    }
    
    public void rename( String name ) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void changeOwner( String owner ) {
        this.owner = owner;
    }

    public boolean equals( Document other ) {

        return iNumber == ( (Document) other ).iNumber;
    }

    public String toString() {
        return "iNumber = " + iNumber + "; name = " + name + "; owner = " + owner;
    }

}
