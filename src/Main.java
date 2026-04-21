import System.*;
import dataStructures.Iterator;

import java.util.Scanner;
import java.util.Locale;
public class Main {

    // Output messages
    private static final String EXIT_MSG = "Bye!";
    private static final String UNKNOWN_COMMAND_MSG = "Unknown command.";
    private static final String VIDEO_ADDED = "Video %s created successfully.";
    private static final String PREMIUM_VIDEO_ADDED = "PREMIUM video %s created successfully";
    private static final String VIDEO_ALREADY_EXISTS = "Video with this ID already exists.";
    private static final String INVALID_DURATION_MSG = "Invalid value.";
    private static final String INVALID_LANGUAGE = "Invalid language type.";
    private static final String INVALID_SUB_LANGUAGE_MSG = "Invalid language type in subtitle.";
    private static final String VIDEO_DOES_NOT_EXIST = "Video does not exist.";
    private static final String NOT_PREMIUM_VIDEO = "This operation requires a Premium video.";
    private static final String SUBTITLE_ADDED = "Subtitle added successfully.";
    private static final String NO_VIDEO_MSG = "Publishable Video %s does not exist.";
    private static final String PODCAST_ADDED = "Podcast added.";
    private static final String PODCAST_ALREADY_EXISTS = "Podcast already exists.";
    private static final String PODCAST_DOES_NOT_EXIST = "Podcast does not exist.";
    private static final String EPISODE_ADDED = "Episode added successfully.";
    private static final String INVALID_DATE = "Invalid date.";
    private static final String NO_PODCASTS_BY_AUTHOR = "No podcasts by this author.";
    private static final String SHOW_ADDED = "Show added.";
    private static final String SHOW_ALREADY_EXISTS = "Show already exists.";
    private static final String SHOW_DOES_NOT_EXIST = "Show does not exist.";
    private static final String VIDEO_REMOVED = "Video removed.";
    private static final String PODCAST_REMOVED = "Podcast removed.";
    private static final String SHOW_REMOVED = "Show removed.";
    private static final String VIDEO_IN_USE = "Video is in use.";
    private static final String PREMIUM_VIDEO_MSG = "PREMIUM Video %s %d Tile: %s\n";
    private static final String BASIC_VIDEO_MSG = "Video %s %d Title: %s";
    private static final String GET_VIDEO_FORMAT_MSG = "File: %s Publisher: %s Language: %s\n";
    private static final String NO_PREMIUM_VIDEO_MSG = "No Premium Video with ID";
    private static final String SUB_PRINTF_MSG = "%s (%s)\n";

    // Commands
    private static final String EXIT_CMD = "exit";
    private static final String HELP_CMD= "help";
    private static final String CREATE_PUBLISHABLE_CMD = "createpublishable";
    private static final String CREATE_PREMIUM_CMD = "createpremium";
    private static final String ADD_SUBTITLE_CMD = "addsubtitle";
    private static final String GET_VIDEO_CMD = "getvideo";
    private static final String SUBTITLES_CMD = "subtitles";
    private static final String CREATE_PODCAST_CMD = "createpodcast";
    private static final String ADD_EPISODE_CMD = "addepisode";
    private static final String GET_PODCAST_CMD = "getpodcast";
    private static final String EPISODES_CMD = "episodes";
    private static final String AUTHOR_PODCASTS_CMD = "authorpodcasts";
    private static final String REMOVE_PODCAST_CMD = "removepodcast";
    private static final String CREATE_SHOW_CMD = "createshow";
    private static final String GET_SHOW_CMD = "getshow";
    private static final String REMOVE_SHOW_CMD= "removeshow";
    private static final String REMOVE_VIDEO_CMD = "removevideo";


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SystemYouVideo yv = new SystemYouVideoClass();
        String cmd ;

