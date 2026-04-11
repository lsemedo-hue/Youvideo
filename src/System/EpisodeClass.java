package System;

public class EpisodeClass extends VideoClass {

    private String date;

    protected EpisodeClass(String id, int duration, String URL, String title, String publish, String langCode, String date) {
        super(id, duration, URL, publish, title, langCode);
        this.date = date;

    }

    public String getDate() {
        return date;
    }
}
