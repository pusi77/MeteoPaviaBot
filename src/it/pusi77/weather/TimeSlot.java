package it.pusi77.weather;

/**
 * Define a TimeSlot format describing weather in a few hours time window. It has a lot
 * of attributes, i ignore some of them meaning, but they were on the MeteoAM JSON so i
 * included them.
 */
public class TimeSlot {
    private String val;         //Day and Time
    private String valh;        //Time (only 2 digit hour)
    private String desc;        //Very short weather description
    private String img;         //Probably referred to app's images
    private String imgBig;      //Probably referred to app's images
    private String tp;          //Often equals to t
    private String t;           //Probably temperature
    private String wint;        //Wind speed
    private String wintd;
    private String wintm;       //Wind source direction
    private String r;

    /**
     * Default constructor set everything null.
     */
    public TimeSlot() {
    }

    /**
     * Return only the date, and not the time, of the TimeSlot.
     * @return date
     */
    public String getValDateOnly() {
        // This could be implemented better, it rely on the json format.
        return val.substring(0, 10);
    }

    /**
     * Return only the time, and not the date, of the TimeSlot. In 2 digits format.
     * @return time
     */
    public String getValTimeOnlyHour() {
        return valh;
    }

    /**
     * Return a very short description of the TimeSlot weather.
     * @return description
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Return TimeSlot's temperature.
     * @return temperature
     */
    public String getTemperature() {
        return t;
    }

    /**
     * Return TimeSlot's wind speed.
     * @return wind speed
     */
    public String getWindSpeed() {
        return wint;
    }

    /**
     * Return TimeSlot's wind source direction.
     * @return wind source direction
     */
    public String getWintSource() {
        return wintm;
    }

    /**
     * Return a printable weather for the TimeSlot.
     * @return printable weather
     * */
    public String getPrintableWeather() {
        String slotWeather = (
                "Previsioni per " + getValDateOnly() + " ore " + valh + ":\n" +
                getDesc() + "\n" +
                "Temperatura: " + t + "\n" +
                "Vento a " + wint + " proveniente da " + wintm
        );
        return slotWeather;
    }
}
