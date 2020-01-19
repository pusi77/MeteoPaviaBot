package it.pusi77.meteopaviabot;

/**
 * Contains some constants.
 */
public class Constants {

    /**
     * Your personal bot token from BotFather.
     */
    public static String BOT_TOKEN = null;

    /**
     * Since i'm using a private API i'm not sure if i can share it, just sniff the app
     * traffic and put the url here.
     */
    public static String SOURCE_URL = null;

    /**
     * The searchable bot's name.
     */
    public static  String BOT_NAME = "meteopaviabot";

    /**
     * 2 hours in millis.
     */
    public static final int TWO_HOURS = 2*60*60*1000;

    /**
     * An array with the next 4 days italian names. The fourth isn't correct, but i like it.
     */
    public static final String[] NEXT_FOUR_DAYS = {"Oggi", "Domani", "Dopodomani", "Dopodopodomani"};


    public static void initConstants(String token, String url) {
        BOT_TOKEN = token;
        SOURCE_URL = url;
    }
}
