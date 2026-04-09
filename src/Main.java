import System.*;
import java.util.Scanner;
import java.util.Locale;
public class Main {

    // Output messages
    private static final String EXIT_MSG = "Bye!";
    private static final String UNKNOWN_COMMAND_MSG = "Unknown command.";
    private static final String VIDEO_ADDED = "Video %s created successfully.";
    private static final String PREMIUM_VIDEO_ADDED = "PREMIUM video %s created successfully";
    private static final String VIDEO_ALREADY_EXISTS = "Video with this ID already exists.";
    private static final String INVALID_DURATION = "Invalid value.";
    private static final String INVALID_LANGUAGE = "Invalid language type.";
    private static final String INVALID_SUB_LANGUAGE_MSG = "Invalid language type in subtitle";
    private static final String VIDEO_DOES_NOT_EXIST = "Video does not exist.";
    private static final String NOT_PREMIUM_VIDEO = "Not a premium video."; //
    private static final String SUBTITLE_ADDED = "Subtitle added successfully."; // Legenda adicionada com sucesso
    private static final String PODCAST_ADDED = "Podcast added."; // Podcast criado com sucesso
    private static final String PODCAST_ALREADY_EXISTS = "Podcast already exists."; // Título de podcast já existe
    private static final String PODCAST_DOES_NOT_EXIST = "Podcast does not exist."; // Podcast não encontrado
    private static final String EPISODE_ADDED = "Episode added."; // Episódio adicionado com sucesso
    private static final String INVALID_DATE = "Invalid date."; // Data anterior ao último episódio
    private static final String NO_PODCASTS_BY_AUTHOR = "No podcasts by this author."; // Autor não tem podcasts
    private static final String SHOW_ADDED = "Show added."; // Show agendado com sucesso
    private static final String SHOW_ALREADY_EXISTS = "Show already exists."; // Título do show já existe
    private static final String SHOW_DOES_NOT_EXIST = "Show does not exist."; // Show não encontrado
    private static final String VIDEO_REMOVED = "Video removed."; // Vídeo apagado com sucesso
    private static final String PODCAST_REMOVED = "Podcast removed."; // Podcast apagado com sucesso
    private static final String SHOW_REMOVED = "Show removed."; // Show apagado com sucesso
    private static final String VIDEO_IN_USE = "Video is in use."; // Vídeo não pode ser removido (está num show/podcast)

    // Commands
    private static final String EXIT_CMD = "exit"; // Sair do programa
    private static final String HELP_CMD= "help"; // Mostrar comandos disponíveis
    private static final String CREATE_PUBLISHABLE_CMD = "createpublishable"; // Criar vídeo comum
    private static final String CREATE_PREMIUM_CMD = "createpremium"; // Criar vídeo premium
    private static final String ADD_SUBTITLE_CMD = "addsubtitle"; // Adicionar legenda
    private static final String GET_VIDEO_CMD = "getvideo"; // Obter detalhes de um vídeo
    private static final String SUBTITLES_CMD = "subtitles"; // Listar legendas de um vídeo
    private static final String CREATE_PODCAST_CMD = "createpodcast"; // Criar um podcast
    private static final String ADD_EPISODE_CMD = "addepisode"; // Adicionar episódio ao podcast
    private static final String GET_PODCAST_CMD = "getpodcast"; // Detalhes do podcast
    private static final String EPISODES_CMD = "episodes"; // Listar episódios
    private static final String AUTHOR_PODCASTS_CMD = "authorpodcasts"; // Podcasts de um autor
    private static final String REMOVE_PODCAST_CMD = "removepodcast"; // Remover podcast
    private static final String CREATE_SHOW_CMD = "createshow"; // Criar um show/programa
    private static final String GET_SHOW_CMD = "getshow"; // Detalhes do show
    private static final String REMOVE_SHOW_CMD= "removeshow"; // Remover um show
    private static final String REMOVE_VIDEO_CMD = "removevideo"; // Remover um vídeo


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SystemYouVideo yv = new SystemYouVideoClass();
        String cmd ;