        do{
            cmd = in.next().toLowerCase();
            switch(cmd){
                case HELP_CMD -> help();
                case GET_VIDEO_CMD -> getVideoCmd(in,yv);
                case CREATE_PUBLISHABLE_CMD -> createPublishableCmd(in,yv);
                case CREATE_PREMIUM_CMD -> CreatePremiumCmd(in,yv);
                case ADD_SUBTITLE_CMD -> addSubtitle(in,yv);
                case SUBTITLES_CMD -> listSubtitleCmd(in,yv);
                case CREATE_PODCAST_CMD -> createPodcast(in,yv);
                case EXIT_CMD-> System.out.println(EXIT_MSG);
                default -> System.out.println(UNKNOWN_COMMAND_MSG);
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
        String id = in.next();
        int duration = in.nextInt();
        String URL = in.next();
        in.nextLine();
        String publisher = in.nextLine();
        String title = in.nextLine().trim();
        String langCode = in.nextLine().toUpperCase();


        if(yv.hasVideo(id)) {
            System.out.println(VIDEO_ALREADY_EXISTS);
            return;
        }
         if(duration<=0){
            System.out.println(INVALID_DURATION_MSG);
            return;
        }
         if(!yv.isValidLangCode(langCode)){
            System.out.println(INVALID_LANGUAGE);
            return;
        }
            yv.createPublishable(id, duration, URL, publisher, title, langCode);
            System.out.printf(VIDEO_ADDED,id);
    }

    /**
     * Creates a premium video.
     * @param in Scanner
     * @param yv YouVideo System
     */
    public static void CreatePremiumCmd(Scanner in, SystemYouVideo yv ){
        String id= in.next();
        int duration = in.nextInt();
        String URL = in.next();
        in.nextLine();
        String publisher = in.nextLine();
        String title = in.nextLine();
        String langCode = in.nextLine().toUpperCase();
        String subUrl = in.nextLine();
        String subLang = in.nextLine().toUpperCase();

        if(yv.hasVideo(id)) {
            System.out.println(VIDEO_ALREADY_EXISTS);
            return;
        }
         if(duration<=0){
            System.out.println(INVALID_DURATION_MSG);
            return;
        }
         if(!(yv.isValidLangCode(langCode))){
            System.out.println(INVALID_LANGUAGE);
            return;

        }
         if(!(yv.isValidLangCode(subLang))){
            System.out.println(INVALID_SUB_LANGUAGE_MSG);
            return;
        }
            yv.createPremium(id, duration, URL, publisher, title, langCode, subUrl, subLang);
            System.out.printf(PREMIUM_VIDEO_ADDED,id);
    }

    /**
     * Adds a subtitle to a premium video.
     * @param in Scanner
     * @param yv You Video System
     */
    public static void addSubtitle(Scanner in, SystemYouVideo yv){
       String id = in.next();
       String url = in.next();
       in.nextLine();
       String langCode = in.nextLine().toUpperCase();

        if (!(yv.hasVideo(id))){
            System.out.println(VIDEO_DOES_NOT_EXIST);
            return;
        }
         if(!yv.isPremium(id)){
            System.out.println(NOT_PREMIUM_VIDEO);
            return;
        }
         if (!yv.isValidLangCode(langCode)){
            System.out.println(INVALID_SUB_LANGUAGE_MSG);
            return;
        }
            yv.addSubtitle(id,url,langCode);
            System.out.println(SUBTITLE_ADDED);
    }

    /**
     * Gets video data.
     * @param in Scanner
     * @param yv YouVideo
     */
    public static void getVideoCmd(Scanner in, SystemYouVideo yv){
        String id = in.next();
        if(!(yv.hasVideo(id))){
            System.out.printf(NO_VIDEO_MSG,id);
            return;
        }
        Video video = yv.getVideoByID(id);
        if(yv.isPremium(id)){
            System.out.printf(PREMIUM_VIDEO_MSG,video.getId(),video.getDuration(),((Publishable)video).getTitle());
            System.out.printf(GET_VIDEO_FORMAT_MSG,video.getFileLocation(),((Publishable)video).getPublisher(),
                    yv.getCompleteLanguage(((Publishable)video).getLanguage()));
        }
    }

    /**
     * Lists all subtitles of a premium video
     * @param in Scanner
     * @param yv YouVideo System
     */
    public static void listSubtitleCmd(Scanner in, SystemYouVideo yv){
        String videoId = in.next();
        if(!yv.hasVideo(videoId)  || !yv.isPremium(videoId)){
            System.out.println(NO_PREMIUM_VIDEO_MSG);
            return;
        }
        Iterator<Subtitle> it = yv.getSubIterator(videoId);
        while(it.hasNext()){
            Subtitle subtitle = it.next();
            System.out.printf(SUB_PRINTF_MSG,subtitle.subUrl(),subtitle.subLanguage());
        }
    }

    /**
     * Creates a podcast in YouVideo
     * @param in Scanner
     * @param yv YouVideo
     */
    public static void createPodcast(Scanner in, SystemYouVideo yv){
        String title = in.next();
        in.nextLine();
        String name = in.nextLine();
        String langCode = in.next().toLowerCase();

        if(yv.hasPodcast(title)){
            System.out.println(PODCAST_ALREADY_EXISTS);
            return;
        }
        if(!yv.isValidLangCode(langCode)) {
            System.out.println(INVALID_LANGUAGE);
            return;
        }
        yv.addPodcast(title,name,langCode);
        System.out.println(PODCAST_ADDED);
    }

    /**
     * Adds an episode to a podcast.
     * @param in Scanner
     * @param yv YouVideo
     */
    public static void addEpisode(Scanner in, SystemYouVideo yv){
        String podcastTitle = in.next();
        String episodeId = in.next();
        int duration = in.nextInt();
        String url = in.next();
        in.nextLine();
        String date = in.nextLine();
        if(!yv.hasPodcast(podcastTitle)){
            System.out.println(PODCAST_DOES_NOT_EXIST);
            return;
        }
        if(yv.hasEpisode(episodeId,podcastTitle)){
            System.out.println("Episode ID already exists in the system.");
            return;
        }
        if(duration>=0){
            System.out.println(INVALID_DURATION_MSG);
        }
        if(!yv.isValidDate(date,podcastTitle)){
            System.out.println("Episode date must be >= than latest episode date.");
            return;
        }
        yv.addEpisode(podcastTitle,episodeId,duration,url,date);
        System.out.println(EPISODE_ADDED);

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