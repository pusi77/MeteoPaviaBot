package it.pusi77.meteopaviabot.bot;

import it.pusi77.meteopaviabot.Debug;
import it.pusi77.meteopaviabot.weather.WeatherUpdater;

import java.io.IOException;
import java.util.TimerTask;

/**
 * It's an extension of TimerTask, launch a new it.pusi77.meteopaviabot.weather update.
 */
public class Updater extends TimerTask {
    private WeatherUpdater weatherUpdater;

    /**
     * Create an Updater using passed weatherUpdater instance.
     * @param weatherUpdater weatherUpdater instance
     */
    public Updater(WeatherUpdater weatherUpdater) {
        this.weatherUpdater = weatherUpdater;
    }

    /**
     * Run the update task. See TimerTask doc.
     */
    @Override
    public void run() {
        System.out.println("Update called");
        try {
            weatherUpdater.downloadUpdate();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        Debug.dPrintln("Update done");
    }
}
