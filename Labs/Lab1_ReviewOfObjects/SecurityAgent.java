public class SecurityAgent {

    // Instance variables.
    // A SecurityAgent is responsible for a particular DoorLock,
    // it must also memorize the secret Combination so that
    // it can re-activate the lock.

    private Combination secret;
    private DoorLock myLock;

    // Constructor.

    public SecurityAgent() {
        int first = (int) ( Math.random()*5 ) + 1;
        int second = (int) ( Math.random()*5 ) + 1;
        int third = (int) ( Math.random()*5 ) + 1;

        secret = new Combination( first,second,third );
        myLock = new DoorLock( secret );
    }

    // Give access to the dock; returns a reference
    // to the DoorLock object.

    public DoorLock getDoorLock() {
        return myLock;
    }

    // Re-activates the DoorLock.

    public void activateDoorLock() {
        myLock.activate( secret );
    }

}