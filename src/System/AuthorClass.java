package System;

import dataStructures.Array;
import dataStructures.ArrayClass;

public class AuthorClass implements Author{
    private String name;
    private Array<Podcast> podcasts;


    public AuthorClass (String name){
        this.name = name;
        podcasts = new ArrayClass<>();
    }

    public void addPodcast(Podcast podcast){
        podcasts.insertLast(podcast);
    }
    public boolean equals(Object other){
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(!(other instanceof Author))
            return false;
        if(this.name == null)
            return false;
        return this.name.equals(((Author)other).getAuthorName());
    }

    public String getAuthorName(){
        return this.name;
    }
}
