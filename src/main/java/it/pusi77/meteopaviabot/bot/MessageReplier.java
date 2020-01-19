package it.pusi77.meteopaviabot.bot;

import it.pusi77.meteopaviabot.Constants;
import it.pusi77.meteopaviabot.weather.TimeSlot;
import it.pusi77.meteopaviabot.weather.WeatherUpdater;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Identify and reply to messages, also manage virtual keyboards.
 */
public class MessageReplier {
    private WeatherUpdater weatherUpdater;
    private ReplyKeyboardMarkup daysKeyboard;
    private ReplyKeyboardMarkup timeSlotKeyboard;
    private String selectedDay;

    /**
     * Needs a it.pusi77.meteopaviabot.weather updater object as parameter to be able to access it.pusi77.meteopaviabot.weather data. Also launch the daysKeyboard init.
     * @param weatherUpdater weatherUpdater object
     */
    public MessageReplier(WeatherUpdater weatherUpdater) {
        this.weatherUpdater = weatherUpdater;
        daysKeyboard = new ReplyKeyboardMarkup();
        timeSlotKeyboard = new ReplyKeyboardMarkup();

        initDaysKeyboard();
    }

    /**
     * Recognize and reply to messages passed as parameter. At first tries to recognize known commands, then search for
     * correctly formatted dates.
     * @param message message to be analyzed
     * @return reply
     */
    SendMessage recognizeAndReply(Message message) {
        SendMessage reply = new SendMessage();
        reply.setText(null);

        // Check if message is a known command
        switch (message.getText()) {
            case "/start":
                reply.setText(DefaultReplies.welcome);
                reply.setReplyMarkup(daysKeyboard);
                break;
            case "/help":
                reply.setText(DefaultReplies.help);
                break;
            case "Indietro":
                reply.setText("Fatto");
                reply.setReplyMarkup(daysKeyboard);
                break;
        }

        // Check if message is a valid date in "nextFourDays" text format (from virtual keyboard)
        if (Arrays.asList(Constants.NEXT_FOUR_DAYS).contains(message.getText())) {
            int i = 0;
            while (!message.getText().equals(Constants.NEXT_FOUR_DAYS[i]) && i < Constants.NEXT_FOUR_DAYS.length) {
                i++;
            }
            selectedDay = weatherUpdater.getWeather().getWeatherDates()[i];
            timeSlotKeyboard(selectedDay);
            reply.setReplyMarkup(timeSlotKeyboard);
            reply.setText(weatherUpdater.getWeather().getPrintableOverview(weatherUpdater.getWeather().getWeatherDates()[i]));
        }

        // Check if message is in a valid date format
        else if (Arrays.asList(weatherUpdater.getWeather().getWeatherDates()).contains(message.getText())) {
            for (String date : weatherUpdater.getWeather().getWeatherDates()) {
                if (date.equals(message.getText())) {
                    selectedDay = date;
                    timeSlotKeyboard(selectedDay);
                    reply.setReplyMarkup(timeSlotKeyboard);
                    reply.setText(weatherUpdater.getWeather().getPrintableOverview(date));
                    break;
                }
            }
        }

        // Check if message is in valid TimeSlot format (from virtual keyboard)
        else if (message.getText().length() == 2 && Integer.parseInt(message.getText()) < 24) {
            String printableTimeSlot = (weatherUpdater.getWeather().getSpecificTimeSlot(selectedDay, message.getText()));
            reply.setText(printableTimeSlot);
        }


        // If message is not recognized
        if (reply.getText() == null) {
            reply.setText(DefaultReplies.unrecognized + "\n\n" + DefaultReplies.help);
        }


        reply.setChatId(message.getChatId());
        return reply;
    }

    /**
     * Initialize the daysKeyboard, a virtual keyboard with the next 4 days as buttons.
     */
    private void initDaysKeyboard() {
        List<KeyboardRow> keyboard;
        keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        keyboard.add(row);

        row.add(Constants.NEXT_FOUR_DAYS[0]);
        row.add(Constants.NEXT_FOUR_DAYS[1]);
        row.add(Constants.NEXT_FOUR_DAYS[2]);
        row.add(Constants.NEXT_FOUR_DAYS[3]);
        daysKeyboard.setKeyboard(keyboard);
    }

    /**
     * Generate a timeSlotKeyboard from a given date using that day TimeSlots as buttons.
     * @param date chosen date
     */
    private void timeSlotKeyboard(String date) {
        List<KeyboardRow> keyboard;
        keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardRow rowBack = new KeyboardRow();
        keyboard.add(row);
        keyboard.add(rowBack);

        for (TimeSlot timeSlot : weatherUpdater.getWeather().getTimeSlot(date)) {
            row.add(timeSlot.getValTimeOnlyHour());
        }
        rowBack.add("Indietro");
        timeSlotKeyboard.setKeyboard(keyboard);
    }
}
