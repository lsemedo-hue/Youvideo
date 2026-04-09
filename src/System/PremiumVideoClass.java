package System;

import dataStructures.Array;
import dataStructures.ArrayClass;

public class PremiumVideoClass extends PublishClassAbstract implements PremiumVideo {


    private Array<Subtitle> subtitles;

    public PremiumVideoClass(String id, int duration, String url, String publisher, String title, String language, String subtitleUrl, String subtitlelang) {
        super(id, duration, url);
        subtitles = new ArrayClass<>();
        // Adiciona logo a primeira legenda que veio no comando!
        this.addSubtitle(subtitlelang, subtitleUrl);
    }

    // guarda os subtitulo no array
    // coloquei esse metodo aqui mas acho que precisariamos da intenface Premium para colocar os metodos e também elle que seria responsal
    // para cumunicar com o exterior
    @Override
    public void addSubtitle(String lang, String url) {
        Subtitle newSub = new SubtitleRecord(lang, url);

        subtitles.insertLast(newSub);
    }


}
