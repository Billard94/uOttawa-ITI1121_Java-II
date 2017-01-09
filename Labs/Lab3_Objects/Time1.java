public class Time1 {

    /** A constant to represent the number of hours per day
     */

    static public final int HOURS_PER_DAY      = 24;

    /** A constant to represent the number of minutes per hour
     */

    static public final int MINUTES_PER_HOUR   = 60;

    /** A constant to represent the number of seconds per minutes
     */

    static public final int SECONDS_PER_MINUTE = 60;

    /** An instance variable to store the number of hours of this
     *  Time1 object.  The range of valid values is 0..23.
     */

    private int hours;

    /** An instance variable to store the number of minutes of this
     *  Time1 object.  The range of valid values is 0..59.
     */

    private int minutes;

    /** An instance variable to store the number of minutes of this
     *  Time1 object. The range of valid values is 0..59.
     */

    private int seconds;

    /** This constructor initializes the instance variables of this
     *  Time1 object using the values of formal parameters hours,
     *  minutes and seconds.
     *
     *  @param hours the initial number of hours
     *  @param minutes the initial number of minutes
     *  @param seconds the initial number of seconds
     */

    public Time1(int hours, int minutes, int seconds) {

        this.seconds = seconds % SECONDS_PER_MINUTE ;

        int m = (seconds / SECONDS_PER_MINUTE) + minutes ;
        this.minutes = m % MINUTES_PER_HOUR ;

        this.hours = ((m / MINUTES_PER_HOUR) + hours) % HOURS_PER_DAY ;
    }

    /** An access method (getter) that returns the number of hours of
     *  this object.
     *
     *  @return returns the number of hours of this object
     */

    public int getHours() {
 return hours ;
    }

    /** An access method (getter) that returns the number of minutes of
     *  this object.
     *
     *  @return returns the number of minutes of this object
     */

    public int getMinutes() {
 return minutes ;
    }

    /** An access method (getter) that returns the number of seconds of
     *  this object.
     *
     *  @return returns the number of seconds of this object
     */

    public int getSeconds() {
 return seconds ;
    }

    /** Returns a String representation of this Time1 object.
     *
     *  @return a String representation of this Time1 object
     */

    public String toString() {
 return hours + ":" + minutes + ":" + seconds;
    }

    /** Returns a true if and only if other designates an object that
     *  has the same content as this Time1 object.
     *
     *  @param other is a reference to a Time1 object
     *  @return a String representation of this Time1 object
     */

    public boolean equals(Time1 other) {
 return  other != null && (hours == other.getHours())  && (minutes == other.getMinutes()) && (seconds == other.getSeconds());
    }

    /** Increments by one second the time value represented by this
     *  object.
     */

    public void increase() {
 seconds++ ;
 int carry = seconds / SECONDS_PER_MINUTE ;
 seconds = seconds % SECONDS_PER_MINUTE ;
 minutes = minutes + carry ;
 carry = minutes / MINUTES_PER_HOUR ;
 minutes = minutes % MINUTES_PER_HOUR ;
 hours = (hours + carry) % HOURS_PER_DAY ;
    }

    /** Returns a new Time1 object that represents the sum of this
     *  time value and that of other.
     *
     *  @param other a reference to a Time1 object
     *  @return a new Time1 object represing the sum of this and other time value
     */

    public Time1 plus(Time1 other) {

        return new Time1(hours+other.getHours(), minutes+other.getMinutes(),
                         seconds+other.getSeconds());
    }

    /** Returns true if and only if this represents a time value that is before that of other.
     *
     *  @param other a reference to a Time1 object
     *  @return true if this time value is before other
     */

    public boolean before (Time1 other) {

        return (hours  < other.getHours()) ||
     ((hours == other.getHours()) && (minutes < other.getMinutes() )) ||
     ((hours == other.getHours()) && (minutes == other.getMinutes()) &&
      (seconds < other.getSeconds() )) ;
    }
}