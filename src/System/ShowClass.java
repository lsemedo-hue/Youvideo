package System;

public class ShowClass extends PublishClassAbstract implements Show{
    protected ShowClass(String id, int duration, String URL) {
        super(id, duration, URL);
    }
}
