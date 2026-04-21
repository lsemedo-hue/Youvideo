package System;

public abstract class AbstractVideo implements AllVideo {

    private String id;
    private int duration;
    private String fileLocation;


    protected AbstractVideo(String id, int duration, String URL){
        this.id = id;
        this.duration = duration;
        this.fileLocation = URL;
    }
    protected AbstractVideo(String id){
        this.id = id;
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
        return this.id;
    }

    public int getDuration(){
        return this.duration;
    }

    public String getFileLocation(){
        return this.fileLocation;
    }

}
