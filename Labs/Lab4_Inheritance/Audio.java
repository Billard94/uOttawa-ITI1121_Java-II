public class Audio extends MediaDocument {

    private int rating;

    public Audio( String name, String owner, int duration, int rating ) {
        super( name, owner, duration );
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

}
