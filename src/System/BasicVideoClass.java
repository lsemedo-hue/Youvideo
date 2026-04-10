package System;

public class BasicVideoClass extends PublishableClass{

    private String publisher;
    private String title;
    private String langCode;


    public BasicVideoClass(String id,int duration,String url,String publisher,String title, String language){
        super(id,duration,url);

        this.publisher = publisher;
        this.title = title;
        this.langCode = language;


    }



}
