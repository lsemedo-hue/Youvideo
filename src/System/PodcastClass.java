package System;

import dataStructures.Array;
import dataStructures.ArrayClass;

    public class PodcastClass implements Podcast{
        private String title;
        private Author author;
        private  String langCode;

        private Array<EpisodeClass> episodes;//todo perguntar se devemos fzr casting : ((episodeClass)Video)

        public PodcastClass(String title, Author author, String langCode){
            this.title = title;
            this.author = author;
            this.langCode = langCode;
            this.episodes = new ArrayClass<>();
        }
        public PodcastClass(String title){
            this.title = title;
        }

        public boolean equals(Object other){
            if(this == other)
                return true;
            if(other == null)
                return false;
            if(!(other instanceof Podcast))
                return false;
            if(this.title == null)
                return false;
            return this.title.equals(((Podcast)other).getTitle());

        }


        @Override
        public String getTitle() {
            return this.title;
        }

        @Override
        public Author getAuthor() {
            return this.author;
        }

        @Override
        public String getLangCode() {
            return this.langCode;
        }

        public boolean existEpisode(String EpisodeId){
            EpisodeClass episode = new EpisodeClass(EpisodeId);//todo perguntar à professora se isso são boas práticas
            return episodes.searchForward(episode);
        }

        public int isGreaterDate(String date){
            String lastEpisodeStr = episodes.get(episodes.size()-1).getReleaseDate();
            return date.compareToIgnoreCase(lastEpisodeStr);
        }
    }
