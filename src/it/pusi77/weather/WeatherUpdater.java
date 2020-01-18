package it.pusi77.weather;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import it.pusi77.ChangeMeValues;
import it.pusi77.Debug;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Update the Weather object using MeteoAM JSON data. It use jsonReader from Google's GSON
 * to get information from the http stream. The "main" Weather is instanced here.
 */
public class WeatherUpdater {
    private URL url;
    private HttpURLConnection conn;
    private Gson gson;
    private JsonReader jsonReader;
    private Weather weather;

    /**
     * Initialize the url with the url specified in Constant class and.
     */
    public WeatherUpdater() {
        try {
            this.url = new URL(ChangeMeValues.sourceUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Download updated informations from MeteoAM url and read them with jsonReader.
     * @throws IOException
     */
    public void downloadUpdate() throws IOException {
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        /* The APIs probably allow only mobile devices to download data, so i copied the
        * user-agent of my old Redmi Note 2, i loved that phone*/
        conn.setRequestProperty("User-Agent", "Dalvik/2.1.0(Linux; U; Android 5.2.2; Redmi Note 2 Build/LMY49J)");
        conn.setRequestProperty("Accept", "application/json");
        conn.connect();
        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            Debug.dPrintln("Http connection established (200)");
            jsonReader = new JsonReader((new InputStreamReader(conn.getInputStream())));

            gson = new Gson();
            weather = gson.fromJson(jsonReader, Weather.class);
        }
        if (Debug.debug) {
            Debug.dPrintln("Http response:");
            Map<String, List<String>> map = conn.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                System.out.println("    " + entry.getKey() + ": " + entry.getValue());
            }

            Debug.dPrintln("Weather downloaded for:");
            for (String date : weather.getWeatherDates()) {
                System.out.println("    " + date);
            }
        }
    }

    /**
     * Returns the updated weather.
     * @return the updated weather
     */
    public Weather getWeather() {
        return weather;
    }
}