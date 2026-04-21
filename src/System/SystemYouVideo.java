package System;

import dataStructures.Iterator;

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
    Video getVideoByID (String id);

    /**
     * Checks if language code is valid.
     * @param langCode Language code
     * @return true if language code is valid
     */
    boolean isValidLangCode(String langCode);

    /**
     * Creates a publishable video.
     * @param id ID of the video
     * @param duration Duration of the video
     * @param url File location
     * @param publisher Name of the publisher
     * @param title Name of the title
     * @param langCode Language code
     */
    void createPublishable(String id, int duration, String url, String publisher, String title, String langCode);

    /**
     * Creates a premium video.
     * @param id Id of the video
     * @param duration Duration of the video
     * @param url File location
     * @param publisher Name of the publisher
     * @param title Name of the title
     * @param langCode Language code
     * @param subUrl Subtitle file location
     * @param subLang Subtitle language code
     */
    void createPremium(String id, int duration, String url, String publisher, String title, String langCode, String subUrl, String subLang);

    /**
     *
     * @param id
     * @return
     */
    boolean isPremium(String id);

    /**
     *Adds a subtitle into a video
     * @param id Video id.
     * @param lang Video language
     * @param url Video file location
     */
    void addSubtitle(String id, String lang, String url);


    /**
     * Returns language code in full
     * @param langCode Language code
     * @return
     */
    String getCompleteLanguage(String langCode);

    /**
     * Returns a subtitle iterator.
     * @param id ID
     * @return Subtitle iterator
     */
    Iterator<Subtitle> getSubIterator(String id);

    /**
     * Checks if there's a podcast with given title.
     * @param title Podcast title
     * @return true if podcast exists.
     */
    boolean hasPodcast(String title);

    /**
     * Adds podcast into the system.
     * @param title Podcast title
     * @param name Name of the author
     * @param langCode Language of the podcast
     */
    void addPodcast(String title, String name, String langCode);

    /**
     * Checks if an episode exits.
     * @param episodeId Episode id
     * @param podcastTitle Podcast title
     * @return true if episode exists
     */
    boolean hasEpisode(String episodeId,String podcastTitle);

    /**
     * Checks if a release date of an episode is valid.
     * @param date date
     * @param podcastTitle Podcast title
     * @return
     */
    boolean isValidDate(String date,String podcastTitle);
}
