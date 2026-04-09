package System;

public interface AllVideo extends Video{

    /**
     * returns ID of a video.
     * @return ID
     */
    String getId();

    /**
     * Compares two objects based of their ID.
     * @param other   the reference object with which to compare.
     * @return true if both have the same ID.
     */

    boolean equals(Object other);

    /**
     *returns duration of a video.
     * @return duration
     */
    int getDuration();

}
