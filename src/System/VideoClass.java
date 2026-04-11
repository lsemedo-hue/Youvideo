package System;

public abstract class VideoClass implements AllVideo {

    private String id;
    private int duration;
    private String fileLocation;
    private String publisher;
    private String title;
    private  String langCode;


    protected VideoClass(String id, int duration,String URL, String publisher, String title, String langCode){
        this.id = id;
        this.duration = duration;
        this.fileLocation = URL;
        this.publisher = publisher;
        this.langCode = langCode;
        this.title = title;
    }

    public boolean equals(Object other){
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof Video))
            return false;
        if(id == null)
            return false;
        return(id.equals(((Video) other).getId()));
    }

    public String getId(){
        return id;
    }

    public int getDuration(){
        return duration;
    }

    public String getFileLocation(){
        return fileLocation;
    }

    public String getFileLocation(){
        return this.fileLocation;
    }

    public String getPublisher() {
        return publisher;
    }


    public String getTitle() {
        return title;
    }


    public String getLanguage() {
        return langCode;
    }

}
