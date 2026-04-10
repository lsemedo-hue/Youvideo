package System;

import dataStructures.Array;
import dataStructures.ArrayClass;

public class PremiumVideoClass extends PublishableClass implements PremiumVideo {
    private Array<Subtitle> subtitles;
    private String subtitleFile;
    private String subtitleLanguage;

    public PremiumVideoClass(String id, int duration, String url, String publisher, String title, String language, String subtitleUrl, String subtitlelang) {
        super(id, duration, url,publisher,title,language);
        subtitles = new ArrayClass<>();
        this.addSubtitle(subtitlelang, subtitleUrl);//Adiciona logo a primeira legenda que veio no comando!
        this.subtitleFile = subtitleUrl;
        this.subtitleLanguage = subtitlelang;

    }

    // guarda os subtitulo no array
    // coloquei esse metodo aqui mas acho que precisariamos da intenface Premium para colocar os metodos e também elle que seria responsal
    // para cumunicar com o exterior
    @Override
    public void addSubtitle(String lang, String url) {
        Subtitle newSub = new Subtitle(lang, url);
        subtitles.insertLast(newSub);
    }



}
