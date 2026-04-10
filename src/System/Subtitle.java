package System;

public record Subtitle(String subUrl, String subLanguage) {

    public String getLanguage() {
        return this.subLanguage;
    }

    public String getUrl() {
        return this.subUrl;
    }



}
