package System;

public class EpisodeClass extends AbstractVideo {

    private String releaseDate;


    public EpisodeClass(String id, int duration, String URL,String date) {
        super(id, duration, URL);
        this.releaseDate = date;
    }

    public EpisodeClass (String id){
        super(id);
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

}
