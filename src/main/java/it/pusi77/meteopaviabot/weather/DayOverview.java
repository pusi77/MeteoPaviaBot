package it.pusi77.meteopaviabot.weather;

/**
 * Define a DayOverview format describing an entire day it.pusi77.meteopaviabot.weather. It has a lot of
 * attributes, i ignore some of them meaning, but they were on the MeteoAM JSON so
 * i included them.
 */
public class DayOverview {
    private String val;         //Weather date
    private String desc;        //Very short it.pusi77.meteopaviabot.weather description
    private String desc2;       //No idea, usually null
    private String img;         //Probably referred to app's images
    private String imgBig;      //Probably referred to app's images
    private String t_min;       //Minimum day temperature
    private String t_max;       //Maximum day temperature
    private String wint;        //Wind speed
    private String wintd;       //No idea, usually a small int value
    private String wintm;       //Wind source direction
    private String alarm;       //Not sure, usually null

    /**
     * Returns the date of a DayOverview instance.
     * @return the date of that instance.
     */
    public String getDate() {
        return val;
    }

    /**
     * Returns the description of a DayOverview instance.
     * @return the description of that instance.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Returns the minimum temperature of a DayOverview instance.
     * @return the minimum temperature of that instance.
     */
    public String getT_min() {
        return t_min;
    }

    /**
     * Returns the maximum temperature of a DayOverview instance.
     * @return the maximum temperature of that instance.
     */
    public String getT_max() {
        return t_max;
    }

    /**
     * Returns the wind speed of a DayOverview instance.
     * @return the wind speed temperature of that instance.
     */
    public String getWint() {
        return wint;
    }

    /**
     * Returns the wind source direction of a DayOverview instance.
     * @return the wind source direction temperature of that instance.
     */
    public String getWintm() {
        return wintm;
    }
}
