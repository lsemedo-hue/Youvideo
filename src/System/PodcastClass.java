package System;

import dataStructures.Array;
import dataStructures.ArrayClass;

public class PodcastClass implements Podcast{
   private String title;
   private String name_publish;
   private  String langCode;

    private Array<EpisodeClass> episodes;

   public PodcastClass(String title, String name_publish, String langCode){
       this.title = title;
       this.name_publish = name_publish;
       this.langCode = langCode;

       this.episodes = new ArrayClass<>();

   }


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getNamePublish() {
        return name_publish;
    }

    @Override
    public String getLangCode() {
        return langCode;
    }

}
