package System;


public  class PublishableClass extends AbstractVideo implements Publishable {
    private String title;
    private String publisher;
    private String language;

    public PublishableClass(String id, int duration, String URL,String title,String publisher, String language) {
        super(id, duration, URL);
        this.title = title;
        this.publisher = publisher;
        this.language = language;
    }
    public PublishableClass(String id){
        super(id);
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