        do{
            cmd = in.next().toLowerCase();
            switch(cmd){
                case HELP_CMD -> help();
                case CREATE_PUBLISHABLE_CMD -> createPublishableCmd(in,yv);
                case CREATE_PREMIUM_CMD -> CreatePremiumCmd(in,yv);
                case ADD_SUBTITLE_CMD -> addSubtitle(in,yv);

                case EXIT_CMD-> System.out.println(EXIT_MSG);
                default -> System.out.println(UNKNOWN_COMMAND_MSG); //se o comando for diferente dos que estão no switch vai aparecer o mensagem não é preciso metodo
            }
            in.nextLine();
        }while(!cmd.equals(EXIT_CMD));
        in.close();
    }

    /**
     * Creates a publishable video
     * @param in Scanner
     * @param yv YouVideo System
     */
    public static void createPublishableCmd(Scanner in, SystemYouVideo yv){
        String iD = in.next();
        int duration = in.nextInt();
        String URL = in.next();
        in.nextLine();
        String publisher = in.nextLine();
        String title = in.nextLine().trim(); // Lê o resto da linha como título, porque pode ser palavra separadas
        String langCode = in.nextLine().toLowerCase();// adicionei o toLowe porque os exemplos do enunciado usam letras
        // grandes e quando foi testar com letras grande dava erro
        // aqui substitui os if por else if, simplesmente pela estetica

        if(yv.hasID(iD) != null) {
            System.out.println(VIDEO_ALREADY_EXISTS);
        }
        else if(duration<=0){
            System.out.println(INVALID_DURATION);
        }
        else if(!yv.isValidLangCode(langCode)){
            System.out.println(INVALID_LANGUAGE);
        }
        else {
            yv.createPublishable(iD, duration, URL, publisher, title, langCode);
            System.out.printf(VIDEO_ADDED, iD);
        }
    }

    /**
     * Creates a premium video.
     * @param in Scanner
     * @param yv Youvideo network
     */
    public static void CreatePremiumCmd(Scanner in, SystemYouVideo yv ){
        String iD = in.next();
        int duration = in.nextInt();
        String URL = in.next();
        in.nextLine();
        String publisher = in.nextLine();
        String title = in.nextLine();
        String langCode = in.nextLine();
        String subUrl = in.nextLine();
        String subLang = in.nextLine();

        //retirei os return dentro dos if porque não é uma boa pratica
        // substitui os if por else if

        if(yv.hasID(iD)!=null) {//TODO rever método
            System.out.println(VIDEO_ALREADY_EXISTS);

        }
        else if(duration<=0){
            System.out.println(INVALID_DURATION);
        }
        else if(yv.isValidLangCode(langCode)){
            System.out.println(INVALID_LANGUAGE);

        }
        else if(yv.isValidLangCode(subLang)){
            System.out.println(INVALID_SUB_LANGUAGE_MSG);
        }
        else {
            yv.createPremium(iD, duration, URL, publisher, title, langCode, subUrl, subLang);
            System.out.printf(PREMIUM_VIDEO_ADDED, iD);
        }
    }

    public static void addSubtitle(Scanner in, SystemYouVideo yv){

        String iD,langCode,uRL;

        iD = in.next();
        langCode = in.next().toLowerCase();
        uRL = in.next();

        if (yv.hasID(iD) == null){
            System.out.println(VIDEO_DOES_NOT_EXIST);
        }
        else if(!yv.isPremium(iD)){
            System.out.println(NOT_PREMIUM_VIDEO);
        }
        else if (yv.isValidLangCode(langCode)){
            System.out.println(INVALID_SUB_LANGUAGE_MSG);
        }
        else {
            yv.addSubtitle(iD,langCode,uRL);
            System.out.println(SUBTITLE_ADDED);
        }


    }


    public static void help(){

        System.out.println(CREATE_PUBLISHABLE_CMD+ " - creates a new publishable video");
        System.out.println(CREATE_PREMIUM_CMD + " - creates a new premium video");
        System.out.println(ADD_SUBTITLE_CMD + " - adds a subtitle to a premium video");
        System.out.println(GET_VIDEO_CMD + " - shows the video information");
        System.out.println(SUBTITLES_CMD+ " - lists the subtitles of a premium video");
        System.out.println(CREATE_PODCAST_CMD + " - creates a new podcast");
        System.out.println(ADD_EPISODE_CMD + " - adds an episode to a podcast");
        System.out.println(GET_PODCAST_CMD + " - shows the podcast information");
        System.out.println(EPISODES_CMD + " - lists the episodes of a podcast");
        System.out.println(AUTHOR_PODCASTS_CMD + " - lists the podcasts of an author");
        System.out.println(REMOVE_PODCAST_CMD + " - removes a podcast");
        System.out.println(CREATE_SHOW_CMD + " - creates a new show");
        System.out.println(GET_SHOW_CMD + " - shows the show information");
        System.out.println(REMOVE_SHOW_CMD + " - removes a show");
        System.out.println(REMOVE_VIDEO_CMD + " - removes a video");
        System.out.println(HELP_CMD + " - shows the available commands");
        System.out.println(EXIT_CMD + " - terminates the execution of the program");
    }

}