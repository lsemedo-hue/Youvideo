package System;

import dataStructures.Array;
import dataStructures.ArrayClass;

public class PremiumVideoClass extends PublishableClass implements PremiumVideo {
    // A coleção que guarda todos os records de legendas
    private Array<Subtitle> subtitles;


    public PremiumVideoClass(String id, int duration, String url, String publisher, String title, String language, String subtitleUrl, String subtitlelang) {
        super(id, duration, url,publisher,title,language);

        // Inicializa o array (usando a classe de coleção)
        this.subtitles = new ArrayClass<>();

        this.addSubtitle(subtitlelang, subtitleUrl);//Adiciona logo a primeira legenda que veio no comando!


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
