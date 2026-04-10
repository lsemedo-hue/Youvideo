package System;
import java.util.Locale;
import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

public class SystemYouVideoClass implements SystemYouVideo {
        private static final String PREMIUM_VIDEO_MSG = "PREMIUM Video %s %d Tile: %s";
        private static final String BASIC_VIDEO_MSG = "Video %s %d Title: %s";
        private static final String GET_VIDEO_FORMAT_MSG = "File: %s Publisher: %s Language: %s";
        private static final String [] languages = Locale.getISOLanguages();

        private static final int size = Locale.getISOLanguages().length;
        private Array<Video> videos;

        public SystemYouVideoClass(){
            videos = new ArrayClass<>();
        }


        @Override
        public boolean hasVideo(String id) {
            return false;
        }
        /** comentarios sobre o medodo criado
         * como podemos usar o ID varias vezes, e o ID é exclusivo,
         * crie esse metodo aqui que simplesmente verifica se já existe esse ID
         *
         */
        @Override
        public Video getVideoByID(String id) {//fixme: futaramente transitar para a forma que a prof faz a pesquisa. Utilizando "searchForward" e um objetp
            Iterator<Video> it = videos.iterator(); // cria o it com os videos "iterados"
            while (it.hasNext()){
                Video video_Id = it.next();
                if (video_Id.getId().equals(id)) //
                    return video_Id; // se encontrou retorna o Id
            }
            return null; // se não encontrou retorna vazio
        }

        @Override
        public boolean isValidLangCode(String langCode) {
            for(int i = 0; i < size;i++){
                if(languages[i].equals(langCode))
                    return true;
            }
            return false;
        }

    /**
     * Converte o código da língua para o nome completo;
     * @param langCode Language code
     * @return
     */
    private String getCompleteLanguage(String langCode){
            Locale lang = new Locale(langCode);
            return lang.getDisplayLanguage();
        }

        @Override
        public void createPublishable(String iD, int duration, String url, String publisher, String title, String langCode) {
            Video basicVideo = new BasicVideoClass(iD,duration,url,publisher,title,langCode);
            videos.insertLast(basicVideo);
        }


        @Override
        public void createPremium(String iD, int duration, String url, String publisher, String title, String langCode, String subUrl, String subLang) {
            Video premiumVideo = new PremiumVideoClass(iD,duration,url,publisher,title,langCode,subUrl,subLang);
            videos.insertLast(premiumVideo);
        }



        @Override
        public boolean isPremium(String iD) {
            Video v = getVideoByID(iD);
            return v instanceof PremiumVideo;
        }
        @Override
        public void addSubtitle(String id, String lang, String url) {
            Video v = getVideoByID(id);
            PremiumVideo pv = (PremiumVideo) v; //dizer ao Java: "Eu garanto que este vídeo é da classe Premium
            pv.addSubtitle(lang,url);
        }

    @Override
    public void getVideo(String id) { //TODO estou na dúvida se devo colocar o print aqui. Caso contrário teria que criar métodos que iam me retornar
            //todo as variáveis para a main. Talvez mude, e vou perguntar isso na prof.
          Video video =  getVideoByID(id);
            if(isPremium(id)){
                System.out.printf(PREMIUM_VIDEO_MSG,video.getId(),video.getDuration(),video.getTitle());
                System.out.printf(GET_VIDEO_FORMAT_MSG,video.getFileLocation(),video.getPublisher(),getCompleteLanguage(video.getLanguage()));
            }
            else {
                System.out.printf(BASIC_VIDEO_MSG, video.getId(), video.getDuration(), video.getTitle());
                System.out.printf(GET_VIDEO_FORMAT_MSG,video.getFileLocation(),video.getPublisher(),getCompleteLanguage(video.getLanguage()));
            }
    }



}
