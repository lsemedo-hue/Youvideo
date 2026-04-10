package System;

public abstract class PublishableClass extends VideoClass implements Publishable {
    protected PublishableClass(String id, int duration, String URL) {
        super(id, duration, URL);
    }
}
