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
     * Check if ChangeMeValues were changed and if so launches main.
     * @param args command line args
     */
    public static void main(String[] args) {

        if (ChangeMeValues.BotToken == null || ChangeMeValues.sourceUrl == null){
            System.out.println("[ERROR] Values in ChangeMeValues class need to be changed before bot usage!");
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