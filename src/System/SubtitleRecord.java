package System;

public record SubtitleRecord(String subUrl, String subLanguage) implements Subtitle {

    @Override
    public String getLanguage() {
        return this.subLanguage;
    }
@Override
    public String getUrl() {
        return this.subUrl;
    }



}
