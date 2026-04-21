package System;
import java.util.Locale;
import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

public class SystemYouVideoClass implements SystemYouVideo {
    //Constants

        private static final String [] languages = Locale.getISOLanguages();
        private static final int size = Locale.getISOLanguages().length;
        private static final int NOT_FOUND = -1;


        private Array<Video> videos;
        private Array<Podcast> podcasts;
        private Array<Author> authors;

        public SystemYouVideoClass(){
            videos = new ArrayClass<>();
            podcasts = new ArrayClass<>();
        }

        @Override
        public boolean hasVideo(String id) {
            Video video = new PublishableClass(id);
            return videos.searchForward(video);
        }

        @Override
        public Video getVideoByID(String id) {
            Video video = new PublishableClass(id);
            int pos = videos.searchIndexOf(video);
            if(pos == NOT_FOUND) {
                return null;
            }
            return videos.get(pos);
        }

        @Override
        public boolean isValidLangCode(String langCode) {
            for(int i = 0; i < size;i++){
                if(languages[i].equals(langCode.toLowerCase()))
                    return true;
            }
            return false;
        }

    public String getCompleteLanguage(String langCode){
            Locale lang = new Locale(langCode);
            return lang.getDisplayLanguage();
        }

        @Override
        public void createPublishable(String iD, int duration, String url, String publisher, String title, String langCode) {
            Video basicVideo = new PublishableClass(iD,duration,url,publisher,title,langCode);
            videos.insertLast(basicVideo);
        }


        @Override
        public void createPremium(String iD, int duration, String url, String publisher, String title, String langCode, String subUrl, String subLang) {
            Video premiumVideo = new PremiumVideoClass(iD,duration,url,publisher,title,langCode,subUrl, getLocale(subLang));
            videos.insertLast(premiumVideo);
        }

        @Override
        public boolean isPremium(String iD) {
            Video video = getVideoByID(iD);
            return video instanceof PremiumVideo;
        }
        @Override
        public void addSubtitle(String id, String lang, String url) {
            Video video = getVideoByID(id);
            PremiumVideo pVideo = (PremiumVideo) video;
            pVideo.addSubtitle(lang,getLocale(lang));
        }

    /**
     * Returns Locale object of a language
     * @param langCode Language code
     * @return Locale of a language
     */
    private Locale getLocale(String langCode){
            Locale lang = Locale.forLanguageTag(langCode);
            return lang;
        }

        public Iterator<Subtitle>  getSubIterator(String id){
            return ((PremiumVideo)getVideoByID(id)).getSubtitleIterator();
        }

    @Override
        public void addPodcast(String title, String name, String langCode) {
            if(getAuthorbyName(name)!=null){
              Author author =  getAuthorbyName(name);
              Podcast newPodcast = new PodcastClass(title, author, langCode);
              podcasts.insertLast(newPodcast);
              author.addPodcast(newPodcast);//fixme pq daria null???
            }
            else {
                Author author = new AuthorClass(name);
                Podcast newPodcast = new PodcastClass(title, author, langCode);
                podcasts.insertLast(newPodcast);
                author.addPodcast(newPodcast);
                authors.insertLast(author);
            }
    }

    private Author getAuthorbyName (String name){
        Author dummyAuthor = new AuthorClass(name);
        int pos = authors.searchIndexOf(dummyAuthor);
        if(pos == NOT_FOUND){
            return null;
        }
        return authors.get(pos);
    }


    @Override
    public boolean hasEpisode(String episodeId,String podcastTitle) {
        return getPodcast(podcastTitle).existEpisode(episodeId);//fixme pq que dá warning
    }

    @Override
    public boolean isValidDate(String date,String PodcastTitle) {
        return getPodcast(PodcastTitle).isGreaterDate(date)>= 0;//fixme pq daria null??
    }

    private Podcast getPodcast(String title){
        Podcast podcast = new PodcastClass(title);
        int pos = podcasts.searchIndexOf(podcast);
        if(pos == NOT_FOUND) {
            return null;
        }
        return podcasts.get(pos);
    }

    public boolean hasPodcast(String title) {
        Podcast podcast = new PodcastClass(title);// criei novo construtor para a pesquisa
        return podcasts.searchForward(podcast);// método ja retorna true or null caso encontre ou não
    }






}
