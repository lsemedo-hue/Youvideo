package System;

public interface Publishable extends AllVideo{
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
