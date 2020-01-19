package it.pusi77.meteopaviabot.weather;

/**
 * Define a Weather format composed by the DayOverview and 4 days divided in TimeSlots
 * of the next 4 days. This format follows the JSON structure by MeteoAM, in this way it
 * is possible to use Google's GSON library to automatically read the file.
 */
public class Weather {
    private DayOverview[] hp;
    private TimeSlot[] day1;
    private TimeSlot[] day2;
    private TimeSlot[] day3;
    private TimeSlot[] day4;
    private String avvisi;

    /**
     * Default constructor set everything null.
     */
    public Weather() {
    }

    /**
     * Returns a printable DayOverview from a given date.
     * @param date  must be in "YYYY-MM-DD" format
     * @return a printable string of the DayOverview
     */
    public String getPrintableOverview(String date) {
        DayOverview chosenDay = null;
        for (DayOverview dayOverview : hp) {
            if (date.equals(dayOverview.getDate())) {
                chosenDay = dayOverview;
                break;
            }
        }
        if (chosenDay == null) {
            System.out.println("[ERROR] " + date + " not present in it.pusi77.meteopaviabot.weather data");
        }
        String todayOverview = (    "Previsioni per " + chosenDay.getDate() + ":\n" +
                                    chosenDay.getDesc() + "\n" +
                                    "Minima/Massima: " + chosenDay.getT_min() + "/" + chosenDay.getT_max() + "\n" +
                                    "Vento a " + chosenDay.getWint() + "Km/h proveniente da " + chosenDay.getWintm());
        return todayOverview;
    }

    /**
     * Return an array with all it.pusi77.meteopaviabot.weather dates found in the json.
     * @return array of dates found in json
     */
    public String[] getWeatherDates() {
        int i = 0;
        String[] array = new String[hp.length];
        for (DayOverview dayOverview : hp) {
            array[i] = dayOverview.getDate();
            i++;
        }
        return array;
    }

    /**
     * Return all the TimeSlots from a given date.
     * @param date chosen date
     * @return all the TimeSlots on that date
     */
    public TimeSlot[] getTimeSlot(String date) {
        TimeSlot[][] array = {day1, day2, day3, day4};
        for (TimeSlot[] timeSlotArray : array) {
            if (timeSlotArray[0].getValDateOnly().equals(date)) {
                return timeSlotArray;
            }
        }
        return null;
    }

    /**
     * Return a specific TimeSlot on a certain date and time.
     * @param date chosen date
     * @param time chosen time
     * @return specified TimeSlot
     */
    public String getSpecificTimeSlot(String date, String time) {
        TimeSlot[][] array = {day1, day2, day3, day4};
        for (TimeSlot[] timeSlotArray : array) {
            if (timeSlotArray[0].getValDateOnly().equals(date)) {
                for (TimeSlot timeSlot : timeSlotArray) {
                    if (timeSlot.getValTimeOnlyHour().equals(time)) {
                        return timeSlot.getPrintableWeather();
                    }
                }
            }
        }
        return null;
    }
}
