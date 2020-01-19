package it.pusi77.meteopaviabot.bot;

import it.pusi77.meteopaviabot.Constants;
import it.pusi77.meteopaviabot.Debug;
import it.pusi77.meteopaviabot.weather.WeatherUpdater;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.Timer;

/**
 * Define Bot class overriding TelegramBots required methods.
*/
public class Bot extends TelegramLongPollingBot {
    private WeatherUpdater weatherUpdater;
    private Updater updater;
    private MessageReplier messageReplier;
    private Timer timer;

    /**
     * Every 2 hours download a it.pusi77.meteopaviabot.weather update using Updater(TimerTask).
     * MeteoAM data is update every 3 hours starting from 1.
     */
    public Bot() {
        System.out.println("Bot started");
        weatherUpdater = new WeatherUpdater();
        updater = new Updater(weatherUpdater);
        messageReplier = new MessageReplier(weatherUpdater);
        timer = new Timer(true); // run as daemon
        timer.scheduleAtFixedRate(updater, 1, Constants.TWO_HOURS);
    }

    /**
     * Implement required update method defining what to do on update.
     * @param update received update
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Debug.dPrintln(update.getMessage().getFrom().getUserName() +
                            " sent a message: " + update.getMessage().getText());

            try {
                execute(messageReplier.recognizeAndReply(update.getMessage()));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Implement required returning bot's username method.
     * @return bot's name
     */
    @Override
    public String getBotUsername() {
        return Constants.BOT_NAME;
    }

    /**
     * Implement required returning bot's token method.
     * @return bot's token
     */
    @Override
    public String getBotToken() {
        return Constants.BOT_TOKEN;
    }
}
