package it.pusi77;

import it.pusi77.bot.Bot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Only contains main method.
 */
public class Main {

    /**
     * Check token and url args and if present write them in Constants.
     * @param args command line args botToken and sourceUrl
     */
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("No arguments found! You need pass bot token and MeteoAM url.\n" +
                                "Eg: java -jar MeteoPaviaBot.jar TOKEN123456789 http://somesite.something/data.json");
            System.exit(1);
        } else if (args[0] != null && args[1] != null) {
            Constants.initConstants(args[0], args[1]);
        }

        ApiContextInitializer.init();       //Initialize Api Context
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}