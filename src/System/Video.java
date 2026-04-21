package System;

public interface Video {

    /**
     * Returns ID of a video.
     * @return ID
     */
    String getId();

    /**
     * Returns the duration of a video.
     * @return  Duration of the video.
     */
    int getDuration();

    /**
     * Returns the file location of the video.
     * @return file location of the video.
     */
    String getFileLocation();

}
