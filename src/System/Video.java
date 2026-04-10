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


    /**
     * Returns the publisher of a video;
     * @return
     */
    String getPublisher();

    /**
     * Returns title of the video.
     * @return title of the video.
     */
    String getTitle();

    /**
     * Returns language of the video.
     * @return language of the video.
     */
    String getLanguage();


}
