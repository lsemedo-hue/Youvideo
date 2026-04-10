package System;

public class EpisodeClass extends VideoClass {

    private String releaseDate;


    public EpisodeClass(String id, int duration, String URL,String date) {
        super(id, duration, URL);
        this.releaseDate = date;
    }

    @Override
    public String getPublisher() {
        return "";
    }

    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public String getLanguage() {
        return "";
    }
}
