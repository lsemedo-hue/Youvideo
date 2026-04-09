package System;

public abstract class PublishClassAbstract extends VideoClassAbstract implements PublishAbstract {
    protected PublishClassAbstract(String id, int duration, String URL) {
        super(id, duration, URL);
    }
}
