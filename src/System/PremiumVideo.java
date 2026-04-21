package System;

import dataStructures.Iterator;

import java.util.Locale;

public interface PremiumVideo {
     /**
      * Adds subtitle to a premium video.
      * @param url Subtitle file location
      * @param lang Language of the subtitle
      */
     void addSubtitle(String url, Locale lang);

     /**
      * Returns a subtitle iterator.
      * @return subtitle iterator.
      */
     Iterator<Subtitle> getSubtitleIterator();
}




