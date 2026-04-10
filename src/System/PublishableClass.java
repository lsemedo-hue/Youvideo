package System;


public abstract class PublishableClass extends VideoClass implements Publishable {
    private String title;
    private String publisher;
    private String language;

    protected PublishableClass(String id, int duration, String URL,String title,String publisher, String language) {
        super(id, duration, URL);
        this.title = title;
        this.publisher = publisher;
        this.language = language;
    }

    public String getPublisher(){
        return this.publisher;
    }

    public String getTitle(){
        return this.title;
    }
    public String getLanguage(){
        return this.language;
    }
}
