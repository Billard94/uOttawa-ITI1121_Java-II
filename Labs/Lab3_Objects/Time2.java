public class Time2 {

    /** A constant to represent the number of hours per day
     */

    static public final int HOURS_PER_DAY      = 24;

    /** A constant to represent the number of minutes per hour
     */

    static public final int MINUTES_PER_HOUR   = 60;

    /** A constant to represent the number of seconds per minutes
     */

    static public final int SECONDS_PER_MINUTE = 60;

    /** A constant to represent the number of seconds in one hour
     */

    static public final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;

    /** A constant to represent the number of seconds in a day
     */

    static public final int SECONDS_PER_DAY = SECONDS_PER_HOUR * HOURS_PER_DAY;

    /** An instance variable to store the total number of seconds of
     *  this time object. This interval of values is 0..SECONDS_PER_DAY-1
     */

    private int timeInSeconds;

    /** This constructor initializes the instance variables of this
     *  Time2 object using the values of formal parameters hours,
     *  minutes and seconds.
     *
     *  @param hours the initial number of hours
     *  @param minutes the initial number of minutes
     *  @param seconds the initial number of seconds
     */

    public Time2(int hours, int minutes, int seconds) {

        timeInSeconds = (seconds + (minutes * SECONDS_PER_MINUTE) +
    (hours * SECONDS_PER_HOUR)) % SECONDS_PER_DAY;
    }

    /** An access method (getter) that returns the number of hours of
     *  this object.
     *
     *  @return returns the number of hours of this object
     */

    public int getHours() {
 return timeInSeconds / SECONDS_PER_HOUR;
    }

    /** An access method (getter) that returns the number of minutes of
     *  this object.
     *
     *  @return returns the number of minutes of this object
     */

    public int getMinutes() {
 return (timeInSeconds % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE;
    }

    /** An access method (getter) that returns the number of seconds of
     *  this object.
     *
     *  @return returns the number of seconds of this object
     */

    public int getSeconds() {
 return timeInSeconds % SECONDS_PER_MINUTE;
    }

    /** Returns a String representation of this Time2 object.
     *
     *  @return a String representation of this Time2 object
     */

    public String toString() {
 return getHours()+":"+getMinutes()+":"+getSeconds();
    }

    /** Returns a true if and only if other designates an object that
     *  has the same content as this Time2 object.
     *
     *  @param other is a reference to a Time2 object
     *  @return a String representation of this Time2 object
     */

    public boolean equals(Time2 other) {

 return other != null && timeInSeconds == other.timeInSeconds;

 // Alternative solution:
 //
 // return  other !=null && ((getHours()   == other.getHours())
 //     && (getMinutes() == other.getMinutes())
 //     && (getSeconds() == other.getSeconds()));
    }

    /** Increments by one second the time value represented by this
     *  object.
     */

    public void increase() {
 timeInSeconds = (timeInSeconds++) % SECONDS_PER_DAY;
    }

    /** Returns a new Time2 object that represents the sum of this
     *  time value and that of other.
     *
     *  @param other a reference to a Time2 object
     *  @return a new Time2 object represing the sum of this and other time value
     */

    public Time2 plus(Time2 other) {
        return new Time2(getHours()+other.getHours(), getMinutes()+other.getMinutes(),
                         getSeconds()+other.getSeconds());
    }

    /** Returns true if and only if this represents a time value that is before that of other.
     *
     *  @param other a reference to a Time2 object
     *  @return true if this time value is before other
     */

    public boolean before (Time2 other) {
 return timeInSeconds < other.timeInSeconds;

 // Alternative solution:
 //
 // return other != null &&
   //      (getHours()    < other.getHours()) ||
   //     ((getHours()   == other.getHours()) &&
   //      (getMinutes()  < other.getMinutes())) ||
   //     ((getHours()   == other.getHours()) && 
   //      (getMinutes() == other.getMinutes()) &&
   //      (getSeconds()  < other.getSeconds()));
    }

}