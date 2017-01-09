public class Movie extends MediaDocument {

    private int story;
    private int acting;

    public Movie( String name, String owner, int duration, int story, int acting ) {
        super( name, owner, duration );
        this.story = story;
        this.acting = acting;
    }

    public int getStoryRating() {
        return story;
    }

    public int getActingRating() {
        return acting;
    }

    public int getRating() {
        return Math.round( (float) ( ( story + acting ) / 2.0 ) );
    }

}
