package System;

public interface Podcast {
    /**
     * Gets Author name.
     * @return Author name
     */
    Author getAuthor();

    /**
     * Gets language Code.
     * @return language code
     */
    String getLangCode();

    /**
     * gets podcast title
     * @return Podcast title.
     */
    String getTitle();

    /**
     * Checks if a video exist.
     * @param EpisodeId Episode id
     * @return true if podcast exists.
     */
    boolean existEpisode(String EpisodeId);

    /**
     * Compares two strings//todo come up with a better comment
     * @param date
     * @return
     */
   int  isGreaterDate(String date);
}
