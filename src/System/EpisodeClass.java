package System;

public class EpisodeClass extends VideoClass {

    private String date;


    public EpisodeClass(String id, int duration, String URL, String title,
                        String publisher, String langCode, String date) {
        super(id,duration,URL,publisher, title, langCode);
        this.date = date;
    }


    public String getDate() {
        return date;
    }

}
