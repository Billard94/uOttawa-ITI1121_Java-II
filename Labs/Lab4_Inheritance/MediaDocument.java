public abstract class MediaDocument extends Document {

    private int duration;

    public MediaDocument( String name, String owner, int duration ) {
        super( name, owner );
        this.duration = duration;
    }

    public abstract int getRating();

}
