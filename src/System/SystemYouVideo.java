package System;

public interface SystemYouVideo {
    /**
     * Checks if a video already exists.
     * @param id Video ID

     * @return true if exists
     */
    boolean hasVideo(String id);

    /**
     * Devolve ID
     * @param id
     * @return ID
     */
    Video hasID (String id);

    /**
     * Checks if language code is valid.
     * @param langCode Language code
     * @return true if language code is valid
     */
    boolean isValidLangCode(String langCode);

    /**
     * Creates a publishable video.
     * @param iD ID of the video
     * @param duration Duration of the video
     * @param url File location
     * @param publisher Name of the publisher
     * @param title Name of the title
     * @param langCode Language code
     */
    void createPublishable(String iD, int duration, String url, String publisher, String title, String langCode);

    /**
     * Creates a premium video.
     * @param iD Id of the video
     * @param duration Duration of the video
     * @param url File location
     * @param publisher Name of the publisher
     * @param title Name of the title
     * @param langCode Language code
     * @param subUrl Subtitle file location
     * @param subLang Subtitle language code
     */
    void createPremium(String iD, int duration, String url, String publisher, String title, String langCode, String subUrl, String subLang);

    /**
     *
     * @param iD
     * @return
     */
    boolean isPremium(String iD);

    /**
     *
     * @param id
     * @param lang
     * @param url
     */
    void addSubtitle(String id, String lang, String url);


}
