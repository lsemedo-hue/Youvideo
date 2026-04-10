package System;

public interface SystemYouVideo {

    /**
     * Devolve ID
     * @param id
     * @return ID
     */
    Video getVideoByID (String id);

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
     * Check if the video is premium.
     * @param iD
     * @return
     */
    boolean isPremium(String iD);

    /**
     *Adds a subtitle into a video
     * @param id Video id.
     * @param lang Video language
     * @param url Video file location
     */
    void addSubtitle(String id, String lang, String url);

    /**
     * Gets a video description.
     * @param id Video id
     */
    void getVideo(String id);

    /**
     * add a new podcast
     * @param title
     * @param name
     * @param langCode
     */
    void addPodcast(String title, String name, String langCode);

    /**
     * Check if the podcast title already exists.
     * @param title
     * @return
     */
    boolean has_Podcast(String title);

    /**
     * add a new episode in podcast
     * @param name_podcast
     * @param ID
     * @param duration
     * @param URL
     * @param data
     */
    void addEpisode(String name_podcast,String ID, int duration, String URL, String data);

}
