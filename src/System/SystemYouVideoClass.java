package System;
import java.util.Locale;
import dataStructures.Array;
import dataStructures.ArrayClass;
import dataStructures.Iterator;

public class SystemYouVideoClass implements SystemYouVideo {

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
            // ciclo do iterador
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

        @Override
        public void createPublishable(String iD, int duration, String url, String publisher, String title, String langCode) {
            Video basicVideo = new BasicVideoClass(iD,duration,url,publisher,title,langCode);
            videos.insertLast(basicVideo);
        }

        @Override
        public void createPremium(String iD, int duration, String url, String publisher, String title, String langCode, String subUrl, String subLang) {
            PremiumVideo premiumVideo = new PremiumVideoClass(iD,duration,url,publisher,title,langCode,subUrl,subLang);
            videos.insertLast(premiumVideo);
        }


        @Override
        public boolean isPremium(String iD) {
            Video v = getVideoByID(iD);
            return v instanceof PremiumVideo;
            // Se v for null, o instanceof devolve false automaticamente.
            // Se v for BasicClass, devolve false.
            // Só devolve true se for realmente Premium.
        }
        @Override
        public void addSubtitle(String id, String lang, String url) {
            Video v = getVideoByID(id);
            PremiumVideo pv = (PremiumVideo) v; //dizer ao Java: "Eu garanto que este vídeo é da classe Premium
            pv.addSubtitle(lang,url);
        }

    @Override
    public void getVideo(String id) {
        Iterator it = videos.iterator();
        while(it.hasNext()){
            Video video = it.next();
            if(isPremium(id)){
                System.out.println("Video %s %d Tile: %s",video.getId(),video.ge
            }
        }
    }


}
