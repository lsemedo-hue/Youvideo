package System;

public interface Author {
    /**
     * Adds a podcast into an author collection;
     * @param podcast Podcast
     */
    void addPodcast(Podcast podcast);

    /**
     * Return Author's name
     * @return Author name
     */
    String getAuthorName();
}
