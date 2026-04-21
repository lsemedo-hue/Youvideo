package System;

import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

import java.util.Locale;

public class PremiumVideoClass extends PublishableClass implements PremiumVideo {
    private Array<Subtitle> subtitles;
    private String subtitleFile;
    private Locale subtitleLanguage;

    public PremiumVideoClass(String id, int duration, String url, String publisher, String title, String language, String subtitleUrl, Locale subtitlelang) {
        super(id, duration, url,publisher,title,language);
        subtitles = new ArrayClass<>();
        this.addSubtitle(subtitleUrl,subtitlelang);
        this.subtitleFile = subtitleUrl;
        this.subtitleLanguage = subtitlelang;

    }


    @Override
    public void addSubtitle(String url, Locale lang) {
        Subtitle newSub = new Subtitle(url,lang);
        subtitles.insertLast(newSub);
    }
    public Iterator<Subtitle> getSubtitleIterator(){
        return subtitles.iterator();
    }



}
