package System;
private String title;
private String title;
private String language;

public abstract class PublishableClass extends VideoClass implements Publishable {
    protected PublishableClass(String id, int duration, String URL,String title,String publisher, String language) {
        super(id, duration, URL);
        this.title = title;
        this.publisher = publisher;
        this.language = language;
    }
}
